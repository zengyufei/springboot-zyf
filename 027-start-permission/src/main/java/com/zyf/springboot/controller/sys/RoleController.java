package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.mapper.Condition;
import com.google.common.collect.Lists;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.middle.RolePermission;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.service.sys.middle.RolePermissionService;
import com.zyf.springboot.vo.sys.PermissionVo;
import com.zyf.springboot.vo.sys.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 角色控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
@RequestMapping("role")
public class RoleController extends AbstractControllerVo<Role, RoleVo> {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 条件查询单个
     */
    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        RoleVo roleVo = this.service.selectVoById(id);

        /* 关联权限信息 */
        List<Permission> permissions = this.rolePermissionService.selectFromListByPrimaryId(roleVo.getId());
        List<PermissionVo> permissionVos = this.orikaMapper.convertList(permissions, PermissionVo.class);
        roleVo.setPermissionVos(permissionVos);
        return Msg.ok(roleVo);
    }

    /**
     * 分页条件查询集合
     */
    @PostMapping("list")
    public Msg list(@RequestBody RoleVo roleVo) {
        roleVo = Optional.ofNullable(roleVo).orElse(new RoleVo());
        return this.roleService.list(roleVo);
    }

    @GetMapping("all")
    public Msg all() {
        return Msg.ok(this.service.selectVoList(Condition.EMPTY));
    }

    /**
     * 新增
     */
    @PostMapping
    public Msg add(@RequestBody RoleVo roleVo) {
        roleVo = Optional.ofNullable(roleVo).orElse(new RoleVo());
        return this.roleService.addRole(roleVo);
    }

    /**
     * 全量修改
     */
    @PutMapping
    public Msg updateAllColumn(@RequestBody RoleVo roleVo) {
        roleVo = Optional.ofNullable(roleVo).orElse(new RoleVo());
        return this.roleService.updateAllColumnRole(roleVo);
    }

    /**
     * 局部修改
     */
    @PatchMapping
    public Msg update(@RequestBody RoleVo roleVo) {
        roleVo = Optional.ofNullable(roleVo).orElse(new RoleVo());
        return this.roleService.updateRole(roleVo);
    }

    @PutMapping("rolePermission")
    public Msg updateRoleOperation(@RequestBody List<RolePermission> roleOperations) {
        roleOperations = Optional.ofNullable(roleOperations).orElse(Lists.newArrayList());
        return this.rolePermissionService.updateRolePermission(roleOperations);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        return this.roleService.deleteRole(id);
    }

}

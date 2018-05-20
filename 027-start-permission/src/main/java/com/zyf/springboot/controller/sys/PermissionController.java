package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.mapper.Condition;
import com.google.common.collect.Lists;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Operation;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.entity.sys.middle.PermissionOperation;
import com.zyf.springboot.service.sys.PermissionService;
import com.zyf.springboot.service.sys.middle.PermissionOperationService;
import com.zyf.springboot.vo.sys.OperationVo;
import com.zyf.springboot.vo.sys.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 权限控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
@RequestMapping("permission")
public class PermissionController extends AbstractControllerVo<Permission, PermissionVo> {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PermissionOperationService permissionOperationService;

    /**
     * 条件查询单个
     */
    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        PermissionVo permissionVo = this.service.selectVoById(id);

        /* 关联操作信息 */
        List<Operation> operations = this.permissionOperationService.selectFromListByPrimaryId(permissionVo.getId());
        List<OperationVo> operationVos = this.orikaMapper.convertList(operations, OperationVo.class);
        permissionVo.setOperationVos(operationVos);
        return Msg.ok(permissionVo);
    }

    /**
     * 分页条件查询集合
     */
    @PostMapping("list")
    public Msg list(@RequestBody PermissionVo permissionVo) {
        permissionVo = Optional.ofNullable(permissionVo).orElse(new PermissionVo());
        return this.permissionService.list(permissionVo);
    }

    @GetMapping("all/{level}")
    public Msg leveAll(@PathVariable("level") Integer level) {
        List<PermissionVo> leveAll = this.service.selectVoList(Condition.create().eq("level", level));
        return Msg.ok(leveAll);
    }

    @GetMapping("tree")
    public Msg tree(PermissionVo permissionVo) {
        return this.permissionService.tree();
    }

    /**
     * 新增
     */
    @PostMapping
    public Msg add(@RequestBody PermissionVo permissionVo) {
        permissionVo = Optional.ofNullable(permissionVo).orElse(new PermissionVo());
        return this.permissionService.addPermission(permissionVo);
    }

    @PutMapping("permissionOperation")
    public Msg updateRoleOperation(@RequestBody List<PermissionOperation> permissionOperations) {
        permissionOperations = Optional.ofNullable(permissionOperations).orElse(Lists.newArrayList());
        return this.permissionOperationService.updatePermissionOperation(permissionOperations);
    }

    /**
     * 全量修改
     */
    @PutMapping
    public Msg updateAllColumn(@RequestBody PermissionVo permissionVo) {
        permissionVo = Optional.ofNullable(permissionVo).orElse(new PermissionVo());
        return this.permissionService.updateAllColumnPermission(permissionVo);
    }

    /**
     * 局部修改
     */
    @PatchMapping
    public Msg update(@RequestBody PermissionVo permissionVo) {
        permissionVo = Optional.ofNullable(permissionVo).orElse(new PermissionVo());
        return this.permissionService.updatePermission(permissionVo);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        return this.permissionService.deletePermission(id);
    }

}

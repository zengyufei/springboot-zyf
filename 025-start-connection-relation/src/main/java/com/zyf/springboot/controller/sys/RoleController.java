package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.RoleResource;
import com.zyf.springboot.service.sys.RoleResourceService;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.vo.sys.ResourceVo;
import com.zyf.springboot.vo.sys.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private RoleResourceService roleResourceService;

    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        RoleVo roleVo = this.service.selectVoById(id);

        /* 关联资源信息 */
        List<ResourceVo> resourceVos = this.roleResourceService.selectResourceVoList(roleVo.getId());
        roleVo.setResourceVos(resourceVos);
        return Msg.ok(roleVo);
    }

    @GetMapping
    public Msg list(RoleVo roleVo) {
        Page<RoleVo> roleVoPage = this.service.selectVoPage(
                new Page<>(roleVo.getPageIndex(), roleVo.getPageSize()),
                getWrapper(roleVo)
        );
        return Msg.ok(roleVoPage);
    }

    @GetMapping("all")
    public Msg all() {
        return Msg.ok(this.service.selectVoList(Condition.EMPTY));
    }

    @PostMapping
    public Msg add(@RequestBody RoleVo roleVo) {
        return this.roleService.addRole(roleVo);
    }

    @PutMapping
    public Msg update(@RequestBody RoleVo roleVo) {
        return this.roleService.updateRole(roleVo);
    }

    @PutMapping("roleResource")
    public Msg updateRoleResource(@RequestBody List<RoleResource> roleResources) {
        return this.roleResourceService.updateRoleResource(roleResources);
    }

    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        return this.roleService.deleteRole(id);
    }

}

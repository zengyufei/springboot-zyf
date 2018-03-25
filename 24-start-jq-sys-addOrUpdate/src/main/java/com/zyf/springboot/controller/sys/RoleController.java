package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.service.sys.RoleResourceService;
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

    @PostMapping
    public Msg add(@RequestBody RoleVo roleVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        boolean effect = this.service.insertVo(roleVo);
        if (effect) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @PutMapping
    public Msg update(@RequestBody RoleVo roleVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        boolean effect = this.service.updateVoById(roleVo);
        if (effect) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        String ok = "删除角色成功！";
        String error = "删除角色失败！";
        String roleOk = "删除关联资源成功！";
        String roleError = "删除关联资源失败！";
        boolean b = this.service.deleteById(id);
        if (b) {
            this.log.info(ok);
            boolean delSuccess = this.roleResourceService.deleteRoleResourceByRoleId(id);
            if (delSuccess) {
                this.log.info(roleOk);
                return Msg.ok(ok);
            } else {
                this.log.error(roleError);
                return Msg.ok(roleError);
            }
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

}

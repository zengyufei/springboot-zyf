package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.service.sys.UserRoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
@RequestMapping("user")
public class UserController extends AbstractControllerVo<User, UserVo> {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        UserVo userVo = this.service.selectVoById(id);

        /* 关联 role */
        List<RoleVo> roleVos = this.userRoleService.selectRoleVoList(userVo.getId());
        userVo.setRoleVos(roleVos);
        return Msg.ok(userVo);
    }

    @GetMapping
    public Msg list(UserVo userVo) {
        EntityWrapper<UserVo> wrapper = getWrapper(userVo);
        Page<UserVo> userVoPage = this.service.selectVoPage(new Page<>(userVo.getPageIndex(), userVo.getPageSize()), wrapper);

        /* 关联 role */
        for (UserVo user : userVoPage.getRecords()) {
            List<RoleVo> roleVos = this.userRoleService.selectRoleVoList(userVo.getId());
            user.setRoleVos(roleVos);
        }
        return Msg.ok(userVoPage);
    }

    @PostMapping
    public Msg add(@RequestBody UserVo userVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        userVo.setPassword("admin");
        boolean effect = this.service.insertVo(userVo);
        if (effect) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @PutMapping
    public Msg update(@RequestBody UserVo userVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        boolean effect = this.service.updateVoById(userVo);
        if (effect) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        String ok = "删除用户成功！";
        String error = "删除用户失败！";
        String roleOk = "删除关联角色成功！";
        String roleError = "删除关联角色失败！";
        boolean b = this.service.deleteById(id);
        if (b) {
            this.log.info(ok);
            boolean delSuccess = this.userRoleService.deleteUserRoleByUserId(id);
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

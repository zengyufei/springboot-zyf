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
        UserVo userVo = service.selectVoById(id);

        /* 关联 role */
        List<RoleVo> roleVos = userRoleService.selectRoleVoList(userVo.getId());
        userVo.setRoleVos(roleVos);
        return Msg.ok(userVo);
    }

    @GetMapping
    public Msg list(UserVo userVo) {
        EntityWrapper<UserVo> wrapper = getWrapper(userVo);
        Page<UserVo> userVoPage = service.selectVoPage(new Page<>(userVo.getPageIndex(), userVo.getPageSize()), wrapper);

        /* 关联 role */
        for (UserVo user : userVoPage.getRecords()) {
            List<RoleVo> roleVos = userRoleService.selectRoleVoList(userVo.getId());
            user.setRoleVos(roleVos);
        }
        return Msg.ok(userVoPage);
    }

    @PostMapping
    public Msg add(@RequestBody UserVo userVo) {
        log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        boolean effect = service.insertVo(userVo);
        if (effect) {
            log.info(ok);
            return Msg.ok(ok);
        } else {
            log.error(error);
            return Msg.error(error);
        }
    }

    @PutMapping
    public Msg update(@RequestBody UserVo userVo) {
        log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        boolean effect = service.updateVoById(userVo);
        if (effect) {
            log.info(ok);
            return Msg.ok(ok);
        } else {
            log.info(error);
            return Msg.error(error);
        }
    }

    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        String ok = "删除关联用户成功！";
        String error = "删除关联用户失败！";
        String roleOk = "删除关联用户角色成功！";
        String roleError = "删除关联用户角色失败！";
        boolean b = service.deleteById(id);
        if (b) {
            log.info(ok);
            boolean delSuccess = userRoleService.deleteUserRoleByUserId(id);
            if (delSuccess) {
                log.info(roleOk);
                return Msg.ok(ok);
            } else {
                log.error(roleError);
                return Msg.error(roleError);
            }
        } else {
            log.error(error);
            return Msg.error(error);
        }
    }

}

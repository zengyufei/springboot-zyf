package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
    public UserVo getVo(@PathVariable("id") Integer id) {
        UserVo userVo = service.selectVoById(id);

        /* 关联 role */
        List<RoleVo> roleVos = userRoleService.selectRoleVoList(userVo.getId());
        userVo.setRoleVos(roleVos);
        return userVo;
    }

    @GetMapping
    public Page<UserVo> list(UserVo userVo) {
        EntityWrapper<UserVo> wrapper = getWrapper(userVo);
        Page<UserVo> userVoPage = service.selectVoPage(new Page<>(userVo.getPageIndex(), userVo.getPageSize()), wrapper);

        /* 关联 role */
        for (UserVo user : userVoPage.getRecords()) {
            List<RoleVo> roleVos = userRoleService.selectRoleVoList(userVo.getId());
            user.setRoleVos(roleVos);
        }
        return userVoPage;
    }

    @PostMapping
    public boolean add(@RequestBody UserVo userVo) {
        log.info("开始新增！");
        boolean effect = service.insertVo(userVo);
        if (effect) {
            log.info("新增成功！");
        } else {
            log.info("新增失败！");
        }
        return effect;
    }

    @PutMapping
    public boolean update(@RequestBody UserVo userVo) {
        log.info("开始修改！");
        boolean effect = service.updateVoById(userVo);
        if (effect) {
            log.info("修改成功！");
        } else {
            log.info("修改失败！");
        }
        return effect;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        boolean b = service.deleteById(id);
        if (b) {
            boolean delSuccess = userRoleService.deleteUserRoleByUserId(id);
            if (delSuccess) {
                log.info("删除关联用户角色信息成功！");
            }
        }
        return b;
    }

}

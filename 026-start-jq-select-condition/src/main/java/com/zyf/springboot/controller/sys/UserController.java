package com.zyf.springboot.controller.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.service.sys.UserRoleService;
import com.zyf.springboot.service.sys.UserService;
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
    private UserService userService;
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

    @PostMapping("list")
    public Msg list(@RequestBody UserVo userVo) {
        return this.userService.selectUserPage(userVo);
    }

    @PostMapping
    public Msg add(@RequestBody UserVo userVo) {
        return this.userService.addUser(userVo);
    }

    @PutMapping
    public Msg update(@RequestBody UserVo userVo) {
        return this.userService.updateUser(userVo);
    }

    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        return this.userService.deleteUser(id);
    }

}

package com.zyf.springboot.controller.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.service.sys.UserService;
import com.zyf.springboot.service.sys.middle.UserRoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    /**
     * 条件查询单个
     */
    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        UserVo userVo = this.service.selectVoById(id);

        /* 关联 role */
        List<Role> roles = this.userRoleService.selectFromListByPrimaryId(userVo.getId());
        List<RoleVo> roleVos = this.orikaMapper.convertList(roles, RoleVo.class);
        userVo.setRoleVos(roleVos);
        return Msg.ok(userVo);
    }

    /**
     * 分页条件查询集合
     */
    @PostMapping("list")
    public Msg list(@RequestBody(required = false) UserVo userVo) {
        userVo = Optional.ofNullable(userVo).orElse(new UserVo());
        return this.userService.selectUserPage(userVo);
    }

    /**
     * 新增
     */
    @PostMapping
    public Msg add(@RequestBody(required = false) UserVo userVo) {
        userVo = Optional.ofNullable(userVo).orElse(new UserVo());
        return this.userService.addUser(userVo);
    }

    /**
     * 全量修改
     */
    @PutMapping
    public Msg updateAllColumn(@RequestBody UserVo userVo) {
        userVo = Optional.ofNullable(userVo).orElse(new UserVo());
        return this.userService.updateUserAllColumn(userVo);
    }

    /**
     * 局部修改
     */
    @PatchMapping
    public Msg update(@RequestBody UserVo userVo) {
        userVo = Optional.ofNullable(userVo).orElse(new UserVo());
        return this.userService.updateUser(userVo);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        return this.userService.deleteUser(id);
    }

}

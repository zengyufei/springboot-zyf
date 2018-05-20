package com.zyf.springboot.controller.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.service.sys.UserGroupService;
import com.zyf.springboot.service.sys.middle.UserGroupUserService;
import com.zyf.springboot.vo.sys.UserGroupVo;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 用户组控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
@RequestMapping("userGroup")
public class UserGroupController extends AbstractControllerVo<UserGroup, UserGroupVo> {

    @Autowired
    private UserGroupService userGroupService;
    @Autowired
    private UserGroupUserService userGroupUserService;

    /**
     * 条件查询单个
     */
    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        UserGroupVo userGroupVo = this.service.selectVoById(id);

        /* 关联 user */
        List<User> users = this.userGroupUserService.selectFromListByPrimaryId(userGroupVo.getId());
        List<UserVo> userVos = this.orikaMapper.convertList(users, UserVo.class);
        userGroupVo.setUserVos(userVos);
        return Msg.ok(userGroupVo);
    }

    /**
     * 分页条件查询集合
     */
    @PostMapping("list")
    public Msg list(@RequestBody UserGroupVo userGroupVo) {
        userGroupVo = Optional.ofNullable(userGroupVo).orElse(new UserGroupVo());
        return this.userGroupService.selectUserGroupPage(userGroupVo);
    }

    @GetMapping("tree")
    public Msg tree(UserGroupVo userGroupVo) {
        return this.userGroupService.tree();
    }

    /**
     * 新增
     */
    @PostMapping
    public Msg add(@RequestBody UserGroupVo userGroupVo) {
        userGroupVo = Optional.ofNullable(userGroupVo).orElse(new UserGroupVo());
        return this.userGroupService.addUserGroup(userGroupVo);
    }

    /**
     * 全量修改
     */
    @PutMapping
    public Msg updateAllColumn(@RequestBody UserGroupVo userGroupVo) {
        userGroupVo = Optional.ofNullable(userGroupVo).orElse(new UserGroupVo());
        return this.userGroupService.updateAllColumnUserGroup(userGroupVo);
    }

    /**
     * 局部修改
     */
    @PatchMapping
    public Msg update(@RequestBody UserGroupVo userGroupVo) {
        userGroupVo = Optional.ofNullable(userGroupVo).orElse(new UserGroupVo());
        return this.userGroupService.updateUserGroup(userGroupVo);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        return this.userGroupService.deleteUserGroup(id);
    }

}

package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo162ApplicationTests;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class UserServiceTest extends Demo162ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void all() {
        add();
        get();
        getVo();
        // login();
        list();
        listVo();
        // addVo();
        update();
        updateVo();
        deleteById();
    }

    @Test
    public void login() {
        UserVo userVo = userService.login("admin", "admin");
        Assert.notNull(userVo, "login 登录失败");
    }

    @Test
    public void get() {
        User user = userService.selectById(1);
        Assert.notNull(user, "get 查询为空");
    }

    @Test
    public void getVo() {
        UserVo userVo = userService.getVo(1);
        Assert.notNull(userVo, "getVo 查询为空");
    }

    @Test
    public void list() {
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        List<User> users = userService.selectList(userEntityWrapper);
        Assert.notEmpty(users, "list 数据为空");
    }

    @Test
    public void listVo() {
        List<UserVo> userVos = userService.selectListVo(new UserVo());
        Assert.notEmpty(userVos, "listVo 数据为空");
    }

    @Test
    public void add() {
        User user = new User();
        user.setRealName("曾大佬");
        user.setAge(27);
        boolean effect = userService.insert(user);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void addVo() {
        UserVo userVo = new UserVo();
        userVo.setRealName("曾大佬");
        userVo.setAge(27);
        boolean effect = userService.insertVo(userVo);
        Assert.isTrue(effect, "insertVo 失败，数据库层面失败");
    }

    @Test
    public void update() {
        User lastUser = getLast();
        if (lastUser != null) {
            lastUser.setAge(99);
            boolean effect = userService.updateById(lastUser);
            Assert.isTrue(effect, "update 失败，数据库层面失败");
        }
    }

    @Test
    public void updateVo() {
        UserVo lastUserVo = getLastVo();
        if (lastUserVo != null) {
            lastUserVo.setAge(99);
            int effect = userService.updateVo(lastUserVo);
            Assert.isTrue(effect > 0, "updateVo 失败，数据库层面失败");
        }
    }

    @Test
    public void deleteById() {
        User lastUser = getLast();
        if (lastUser != null) {
            int effect = userService.deleteByUserId(lastUser.getId());
            Assert.isTrue(effect > 0, "deleteById 失败，数据库层面失败");
        }
    }

    private User getLast() {
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        List<User> users = userService.selectList(userEntityWrapper);
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(users.size() - 1);
        }
        return null;
    }

    private UserVo getLastVo() {
        List<UserVo> userVos = userService.selectListVo(new UserVo());
        if (!CollectionUtils.isEmpty(userVos)) {
            return userVos.get(userVos.size() - 1);
        }
        return null;
    }
}
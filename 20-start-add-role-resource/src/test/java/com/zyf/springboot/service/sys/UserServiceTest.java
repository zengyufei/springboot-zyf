package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo20ApplicationTests;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class UserServiceTest extends Demo20ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void curd() {
        add();
        get();
        list();
        update();
        deleteById();
    }

    @Test
    public void get() {
        UserVo userVo = userService.selectVoById(1);
        Assert.notNull(userVo, "get 查询为空");
    }

    @Test
    public void list() {
        List<UserVo> userVos = userService.selectVoList(new EntityWrapper<>(new UserVo()));
        Assert.notEmpty(userVos, "list 数据为空");
    }

    @Test
    public void add() {
        UserVo userVo = new UserVo();
        userVo.setRealName("曾大佬");
        userVo.setAge(27);
        userVo.setUsername("admin");
        userVo.setPassword("admin");
        boolean effect = userService.insertVo(userVo);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void update() {
        UserVo last = getLast();
        if (last != null) {
            last.setAge(99);
            boolean effect = userService.updateVoById(last);
            Assert.isTrue(effect, "update 失败，数据库层面失败");
        }
    }

    @Test
    public void deleteById() {
        UserVo last = getLast();
        if (last != null) {
            boolean effect = userService.deleteById(last.getId());
            Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
        }
    }

    @Test
    public void login() {
        UserVo user = userService.login("admin", "admin");
        Assert.notNull(user, "login 登录失败");
    }

    private UserVo getLast() {
        List<UserVo> userVos = userService.selectVoList(new EntityWrapper<>(new UserVo()));
        if (!CollectionUtils.isEmpty(userVos)) {
            return userVos.get(userVos.size() - 1);
        }
        return null;
    }
}
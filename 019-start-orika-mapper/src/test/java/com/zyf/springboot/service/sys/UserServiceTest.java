package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo19ApplicationTests;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class UserServiceTest extends Demo19ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void curd() {
        addVo();
        getVo();
        listVo();
        update();
        deleteById();
    }

    @Test
    public void getVo() {
        UserVo userVo = userService.selectVoById(1);
        Assert.notNull(userVo, "getVo 查询为空");
    }

    @Test
    public void listVo() {
        List<UserVo> userVos = userService.selectVoList(new EntityWrapper<>(new UserVo()));
        Assert.notEmpty(userVos, "listVo 数据为空");
    }

    @Test
    public void addVo() {
        UserVo userVo = new UserVo();
        userVo.setRealName("曾大佬");
        userVo.setAge(27);
        userVo.setUsername("admin");
        userVo.setPassword("admin");
        boolean effect = userService.insertVo(userVo);
        Assert.isTrue(effect, "insertVo 失败，数据库层面失败");
    }

    @Test
    public void update() {
        UserVo lastVo = getLastVo();
        if (lastVo != null) {
            lastVo.setAge(99);
            boolean effect = userService.updateVoById(lastVo);
            Assert.isTrue(effect, "update 失败，数据库层面失败");
        }
    }

    @Test
    public void deleteById() {
        UserVo lastVo = getLastVo();
        if (lastVo != null) {
            boolean effect = userService.deleteById(lastVo.getId());
            Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
        }
    }

    @Test
    public void login() {
        UserVo userVo = userService.login("admin", "admin");
        Assert.notNull(userVo, "login 登录失败");
    }

    private UserVo getLastVo() {
        List<UserVo> userVos = userService.selectVoList(new EntityWrapper<>(new UserVo()));
        if (!CollectionUtils.isEmpty(userVos)) {
            return userVos.get(userVos.size() - 1);
        }
        return null;
    }
}
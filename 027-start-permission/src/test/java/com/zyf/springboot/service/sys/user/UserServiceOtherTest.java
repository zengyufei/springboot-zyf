package com.zyf.springboot.service.sys.user;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.UserService;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void deleteById() {
        boolean effect = this.userService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

    @Test
    public void login() {
        UserVo user = this.userService.login("admin", "admin");
        Assert.notNull(user, "login 登录失败");
    }

}
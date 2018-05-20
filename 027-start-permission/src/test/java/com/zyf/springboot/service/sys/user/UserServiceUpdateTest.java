package com.zyf.springboot.service.sys.user;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.service.sys.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void update() {
        User user = this.userService.selectById(1);
        user.setAge(99);
        boolean effect = this.userService.updateById(user);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
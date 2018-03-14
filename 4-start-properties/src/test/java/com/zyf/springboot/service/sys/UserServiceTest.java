package com.zyf.springboot.service.sys;

import com.zyf.springboot.Demo4ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends Demo4ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
        String result = userService.login("admin", "admin");
        System.out.println(result);
    }
}
package com.zyf.springboot.service.sys;

import com.zyf.springboot.Demo5ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends Demo5ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
        String result = userService.login("admin", "admin");
        System.out.println(result);
    }
}
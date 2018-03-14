package com.zyf.springboot.controller.sys;

import com.zyf.springboot.Demo5ApplicationTests;
import org.junit.Test;

public class UserControllerTest extends Demo5ApplicationTests {

    @Test
    public void get() {
        String result = testRestTemplate.getForObject(getHost() + "/user/get/1", String.class);
        System.out.println(result);
    }

    @Test
    public void list() {
        String result = testRestTemplate.getForObject(getHost() + "/user/list/admin", String.class);
        System.out.println(result);
    }

    @Test
    public void login() {
        String result = testRestTemplate.getForObject(getHost() + "/user/login?id=2", String.class);
        System.out.println(result);
    }
}
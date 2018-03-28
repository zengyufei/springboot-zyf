package com.zyf.springboot.controller.sys;

import com.zyf.springboot.Demo2ApplicationTests;
import org.junit.Test;

public class UserControllerTest extends Demo2ApplicationTests {

    @Test
    public void test() {
        String result = testRestTemplate.getForObject(getHost() + "/user/test", String.class);
        System.out.println(result);
    }

    @Test
    public void login() {
        String result = testRestTemplate.getForObject(getHost() + "/user/login?id=2", String.class);
        System.out.println(result);
    }

    @Test
    public void test2() {
        String result = testRestTemplate.getForObject(getHost() + "/user/test2", String.class);
        System.out.println(result);
    }

    @Test
    public void login2() {
        String result = testRestTemplate.getForObject(getHost() + "/user/login2?id=1", String.class);
        System.out.println(result);
    }
}
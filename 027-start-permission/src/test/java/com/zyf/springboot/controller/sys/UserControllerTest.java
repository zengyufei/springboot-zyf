package com.zyf.springboot.controller.sys;

import com.zyf.springboot.Demo27ApplicationTests;

public class UserControllerTest extends Demo27ApplicationTests {

/*
    @Test
    public void get() {
        ResponseEntity<String> response = getJson("/user/{id}", 1);
        System.out.println(response.getBody());
    }

    @Test
    public void list() {
        ResponseEntity<String> response = getJson("/user");
        System.out.println(response.getBody());
    }

    @Test
    public void add() {
        String input = "realName=管理员,age=11,sex=0,username=admin,password=admin";
        Map<String, String> args = Splitter.on(",")
                .withKeyValueSeparator("=")
                .split(input);
        ResponseEntity<String> response = postJson("user", args);
        System.out.println(response.getBody());
    }

    @Test
    public void update() {
        String input = "id=1,realName=管理员2号,age=99,sex=1,username=test,password=test";
        Map<String, String> args = Splitter.on(",")
                .withKeyValueSeparator("=")
                .split(input);
        ResponseEntity<String> response = put("user", args);
        System.out.println(response.getBody());
    }

    @Test
    public void login() {
        MultiValueMap<String, Object> args = getFormParams();
        args.add("username", "admin");
        args.add("password", "admin");
        ResponseEntity<String> response = postForm("login", args);
        System.out.println(response.getBody());
    }

    @Test
    public void delete() {
        ResponseEntity<String> response = del("user/{id}", 1);
        System.out.println(response.getBody());
    }*/

}
package com.zyf.springboot.controller.sys;

import com.zyf.springboot.Demo18ApplicationTests;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public class UserControllerTest extends Demo18ApplicationTests {

    @Test
    public void curd() {
        add();
        get();
        list();
        login();
        update();
        delete();
    }

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
        Map<String, Object> args = getJsonParams();
        args.put("realName", "管理员");
        args.put("age", 11);
        args.put("sex", 0);
        args.put("username", "admin");
        args.put("password", "admin");
        ResponseEntity<String> response = postJson("user", args);
        System.out.println(response.getBody());
    }

    @Test
    public void update() {
        Map<String, Object> args = getJsonParams();
        args.put("id", 1);
        args.put("realName", "管理员2号");
        args.put("age", 99);
        args.put("sex", 1);
        args.put("username", "admin2");
        args.put("password", "admin2");
        ResponseEntity<String> response = put("user", args);
        System.out.println(response.getBody());
    }

    @Test
    public void login() {
        MultiValueMap<String, Object> args = getFormParams();
        args.add("username", "admin");
        args.add("password", "admin");
        ResponseEntity<String> response = postForm("user/login", args);
        System.out.println(response.getBody());
    }

    @Test
    public void delete() {
        ResponseEntity<String> response = del("user/{id}", 1);
        System.out.println(response.getBody());
    }

}
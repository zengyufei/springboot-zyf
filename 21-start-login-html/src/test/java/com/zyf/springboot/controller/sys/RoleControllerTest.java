package com.zyf.springboot.controller.sys;

import com.google.common.base.Splitter;
import com.zyf.springboot.Demo21ApplicationTests;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class RoleControllerTest extends Demo21ApplicationTests {

    @Test
    public void curd() {
        add();
        get();
        list();
        update();
        delete();
    }

    @Test
    public void get() {
        ResponseEntity<String> response = getJson("role/{id}", 1);
        System.out.println(response.getBody());
    }

    @Test
    public void list() {
        ResponseEntity<String> response = getJson("role");
        System.out.println(response.getBody());
    }

    @Test
    public void add() {
        String input = "roleName=系统管理员,parentId=1,description=这是一种管理员角色";
        Map<String, String> args = Splitter.on(",")
                .withKeyValueSeparator("=")
                .split(input);
        ResponseEntity<String> response = postJson("role", args);
        System.out.println(response.getBody());
    }

    @Test
    public void update() {
        String input = "id=1,roleName=系统管理员,parentId=1,description=管理员角色";
        Map<String, String> args = Splitter.on(",")
                .withKeyValueSeparator("=")
                .split(input);
        ResponseEntity<String> response = put("role", args);
        System.out.println(response.getBody());
    }

    @Test
    public void delete() {
        ResponseEntity<String> response = del("role/{id}", 1);
        System.out.println(response.getBody());
    }

}
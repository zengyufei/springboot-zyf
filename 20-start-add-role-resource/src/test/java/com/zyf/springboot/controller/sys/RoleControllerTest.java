package com.zyf.springboot.controller.sys;

import com.zyf.springboot.Demo20ApplicationTests;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class RoleControllerTest extends Demo20ApplicationTests {

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
        Map<String, Object> args = getJsonParams();
        args.put("roleName", "系统管理员");
        args.put("parentId", "1");
        args.put("description", "这是一种管理员角色");
        ResponseEntity<String> response = postJson("role", args);
        System.out.println(response.getBody());
    }

    @Test
    public void update() {
        Map<String, Object> args = getJsonParams();
        args.put("roleName", "系统管理员");
        args.put("parentId", "1");
        args.put("description", "管理员角色");
        ResponseEntity<String> response = put("role", args);
        System.out.println(response.getBody());
    }

    @Test
    public void delete() {
        ResponseEntity<String> response = del("role/{id}", 1);
        System.out.println(response.getBody());
    }

}
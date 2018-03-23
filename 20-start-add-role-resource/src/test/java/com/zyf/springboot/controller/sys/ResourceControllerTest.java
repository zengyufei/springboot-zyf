package com.zyf.springboot.controller.sys;

import com.zyf.springboot.Demo20ApplicationTests;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResourceControllerTest extends Demo20ApplicationTests {

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
        ResponseEntity<String> response = getJson("resource/{id}", 1);
        System.out.println(response.getBody());
    }

    @Test
    public void list() {
        ResponseEntity<String> response = getJson("resource");
        System.out.println(response.getBody());
    }

    @Test
    public void add() {
        Map<String, Object> args = getJsonParams();
        args.put("resourceName", "递四方速递");
        args.put("parentId", "1");
        args.put("hrefUrl", "/xxx");
        args.put("iconUrl", "/icon/user.icon");
        args.put("permission", "sys:user:*");
        ResponseEntity<String> response = postJson("resource", args);
        System.out.println(response.getBody());
    }

    @Test
    public void update() {
        Map<String, Object> args = getJsonParams();
        args.put("resourceName", "用户模块");
        args.put("parentId", "1");
        args.put("hrefUrl", "/user");
        args.put("iconUrl", "/icon/user.icon");
        args.put("permission", "sys:user:*");
        ResponseEntity<String> response = put("resource", args);
        System.out.println(response.getBody());
    }

    @Test
    public void delete() {
        ResponseEntity<String> response = del("resource/{id}", 1);
        System.out.println(response.getBody());
    }

}
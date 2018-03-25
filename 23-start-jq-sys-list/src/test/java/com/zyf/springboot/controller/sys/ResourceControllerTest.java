package com.zyf.springboot.controller.sys;

import com.google.common.base.Splitter;
import com.zyf.springboot.Demo23ApplicationTests;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResourceControllerTest extends Demo23ApplicationTests {

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
        String input = "resourceName=递四方速递,parentId=1,hrefUrl=/xxx,iconUrl=/icon/user.icon,permission=sys:user:*";
        Map<String, String> args = Splitter.on(",")
                .withKeyValueSeparator("=")
                .split(input);
        ResponseEntity<String> response = postJson("resource", args);
        System.out.println(response.getBody());
    }

    @Test
    public void update() {
        String input = "id=1,resourceName=用户模块,parentId=1,hrefUrl=/user,iconUrl=/icon/user.png,permission=sys:user:*";
        Map<String, String> args = Splitter.on(",")
                .withKeyValueSeparator("=")
                .split(input);
        ResponseEntity<String> response = put("resource", args);
        System.out.println(response.getBody());
    }

    @Test
    public void delete() {
        ResponseEntity<String> response = del("resource/{id}", 1);
        System.out.println(response.getBody());
    }

}
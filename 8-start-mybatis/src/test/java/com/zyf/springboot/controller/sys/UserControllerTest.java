package com.zyf.springboot.controller.sys;

import com.zyf.springboot.Demo7ApplicationTests;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class UserControllerTest extends Demo7ApplicationTests {

    @Test
    public void get() {
        String result = testRestTemplate.getForObject(getHost() + "/user/get/1", String.class);
        System.out.println(result);
    }

    @Test
    public void list() {
        String result = testRestTemplate.getForObject(getHost() + "/user/list", String.class);
        System.out.println(result);
    }

    @Test
    public void listPage() {
        String result = testRestTemplate.getForObject(getHost() + "/user/list?pageIndex=1&pageSize=10", String.class);
        System.out.println(result);
    }

    @Test
    public void login() {
        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, String> params = getParams();
        params.add("username", "admin");
        params.add("password", "admin");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, formHeaders);
        ResponseEntity<String> response = testRestTemplate.postForEntity(getHost() + "/user/login", requestEntity, String.class);
        System.out.println(response.getBody());
    }
}
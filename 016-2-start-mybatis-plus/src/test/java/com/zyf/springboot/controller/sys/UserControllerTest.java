package com.zyf.springboot.controller.sys;

import com.zyf.springboot.Demo162ApplicationTests;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public class UserControllerTest extends Demo162ApplicationTests {

    @Test
    public void get() {
        String result = testRestTemplate.getForObject(getHost() + "/user/get/1", String.class);
        System.out.println(result);
    }

    @Test
    public void getVo() {
        String result = testRestTemplate.getForObject(getHost() + "/user/getVo/1", String.class);
        System.out.println(result);
    }

    @Test
    public void list() {
        String result = testRestTemplate.getForObject(getHost() + "/user/list", String.class);
        System.out.println(result);
    }

    @Test
    public void listVo() {
        String result = testRestTemplate.getForObject(getHost() + "/user/listVo", String.class);
        System.out.println(result);
    }

    @Test
    public void listVoPage() {
        String result = testRestTemplate.getForObject(getHost() + "/user/listVo?pageIndex=1&pageSize=10", String.class);
        System.out.println(result);
    }

    @Test
    public void add() {
        Map<String, Object> m = getJsonParams();
        m.put("realName", "管理员");
        m.put("age", 11);
        m.put("sex", 0);
        HttpEntity<?> requestEntity = new HttpEntity<>(m, jsonHeaders);
        ResponseEntity<String> response = testRestTemplate.postForEntity(getHost() + "/user/add", requestEntity, String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void addVo() {
        Map<String, Object> m = getJsonParams();
        m.put("realName", "管理员");
        m.put("age", 11);
        m.put("sex", 0);

        m.put("username", "username");
        m.put("password", "username");
        m.put("type", 0);

        HttpEntity<?> requestEntity = new HttpEntity<>(m, jsonHeaders);
        ResponseEntity<String> response = testRestTemplate.postForEntity(getHost() + "/user/addVo", requestEntity, String.class);
        System.out.println(response.getBody());
    }

    @Test
    public void login() {
        //  封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> params = getFormParams();
        params.add("username", "admin");
        params.add("password", "admin");
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, formHeaders);
        ResponseEntity<String> response = testRestTemplate.postForEntity(getHost() + "/user/login", requestEntity, String.class);
        System.out.println(response.getBody());
    }
}
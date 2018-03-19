package com.zyf.springboot.controller.test;

import com.zyf.springboot.Demo16ApplicationTests;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class TestControllerTest extends Demo16ApplicationTests {

    @Test
    public void test() {
        MultiValueMap<String, String> params = getParams();
        params.add("name", "测试");
        params.add("createTime", "2018-03-14 16:06:06");
        params.add("updateTime", "2018-12-14 16:06:06");
        params.add("id", "123");
        params.add("age", "321");
        params.add("ids", "1,2,3,4");
        params.add("types", "系统用户,普通用户,其他用户");
        params.add("arrToIds", "5");
        params.add("arrToIds", "9");
        params.add("arrToIds", "10");
        params.add("arrToTypes", "男用户");
        params.add("arrToTypes", "女用户");
        params.add("arrToTypes", "人妖用户");
        params.add("arrToTypes", "非人类用户");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, formHeaders);
        ResponseEntity<String> response = testRestTemplate.postForEntity(getHost() + "/test/test", requestEntity, String.class);
        System.out.println(response.getBody());
    }
}
package com.zyf.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Demo162ApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    protected TestRestTemplate testRestTemplate;

    protected static HttpHeaders formHeaders = new HttpHeaders();
    protected static HttpHeaders jsonHeaders = new HttpHeaders();

    static {
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        formHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        jsonHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        jsonHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

    protected MultiValueMap<String, Object> getFormParams() {
        return new LinkedMultiValueMap<>();
    }

    protected Map<String, Object> getJsonParams() {
        return new HashMap<>();
    }


    protected String getHost() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

}

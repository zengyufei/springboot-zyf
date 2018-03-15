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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Demo12ApplicationTests {

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
    }

    protected MultiValueMap<String, String> getParams() {
        return new LinkedMultiValueMap<>();
    }


    protected String getHost() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

}

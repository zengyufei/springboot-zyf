package com.zyf.springboot;

import com.zyf.springboot.base.orika.OrikaMapper;
import com.zyf.springboot.utils.RestTemplateWithCookies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Demo19ApplicationTests {

    @Autowired
    private RestTemplateWithCookies restTemplateWithCookies;

    @LocalServerPort
    private int port;

    @Autowired
    private OrikaMapper orikaMapper;

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

    protected String getHost(String uri) {
        String url = "http://localhost:" + port;
        if (uri.startsWith("/")) {
            return url + uri;
        }
        return url + "/" + uri;
    }

    protected ResponseEntity<String> getJson(String uri) {
        return getJson(uri, String.class);
    }

    protected <T> ResponseEntity<String> getJson(String uri, Object... uriVariables) {
        return getJson(uri, String.class, uriVariables);
    }

    protected <T> ResponseEntity<T> getJson(String uri, Class<T> clazz, Object... uriVariables) {
        return restTemplateWithCookies.exchange(
                getHost(uri),
                HttpMethod.GET,
                null,
                clazz,
                uriVariables);
    }

    protected ResponseEntity<String> del(String uri, Object... uriVariables) {
        return restTemplateWithCookies.exchange(
                getHost(uri),
                HttpMethod.DELETE,
                null,
                String.class,
                uriVariables);
    }

    protected ResponseEntity<String> put(String uri, Map<String, Object> args) {
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(args, jsonHeaders);
        return restTemplateWithCookies.exchange(
                getHost(uri),
                HttpMethod.PUT,
                requestEntity,
                String.class);
    }

    protected ResponseEntity<String> postForm(String uri, MultiValueMap<String, Object> args) {
        return postForm(uri, args, String.class);
    }

    protected <T> ResponseEntity<T> postForm(String uri, MultiValueMap<String, Object> args, Class<T> clazz) {
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(args, formHeaders);
        return restTemplateWithCookies.postForEntity(getHost(uri), requestEntity, clazz);
    }

    protected ResponseEntity<String> postJson(String uri, Map<String, Object> args) {
        return postJson(uri, args, String.class);
    }

    protected <T> ResponseEntity<T> postJson(String uri, Map<String, Object> args, Class<T> clazz) {
        HttpEntity<?> requestEntity = new HttpEntity<>(args, jsonHeaders);
        return restTemplateWithCookies.postForEntity(getHost(uri), requestEntity, clazz);
    }

    protected <T> Map<String, Object> toMap(T t) {
        return orikaMapper.convertMap(t);
    }

    @Test
    public void contextLoads() {
    }

}

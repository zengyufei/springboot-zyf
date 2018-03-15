package com.zyf.springboot.service.sys;

import com.alibaba.fastjson.JSONObject;
import com.zyf.springboot.Demo9ApplicationTests;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends Demo9ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void get() {
        UserVo userVo = userService.get(1);
        System.out.println(JSONObject.toJSONString(userVo));
    }

    @Test
    public void list() {
        List<UserVo> userVos = userService.list(new UserVo());
        System.out.println(JSONObject.toJSONString(userVos));
    }

    @Test
    public void login() {
        UserVo userVo = userService.login("admin", "admin");
        System.out.println(JSONObject.toJSONString(userVo));
    }
}
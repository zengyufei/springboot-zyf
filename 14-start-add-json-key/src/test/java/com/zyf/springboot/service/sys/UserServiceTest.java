package com.zyf.springboot.service.sys;

import com.alibaba.fastjson.JSONObject;
import com.zyf.springboot.Demo14ApplicationTests;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends Demo14ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void get() {
        UserVo userVo = userService.getVo(1);
        System.out.println(JSONObject.toJSONString(userVo));
    }

    @Test
    public void list() {
        List<UserVo> userVos = userService.listVo(new UserVo());
        System.out.println(JSONObject.toJSONString(userVos));
    }

    @Test
    public void login() {
        UserVo userVo = userService.login("admin", "admin");
        System.out.println(JSONObject.toJSONString(userVo));
    }
}
package com.zyf.springboot.mapper.sys;

import com.alibaba.fastjson.JSONObject;
import com.zyf.springboot.Demo16ApplicationTests;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserVoMapperTest extends Demo16ApplicationTests {

    /*
     * get、list、count
     */
    @Autowired
    private UserVoMapper userVoMapper;

    @Test
    public void get() {
        UserVo userVo = userVoMapper.get(1);
        System.out.println(JSONObject.toJSONString(userVo));
    }

    @Test
    public void list() {
        List<UserVo> users = userVoMapper.list(new UserVo());
        System.out.println(JSONObject.toJSONString(users));
    }

    @Test
    public void count() {
        int count = userVoMapper.count(new UserVo());
        System.out.println(count);
    }

    @Test
    public void login() {
        String username = "admin";
        String password = "admin";
        UserVo userVo = userVoMapper.login(username, password);
        System.out.println(JSONObject.toJSONString(userVo));
    }
}
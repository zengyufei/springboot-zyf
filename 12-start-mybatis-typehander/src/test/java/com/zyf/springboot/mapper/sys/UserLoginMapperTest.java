package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.Demo12ApplicationTests;
import com.zyf.springboot.entity.sys.UserLogin;
import com.zyf.springboot.enums.UserType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginMapperTest extends Demo12ApplicationTests {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Test
    public void get() {
        UserLogin userLogin = userLoginMapper.get(1);
        System.out.println(userLogin);
    }

    @Test
    public void list() {
    }

    @Test
    public void count() {
    }

    @Test
    public void add() {
        UserLogin userLogin = new UserLogin();
        userLogin.setEnable(true);
        userLogin.setPassword("admin");
        userLogin.setType(UserType.OTHER_USER);
        userLogin.setUserId(1);
        userLogin.setUsername("admin");
        int effect = userLoginMapper.add(userLogin);
        System.out.println(effect);
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }
}
package com.zyf.springboot.service.sys;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String login(String userName, String password) {
        return userName + " = " + password + "登录成功！";
    }
}

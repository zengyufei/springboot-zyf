package com.zyf.springboot.service.sys;

import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserVo get(Integer id) {
        boolean present = Optional.ofNullable(id).isPresent();
        if (present) {
            UserVo userVo = new UserVo();
            if (id == 1) {
                userVo.setId(id);
                userVo.setUsername("admin");
                userVo.setPassword("admin");
                userVo.setAge(11);
                userVo.setEnable(true);
                userVo.setUserId(1);
                userVo.setUserLoginId(1);
                userVo.setRealName("曾大佬");
                userVo.setType(1);
                userVo.setTypeName("系统用户");
            } else if (id == 2) {
                userVo.setId(id);
                userVo.setUsername("guest");
                userVo.setPassword("guest");
                userVo.setAge(22);
                userVo.setEnable(false);
                userVo.setUserId(2);
                userVo.setUserLoginId(2);
                userVo.setRealName("青春小弟");
                userVo.setType(2);
                userVo.setTypeName("普通用户");
            }
            return userVo;
        }
        return null;
    }

    @Override
    public List<UserVo> list(UserVo userVo) {
        List<UserVo> list = new ArrayList<>();

        UserVo userVoToFirst = new UserVo();
        userVoToFirst.setId(1);
        userVoToFirst.setUsername("admin");
        userVoToFirst.setPassword("admin");
        userVoToFirst.setAge(11);
        userVoToFirst.setEnable(true);
        userVoToFirst.setUserId(1);
        userVoToFirst.setUserLoginId(1);
        userVoToFirst.setRealName("曾大佬");
        userVoToFirst.setType(1);
        userVoToFirst.setTypeName("系统用户");
        list.add(userVoToFirst);

        UserVo userVoToTwo = new UserVo();
        userVoToTwo.setId(2);
        userVoToTwo.setUsername("guest");
        userVoToTwo.setPassword("guest");
        userVoToTwo.setAge(22);
        userVoToTwo.setEnable(false);
        userVoToTwo.setUserId(2);
        userVoToTwo.setUserLoginId(2);
        userVoToTwo.setRealName("青春小弟");
        userVoToTwo.setType(2);
        userVoToTwo.setTypeName("普通用户");
        list.add(userVoToTwo);
        return list;
    }

    @Override
    public UserVo login(String userName, String password) {
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setUsername(userName);
        userVo.setPassword(password);
        userVo.setAge(11);
        userVo.setEnable(true);
        userVo.setUserId(1);
        userVo.setUserLoginId(1);
        userVo.setRealName("曾大佬");
        userVo.setType(1);
        userVo.setTypeName("系统用户");
        return userVo;
    }

}

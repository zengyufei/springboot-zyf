package com.zyf.springboot.service.sys;

import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.vo.sys.UserVo;

import java.util.List;

public interface UserService {

    /**
     * 新增用户方法
     */
    int add(User user);

    /**
     * 新增用户方法
     */
    int addVo(UserVo userVo);

    /**
     * 查找用户方法
     */
    User get(Integer id);

    /**
     * 查找用户方法
     */
    UserVo getVo(Integer id);

    /**
     * 查找列表方法
     */
    List<User> list(User user);

    /**
     * 查找列表方法
     */
    List<UserVo> listVo(UserVo userVo);

    /**
     * 登录方法
     */
    UserVo login(String userName, String password);

}

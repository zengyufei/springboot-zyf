package com.zyf.springboot.service.sys;

import com.zyf.springboot.vo.sys.UserVo;

import java.util.List;

public interface UserService {

    /**
     * 新增用户方法
     */
    int add(UserVo userVo);

    /**
     * 查找用户方法
     */
    UserVo get(Integer id);

    /**
     * 查找列表方法
     */
    List<UserVo> list(UserVo userVo);

    /**
     * 登录方法
     */
    UserVo login(String userName, String password);

}

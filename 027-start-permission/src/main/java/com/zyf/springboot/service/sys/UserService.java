package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVo;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.vo.sys.UserVo;

public interface UserService extends AbstractServiceVo<User, UserVo> {

    UserVo login(String userName, String password);

    Msg addUser(UserVo userVo);

    Msg updateUserAllColumn(UserVo userVo);

    Msg updateUser(UserVo userVo);

    Msg deleteUser(Integer id);

    Msg selectUserPage(UserVo userVo);

}

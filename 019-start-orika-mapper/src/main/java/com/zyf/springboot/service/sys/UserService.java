package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.mvc.AbstractServiceVo;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.vo.sys.UserVo;

public interface UserService extends AbstractServiceVo<User, UserVo, Integer> {

    UserVo login(String userName, String password);
}

package com.zyf.springboot.service.sys.middle;

import com.zyf.springboot.base.mvc.AbstractMiddleService;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.entity.sys.middle.UserGroupUser;
import com.zyf.springboot.vo.sys.UserGroupVo;

import java.util.List;

public interface UserGroupUserService extends AbstractMiddleService<UserGroupUser, UserGroup, User> {

    void setUserVoList(List<UserGroupVo> userGroupVo);

}

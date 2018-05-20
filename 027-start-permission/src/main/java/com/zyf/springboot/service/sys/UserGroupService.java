package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVo;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.vo.sys.UserGroupVo;

public interface UserGroupService extends AbstractServiceVo<UserGroup, UserGroupVo> {

    Msg addUserGroup(UserGroupVo userGroupVo);

    Msg updateAllColumnUserGroup(UserGroupVo userGroupVo);

    Msg updateUserGroup(UserGroupVo userGroupVo);

    Msg deleteUserGroup(Integer id);

    Msg selectUserGroupPage(UserGroupVo userGroupVo);

    Msg tree();
}

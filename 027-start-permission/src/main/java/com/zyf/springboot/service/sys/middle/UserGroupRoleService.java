package com.zyf.springboot.service.sys.middle;

import com.zyf.springboot.base.mvc.AbstractMiddleService;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.entity.sys.middle.UserGroupRole;
import com.zyf.springboot.vo.sys.UserGroupVo;

import java.util.List;

public interface UserGroupRoleService extends AbstractMiddleService<UserGroupRole, UserGroup, Role> {

    void setRoleVoList(List<UserGroupVo> userGroupVos);

}

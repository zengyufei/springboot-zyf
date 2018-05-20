package com.zyf.springboot.service.sys.middle;

import com.zyf.springboot.base.mvc.AbstractMiddleService;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.entity.sys.middle.UserRole;
import com.zyf.springboot.vo.sys.UserVo;

import java.util.List;

public interface UserRoleService extends AbstractMiddleService<UserRole, User, Role> {

    void setRoleVoList(List<UserVo> userVos);

}

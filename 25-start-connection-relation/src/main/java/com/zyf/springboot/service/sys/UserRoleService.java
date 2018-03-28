package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.mvc.AbstractService;
import com.zyf.springboot.entity.sys.UserRole;
import com.zyf.springboot.vo.sys.RoleVo;

import java.util.List;

public interface UserRoleService extends AbstractService<UserRole> {

    List<RoleVo> selectRoleVoList(Integer userId);

    boolean deleteUserRoleByUserId(Integer userId);

}

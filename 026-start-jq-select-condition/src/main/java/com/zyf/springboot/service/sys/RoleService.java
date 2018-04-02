package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVo;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.vo.sys.RoleVo;

public interface RoleService extends AbstractServiceVo<Role, RoleVo> {

    Msg addRole(RoleVo roleVo);

    Msg updateRole(RoleVo roleVo);

    Msg deleteRole(Integer id);

    Msg list(RoleVo roleVo);
}

package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVo;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.vo.sys.PermissionVo;

public interface PermissionService extends AbstractServiceVo<Permission, PermissionVo> {

    Msg addPermission(PermissionVo permissionVo);

    Msg updateAllColumnPermission(PermissionVo permissionVo);

    Msg updatePermission(PermissionVo permissionVo);

    Msg deletePermission(Integer id);

    Msg tree();

    Msg list(PermissionVo permissionVo);
}

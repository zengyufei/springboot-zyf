package com.zyf.springboot.service.sys.middle;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractMiddleService;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.middle.RolePermission;

import java.util.List;

public interface RolePermissionService extends AbstractMiddleService<RolePermission, Role, Permission> {

    Msg updateRolePermission(List<RolePermission> rolePermission);
}

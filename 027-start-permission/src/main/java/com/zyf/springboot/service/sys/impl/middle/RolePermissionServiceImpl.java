package com.zyf.springboot.service.sys.impl.middle;

import cn.hutool.core.collection.CollUtil;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractMiddleServiceImpl;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.middle.RolePermission;
import com.zyf.springboot.mapper.sys.PermissionMapper;
import com.zyf.springboot.mapper.sys.RoleMapper;
import com.zyf.springboot.mapper.sys.middle.RolePermissionMapper;
import com.zyf.springboot.service.sys.middle.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(rollbackFor = Exception.class)
public class RolePermissionServiceImpl extends AbstractMiddleServiceImpl<
        RolePermissionMapper, RolePermission,
        RoleMapper, Role,
        PermissionMapper, Permission,
        Integer> implements RolePermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Msg updateRolePermission(List<RolePermission> rolePermissions) {
        String ok = "更新用户权限成功！";
        String error = "更新用户权限失败！";
        if (CollUtil.isNotEmpty(rolePermissions)) {
            Integer roleId = rolePermissions.get(0).getRoleId();

            Set<RolePermission> newRolePermissions = CollUtil.newHashSet(rolePermissions);
            for (RolePermission rolePermission : rolePermissions) {
                Integer permissionId = rolePermission.getPermissionId();
                /*
                 * 获取所有上级，勾选所有上级，使用 set + equals 排除重复值
                 */
                List<Permission> parents = this.permissionMapper.selectAllParent(permissionId);
                for (Permission parent : parents) {
                    newRolePermissions.add(new RolePermission(roleId, parent.getId()));
                }
            }
            /*
             * 先删除角色所有权限，再新增角色权限
             */
            this.deleteMiddleByPrimaryId(roleId);
            if (this.insertOrUpdateBatch(CollUtil.newArrayList(newRolePermissions))) {
                this.log.info(ok);
                return Msg.ok(ok);
            } else {
                this.log.error(error);
                return Msg.error(error);
            }
        }
        this.log.error(error);
        return Msg.error(error);
    }
}

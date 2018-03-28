package com.zyf.springboot.entity.sys;

import com.zyf.springboot.base.PO;

/**
 * 角色-资源关联实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class RoleResource extends PO<RoleResource, Integer> {

    /**
     * 角色外键
     */
    private Integer roleId;
    /**
     * 资源外键
     */
    private Integer resourceId;

    public RoleResource(Integer roleId, Integer resourceId) {
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

    public RoleResource(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleResource() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}

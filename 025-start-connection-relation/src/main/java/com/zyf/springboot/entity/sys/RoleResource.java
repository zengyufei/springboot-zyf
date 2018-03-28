package com.zyf.springboot.entity.sys;

import com.zyf.springboot.base.PO;

import java.util.Objects;

/**
 * 角色-资源关联实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class RoleResource extends PO<RoleResource, Integer> {


    /**
     * 删除状态
     */
    protected Integer deleteFlag;
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
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    @Override
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleResource that = (RoleResource) o;
        return Objects.equals(this.roleId, that.roleId) &&
                Objects.equals(this.resourceId, that.resourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.roleId, this.resourceId);
    }
}

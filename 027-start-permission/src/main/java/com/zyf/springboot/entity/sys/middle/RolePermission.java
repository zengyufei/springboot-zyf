package com.zyf.springboot.entity.sys.middle;

import com.zyf.springboot.base.PO;

import java.util.Objects;

/**
 * 角色-权限关联实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class RolePermission extends PO<RolePermission, Integer> {

    /**
     * 角色外键
     */
    private Integer roleId;
    /**
     * 权限外键
     */
    private Integer permissionId;
    /**
     * 删除状态，默认逻辑删除，重写则为物理删除
     */
    protected Integer deleteFlag;

    public RolePermission(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public RolePermission(Integer roleId) {
        this.roleId = roleId;
    }

    public RolePermission() {
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RolePermission that = (RolePermission) o;
        return Objects.equals(this.roleId, that.roleId) &&
                Objects.equals(this.permissionId, that.permissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.roleId, this.permissionId);
    }
}

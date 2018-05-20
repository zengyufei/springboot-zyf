package com.zyf.springboot.entity.sys.middle;

import com.zyf.springboot.base.PO;

/**
 * 用户组-角色关联实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class UserGroupRole extends PO<UserGroupRole, Integer> {

    /**
     * 用户组外键
     */
    private Integer userGroupId;
    /**
     * 角色外键
     */
    private Integer roleId;
    /**
     * 删除状态，默认逻辑删除，重写则为物理删除
     */
    protected Integer deleteFlag;

    public UserGroupRole(Integer userGroupId, Integer roleId) {
        this.userGroupId = userGroupId;
        this.roleId = roleId;
    }

    public UserGroupRole(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public UserGroupRole() {
    }

    public Integer getUserGroupId() {
        return this.userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}

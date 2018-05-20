package com.zyf.springboot.entity.sys.middle;

import com.zyf.springboot.base.PO;

/**
 * 用户-角色关联实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class UserRole extends PO<UserRole, Integer> {

    /**
     * 用户外键
     */
    private Integer userId;
    /**
     * 角色外键
     */
    private Integer roleId;
    /**
     * 删除状态，默认逻辑删除，重写则为物理删除
     */
    protected Integer deleteFlag;

    public UserRole(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRole(Integer userId) {
        this.userId = userId;
    }

    public UserRole() {
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}

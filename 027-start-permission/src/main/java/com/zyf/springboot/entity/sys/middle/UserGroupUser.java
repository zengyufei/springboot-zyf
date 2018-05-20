package com.zyf.springboot.entity.sys.middle;

import com.zyf.springboot.base.PO;

import java.util.Objects;

/**
 * 用户组-用户关联实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class UserGroupUser extends PO<UserGroupUser, Integer> {

    /**
     * 用户组外键
     */
    private Integer userGroupId;
    /**
     * 用户外键
     */
    private Integer userId;
    /**
     * 删除状态，默认逻辑删除，重写则为物理删除
     */
    protected Integer deleteFlag;

    public UserGroupUser(Integer userGroupId, Integer userId) {
        this.userGroupId = userGroupId;
        this.userId = userId;
    }

    public UserGroupUser(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public UserGroupUser() {
    }

    public Integer getUserGroupId() {
        return this.userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        UserGroupUser that = (UserGroupUser) o;
        return Objects.equals(this.userGroupId, that.userGroupId) &&
                Objects.equals(this.userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userGroupId, this.userId);
    }
}

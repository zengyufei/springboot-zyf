package com.zyf.springboot.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;

/**
 * 用户组实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class UserGroup extends PO<UserGroup, Integer> {

    private static final long serialVersionUID = -6292975489452661754L;

    /**
     * 用户组名称
     */
    @TableField(condition = SqlCondition.LIKE)
    private String userGroupName;

    /**
     * 父用户组
     */
    private Integer parentId;

    public String getUserGroupName() {
        return this.userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}

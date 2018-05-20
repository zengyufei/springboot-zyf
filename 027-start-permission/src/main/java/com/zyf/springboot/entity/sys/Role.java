package com.zyf.springboot.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;

import java.util.Date;

/**
 * 用户实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class Role extends PO<Role, Integer> {

    private static final long serialVersionUID = 5821303352482228177L;
    /**
     * 角色名称
     */
    @TableField(condition = SqlCondition.LIKE_RIGHT)
    private String roleName;

    /**
     * 描述
     */
    private String description;

    /**
     * 上级
     */
    private int parentId;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private Boolean enable;
    /**
     * 禁用启用时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date enableTime;

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getEnableTime() {
        return this.enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }
}

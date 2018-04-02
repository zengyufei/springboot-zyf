package com.zyf.springboot.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;

import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class Role extends PO<Role, Integer> {

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
     * 格式：\
     * ==== 一级: 1 \
     * ==== 二级: 1/2 \
     * ==== 三级: 1/2/3 \
     */
    private String parentId;
    @JSONField(serialize = false)
    @TableField(exist = false)
    private List<String> parentIdList;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private Boolean enable;
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

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<String> getParentIdList() {
        return this.parentIdList;
    }

    public void setParentIdList(List<String> parentIdList) {
        this.parentIdList = parentIdList;
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

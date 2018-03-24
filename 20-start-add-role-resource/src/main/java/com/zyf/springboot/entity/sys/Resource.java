package com.zyf.springboot.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;

import java.util.Date;
import java.util.List;

/**
 * 资源实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class Resource extends PO<Resource, Integer> {

    /**
     * 角色名称
     */
    @TableField(condition = SqlCondition.LIKE_LEFT)
    private String resourceName;

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
     * 资源 URL
     */
    private String hrefUrl;

    /**
     * 图标 URL
     */
    private String iconUrl;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private Boolean enable;
    @TableField(fill = FieldFill.INSERT)
    private Date enableTime;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<String> getParentIdList() {
        return parentIdList;
    }

    public void setParentIdList(List<String> parentIdList) {
        this.parentIdList = parentIdList;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Date getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }
}

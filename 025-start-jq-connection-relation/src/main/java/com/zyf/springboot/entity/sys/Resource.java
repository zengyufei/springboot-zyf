package com.zyf.springboot.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.config.json.AddEnumTypeName;
import com.zyf.springboot.enums.LevelType;

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
     * 等级
     */
    @JSONField(serializeUsing = AddEnumTypeName.class)
    private LevelType level;

    /**
     * 上级
     */
    private Integer parentId;
    @JSONField(serialize = false)
    @TableField(exist = false)
    private List<Integer> parentIdList;

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
     * 排序
     */
    private Integer sort;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private Boolean enable;
    @TableField(fill = FieldFill.INSERT)
    private Date enableTime;

    public String getResourceName() {
        return this.resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Integer> getParentIdList() {
        return this.parentIdList;
    }

    public void setParentIdList(List<Integer> parentIdList) {
        this.parentIdList = parentIdList;
    }

    public String getHrefUrl() {
        return this.hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public LevelType getLevel() {
        return this.level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }
}

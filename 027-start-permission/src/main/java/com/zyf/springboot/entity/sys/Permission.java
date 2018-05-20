package com.zyf.springboot.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.enums.LevelType;

/**
 * 权限实体
 * @author zengyufei
 * @since 1.0.0
 */
public class Permission extends PO<Permission, Integer> {

    private static final long serialVersionUID = 7115532160740503741L;

    /**
     * 权限名称
     */
    @TableField(condition = SqlCondition.LIKE_RIGHT)
    private String permissionName;

    /**
     * 权限标识
     */
    @TableField(condition = SqlCondition.LIKE_RIGHT)
    private String permission;

    /**
     * 等级
     */
    private LevelType level;

    /**
     * 上级
     */
    private Integer parentId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 删除状态，默认逻辑删除，重写则为物理删除
     */
    protected Integer deleteFlag;
    
    public String getPermissionName() {
        return this.permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public LevelType getLevel() {
        return this.level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}

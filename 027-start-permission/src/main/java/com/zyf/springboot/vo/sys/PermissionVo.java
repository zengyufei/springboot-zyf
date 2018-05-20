package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.VO;
import com.zyf.springboot.enums.LevelType;

import java.util.List;

public class PermissionVo extends VO {

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限标识
     */
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
     * 上级名称
     */
    private String parentName;

    /**
     * 排序
     */
    private Integer sort;

    //-------------------------------------------------------------------------------------

    private List<OperationVo> operationVos;

    /**
     * 多选，上级
     */
    @JSONField(serialize = false)
    private List<Integer> parentIdList;
    /**
     * 多选，等级
     */
    @JSONField(serialize = false)
    private List<LevelType> levelList;

    //---------------------------------------------------------------------


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

    public List<OperationVo> getOperationVos() {
        return this.operationVos;
    }

    public void setOperationVos(List<OperationVo> operationVos) {
        this.operationVos = operationVos;
    }

    public List<Integer> getParentIdList() {
        return this.parentIdList;
    }

    public void setParentIdList(List<Integer> parentIdList) {
        this.parentIdList = parentIdList;
    }

    public List<LevelType> getLevelList() {
        return this.levelList;
    }

    public void setLevelList(List<LevelType> levelList) {
        this.levelList = levelList;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
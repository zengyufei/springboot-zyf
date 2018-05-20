package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.VO;

import java.util.Date;
import java.util.List;

public class RoleVo extends VO {

    /**
     * 角色名称
     */
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
     * 上级名称
     */
    private String parentName;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private Boolean enable;

    /**
     * 禁用时间
     */
    private Date enableTime;
    //----------------------------------------------------------------------------------

    private List<PermissionVo> permissionVos;

    /**
     * 搜索，多个上级
     */
    @JSONField(serialize = false)
    private List<String> parentIdList;

    /**
     * 多选开启
     */
    @JSONField(serialize = false)
    private List<Integer> enableList;

    //--------------------------------------------------------------------------------

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<PermissionVo> getPermissionVos() {
        return this.permissionVos;
    }

    public void setPermissionVos(List<PermissionVo> permissionVos) {
        this.permissionVos = permissionVos;
    }

    public List<Integer> getEnableList() {
        return this.enableList;
    }

    public void setEnableList(List<Integer> enableList) {
        this.enableList = enableList;
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

    public Date getEnableTime() {
        return this.enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }

    public List<String> getParentIdList() {
        return this.parentIdList;
    }

    public void setParentIdList(List<String> parentIdList) {
        this.parentIdList = parentIdList;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
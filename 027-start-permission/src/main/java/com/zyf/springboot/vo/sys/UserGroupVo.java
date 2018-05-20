package com.zyf.springboot.vo.sys;

import com.zyf.springboot.base.VO;

import java.util.List;

public class UserGroupVo extends VO {

    /**
     * 用户组名称
     */
    private String userGroupName;
    /**
     * 父用户组
     */
    private Integer parentId;
    /**
     * 父用户组名称
     */
    private String parentName;

    //-------------------------------------------------------------------------

    private List<UserVo> userVos;
    private List<RoleVo> roleVos;

    //----------------------------------------------------------------------------------


    public String getUserGroupName() {
        return this.userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public List<UserVo> getUserVos() {
        return this.userVos;
    }

    public void setUserVos(List<UserVo> userVos) {
        this.userVos = userVos;
    }

    public List<RoleVo> getRoleVos() {
        return this.roleVos;
    }

    public void setRoleVos(List<RoleVo> roleVos) {
        this.roleVos = roleVos;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
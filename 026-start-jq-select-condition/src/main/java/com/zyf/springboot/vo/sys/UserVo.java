package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.VO;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.enums.SexType;
import com.zyf.springboot.enums.UserType;

import java.util.Date;
import java.util.List;

public class UserVo extends User implements VO {

    List<RoleVo> roleVos;

    @JSONField(serialize = false)
    private List<Integer> roleIds;

    @JSONField(serialize = false)
    private List<UserType> typeList;
    @JSONField(serialize = false)
    private List<SexType> sexList;
    @JSONField(serialize = false)
    private List<Integer> enableList;

    @JSONField(serialize = false)
    private Integer ageLt;
    @JSONField(serialize = false)
    private Integer ageGt;

    @JSONField(serialize = false)
    private Date createTimeLt;
    @JSONField(serialize = false)
    private Date createTimeGt;

    /**
     * 当前页
     */
    @JSONField(serialize = false)
    private int pageIndex = 1;
    /**
     * 分页大小
     */
    @JSONField(serialize = false)
    private int pageSize = 10;

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<RoleVo> getRoleVos() {
        return this.roleVos;
    }

    public void setRoleVos(List<RoleVo> roleVos) {
        this.roleVos = roleVos;
    }

    public List<UserType> getTypeList() {
        return this.typeList;
    }

    public void setTypeList(List<UserType> typeList) {
        this.typeList = typeList;
    }

    public List<SexType> getSexList() {
        return this.sexList;
    }

    public void setSexList(List<SexType> sexList) {
        this.sexList = sexList;
    }

    public List<Integer> getEnableList() {
        return this.enableList;
    }

    public void setEnableList(List<Integer> enableList) {
        this.enableList = enableList;
    }

    public List<Integer> getRoleIds() {
        return this.roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public Integer getAgeLt() {
        return this.ageLt;
    }

    public void setAgeLt(Integer ageLt) {
        this.ageLt = ageLt;
    }

    public Integer getAgeGt() {
        return this.ageGt;
    }

    public void setAgeGt(Integer ageGt) {
        this.ageGt = ageGt;
    }

    public Date getCreateTimeLt() {
        return this.createTimeLt;
    }

    public void setCreateTimeLt(Date createTimeLt) {
        this.createTimeLt = createTimeLt;
    }

    public Date getCreateTimeGt() {
        return this.createTimeGt;
    }

    public void setCreateTimeGt(Date createTimeGt) {
        this.createTimeGt = createTimeGt;
    }
}
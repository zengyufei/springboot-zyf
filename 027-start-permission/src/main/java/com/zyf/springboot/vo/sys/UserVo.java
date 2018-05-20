package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.VO;
import com.zyf.springboot.enums.SexType;
import com.zyf.springboot.enums.UserType;

import java.util.Date;
import java.util.List;

public class UserVo extends VO {

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private SexType sex;

    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * 用户类型： 1 系统用户。2 普通用户。3 其他用户
     */
    private UserType type;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private Boolean enable;

    /**
     * 禁用时间
     */
    private Date enableTime;

    //----------------------------------------------------------------------------------------

    private List<UserGroupVo> userGroupVo;
    private List<RoleVo> roleVos;

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

    //--------------------------------------------------------------------------------------------


    public String getRealName() {
        return this.realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SexType getSex() {
        return this.sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return this.type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<UserGroupVo> getUserGroupVo() {
        return this.userGroupVo;
    }

    public void setUserGroupVo(List<UserGroupVo> userGroupVo) {
        this.userGroupVo = userGroupVo;
    }

    public List<RoleVo> getRoleVos() {
        return this.roleVos;
    }

    public void setRoleVos(List<RoleVo> roleVos) {
        this.roleVos = roleVos;
    }

    public List<Integer> getRoleIds() {
        return this.roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
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

    public Date getEnableTime() {
        return this.enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }
}
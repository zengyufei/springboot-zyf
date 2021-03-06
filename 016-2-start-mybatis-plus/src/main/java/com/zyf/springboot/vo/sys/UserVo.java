package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.BaseVoEntity;
import com.zyf.springboot.enums.SexType;
import com.zyf.springboot.enums.UserType;

import java.util.List;

public class UserVo extends BaseVoEntity<UserVo> {

    /**
     * 等于 id
     */
    @JSONField(serialize = false)
    private Integer userId;
    @JSONField(serialize = false)
    private Integer userLoginId;
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
    //@JSONField(serialize = false)
    private UserType type;
    /*仅作为接收参数使用*/
    @JSONField(serialize = false)
    private List<Integer> typeList;

    /**
     * 是否启用：false 禁用。true 可用
     */
    @JSONField(serialize = false)
    private Boolean enable;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(Integer userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<Integer> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Integer> typeList) {
        this.typeList = typeList;
    }

    public Boolean isEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}

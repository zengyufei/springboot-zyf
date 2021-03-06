package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.BaseVoEntity;

import java.util.Date;
import java.util.List;

public class UserVo extends BaseVoEntity {

    private Integer id;
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
    @JSONField(serialize = false)
    private Integer type;
    private String typeName;
    /*仅作为接收参数使用*/
    @JSONField(serialize = false)
    private List<Integer> typeList;

    /**
     * 是否启用：false 禁用。true 可用
     */
    @JSONField(serialize = false)
    private boolean enable;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Integer> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Integer> typeList) {
        this.typeList = typeList;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

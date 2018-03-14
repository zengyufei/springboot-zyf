package com.zyf.springboot.entity.sys;

import com.zyf.springboot.base.BaseEntity;

import java.util.List;

/**
 * 用户登录用的实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class UserLogin extends BaseEntity {

    private Integer userId;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型： 1 系统用户。2 普通用户。3 其他用户
     */
    private Integer type;
    private String typeName;
    private List<Integer> typeList;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private boolean enable;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}

package com.zyf.springboot.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.zyf.springboot.base.BaseEntity;
import com.zyf.springboot.enums.UserType;

import java.util.List;

/**
 * 用户登录用的实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class UserLogin extends BaseEntity<UserLogin> {

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

    @JSONField(deserialize = false)
    private UserType type;
    
    @TableField(exist = false)
    @JSONField(serialize = false)
    private List<Integer> typeList;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private Boolean enable;

    private String enableTime;

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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(String enableTime) {
        this.enableTime = enableTime;
    }
}

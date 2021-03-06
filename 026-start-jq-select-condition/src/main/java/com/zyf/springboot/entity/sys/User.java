package com.zyf.springboot.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.enums.SexType;
import com.zyf.springboot.enums.UserType;

import java.util.Date;

/**
 * 用户实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class User extends PO<User, Integer> {

    /**
     * 真实姓名
     */
    @TableField(condition = SqlCondition.LIKE)
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
    @TableField(condition = SqlCondition.LIKE_RIGHT)
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
    @TableField(fill = FieldFill.INSERT)
    private Date enableTime;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getEnableTime() {
        return this.enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }
}

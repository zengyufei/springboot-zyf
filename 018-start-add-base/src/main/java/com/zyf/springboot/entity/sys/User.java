package com.zyf.springboot.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.BaseEntity;
import com.zyf.springboot.enums.SexType;
import com.zyf.springboot.enums.UserType;

import java.util.List;

/**
 * 用户实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class User extends BaseEntity<User, Integer> {

    /**
     * 真实姓名
     */
    @TableField(condition = SqlCondition.LIKE_LEFT)
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

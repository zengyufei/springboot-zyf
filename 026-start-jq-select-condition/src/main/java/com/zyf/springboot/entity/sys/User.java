package com.zyf.springboot.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.config.json.AddEnumTypeName;
import com.zyf.springboot.enums.SexType;
import com.zyf.springboot.enums.UserType;

import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class User extends PO<User, Integer> {

    /**
     * 真实姓名
     */
    @TableField(condition = SqlCondition.LIKE, strategy = FieldStrategy.NOT_EMPTY)
    private String realName;

    /**
     * 年龄
     */
    @TableField(strategy = FieldStrategy.NOT_NULL)
    private Integer age;

    /**
     * 性别
     */
    @JSONField(serializeUsing = AddEnumTypeName.class)
    private SexType sex;

    /**
     * 账号
     */
    @TableField(strategy = FieldStrategy.NOT_EMPTY)
    private String username;
    /**
     * 密码
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * 用户类型： 1 系统用户。2 普通用户。3 其他用户
     */
    @JSONField(serializeUsing = AddEnumTypeName.class)
    private UserType type;

    @JSONField(serialize = false)
    @TableField(exist = false)
    private List<Integer> typeList;

    /**
     * 是否启用：false 禁用。true 可用
     */
    private Boolean enable;
    @TableField(fill = FieldFill.INSERT)
    private Date enableTime;

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

    public List<Integer> getTypeList() {
        return this.typeList;
    }

    public void setTypeList(List<Integer> typeList) {
        this.typeList = typeList;
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

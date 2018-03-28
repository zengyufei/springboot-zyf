package com.zyf.springboot.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.BaseEntity;
import com.zyf.springboot.enums.SexType;

/**
 * 用户实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class User extends BaseEntity<User> {

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
}

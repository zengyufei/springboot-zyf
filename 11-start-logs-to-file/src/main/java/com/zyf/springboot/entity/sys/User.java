package com.zyf.springboot.entity.sys;

import com.zyf.springboot.base.BaseEntity;

/**
 * 用户实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class User extends BaseEntity {

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 年龄
     */
    private Integer age;

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
}

package com.zyf.springboot.entity.test;

import com.baomidou.mybatisplus.annotations.TableField;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

    private BigDecimal id;
    private String name;
    private Date createTime;
    private Calendar updateTime;
    private Integer age;

    @TableField(exist = false)
    private List<Integer> ids;
    @TableField(exist = false)
    private List<Integer> arrToIds;
    @TableField(exist = false)
    private List<String> types;
    @TableField(exist = false)
    private List<String> arrToTypes;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Calendar getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Integer> getIds() {
        return this.ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getArrToIds() {
        return this.arrToIds;
    }

    public void setArrToIds(List<Integer> arrToIds) {
        this.arrToIds = arrToIds;
    }

    public List<String> getTypes() {
        return this.types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getArrToTypes() {
        return this.arrToTypes;
    }

    public void setArrToTypes(List<String> arrToTypes) {
        this.arrToTypes = arrToTypes;
    }
}

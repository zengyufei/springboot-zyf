package com.zyf.springboot.entity.test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

    private String name;
    private Date createTime;
    private Calendar updateTime;

    private BigDecimal id;
    private Integer age;

    private List<Integer> ids;
    private List<Integer> arrToIds;
    private List<String> types;
    private List<String> arrToTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getArrToIds() {
        return arrToIds;
    }

    public void setArrToIds(List<Integer> arrToIds) {
        this.arrToIds = arrToIds;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getArrToTypes() {
        return arrToTypes;
    }

    public void setArrToTypes(List<String> arrToTypes) {
        this.arrToTypes = arrToTypes;
    }
}

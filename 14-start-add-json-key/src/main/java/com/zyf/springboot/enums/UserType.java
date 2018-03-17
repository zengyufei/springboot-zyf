package com.zyf.springboot.enums;

import com.zyf.springboot.base.BaseEnum;

/**
 * 用户类型枚举
 * @author zengyufei
 * @since 1.0.0
 */
public enum UserType implements BaseEnum {

    SYSTEM_USER(0, "系统用户"),
    GENERAL_USER(1, "普通用户"),
    OTHER_USER(2, "普通用户");

    private int index;
    private String mark;

    UserType(int index, String mark) {
        this.index = index;
        this.mark = mark;
    }

    @Override
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


}

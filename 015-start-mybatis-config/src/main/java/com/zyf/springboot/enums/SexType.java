package com.zyf.springboot.enums;

import com.zyf.springboot.base.BaseEnum;

/**
 * 性别类型枚举
 * @author zengyufei
 * @since 1.0.0
 */
public enum SexType implements BaseEnum {

    MAN(0, "男"),
    MALE(1, "女");

    private int index;
    private String mark;

    SexType(int index, String mark) {
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

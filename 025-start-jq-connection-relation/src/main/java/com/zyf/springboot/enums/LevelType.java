package com.zyf.springboot.enums;

import com.zyf.springboot.base.BaseEnum;

/**
 * 等级类型枚举
 * @author zengyufei
 * @since 1.0.0
 */
public enum LevelType implements BaseEnum {

    ONE(1, "一级"),
    TWO(2, "二级"),
    THREE(3, "三级");

    private int index;
    private String mark;

    LevelType(int index, String mark) {
        this.index = index;
        this.mark = mark;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }


}

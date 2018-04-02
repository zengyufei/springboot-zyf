package com.zyf.springboot.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.zyf.springboot.base.BaseEnum;

import java.io.Serializable;

/**
 * 等级类型枚举
 * @author zengyufei
 * @since 1.0.0
 */
public enum LevelType implements BaseEnum, IEnum {

    ONE(1, "一级"),
    TWO(2, "二级"),
    THREE(3, "三级");

    Integer index;
    String mark;

    LevelType(Integer index, String mark) {
        this.index = index;
        this.mark = mark;
    }

    @Override
    public Serializable getValue() {
        return this.index;
    }
}

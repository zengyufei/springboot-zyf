package com.zyf.springboot.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.zyf.springboot.base.BaseEnum;

import java.io.Serializable;

/**
 * 性别类型枚举
 * @author zengyufei
 * @since 1.0.0
 */
public enum SexType implements BaseEnum, IEnum {

    MAN(0, "男"),
    MALE(1, "女");

    Integer index;
    String mark;

    SexType(Integer index, String mark) {
        this.index = index;
        this.mark = mark;
    }

    @Override
    public Serializable getValue() {
        return this.index;
    }
}

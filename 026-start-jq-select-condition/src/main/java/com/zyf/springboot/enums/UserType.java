package com.zyf.springboot.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.zyf.springboot.base.BaseEnum;

import java.io.Serializable;

/**
 * 用户类型枚举
 * @author zengyufei
 * @since 1.0.0
 */
public enum UserType implements BaseEnum, IEnum {

    SYSTEM_USER(0, "系统用户"),
    GENERAL_USER(1, "普通用户"),
    OTHER_USER(2, "其他用户");

    Integer index;
    String mark;

    UserType(Integer index, String mark) {
        this.index = index;
        this.mark = mark;
    }

    @Override
    public Serializable getValue() {
        return this.index;
    }
}

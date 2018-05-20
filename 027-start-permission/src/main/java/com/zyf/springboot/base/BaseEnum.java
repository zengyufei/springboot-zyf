package com.zyf.springboot.base;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.ReflectUtil;
import com.fasterxml.jackson.annotation.JsonValue;

import java.lang.reflect.Field;

/**
 * 枚举父类
 * @author zengyufei
 * @since 1.0.0
 */
public interface BaseEnum {


    String DEFAULT_VALUE_NAME = "index";

    String DEFAULT_LABEL_NAME = "mark";

    /**
     * 枚举序列值
     * @return 返回枚举下标
     */
    default Integer getIndex() {
        try {
            return Integer.parseInt(ReflectUtil.getFieldValue(this, DEFAULT_VALUE_NAME).toString());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 枚举描述
     * @return 返回枚举描述
     */
    @JsonValue
    default String getMark() {
        try {
            return ReflectUtil.getFieldValue(this, DEFAULT_LABEL_NAME).toString();
        } catch (UtilException e) {
            return "";
        }
    }

    static <T extends Enum<T>> T valueOfEnum(Class<T> enumClass, Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("DisplayedEnum value should not be null");
        }
        if (enumClass.isAssignableFrom(BaseEnum.class)) {
            throw new IllegalArgumentException("illegal DisplayedEnum type");
        }
        T[] enums = enumClass.getEnumConstants();
        for (T t : enums) {
            BaseEnum displayedEnum = (BaseEnum) t;
            if (displayedEnum.getIndex().equals(value)) {
                return (T) displayedEnum;
            }
        }
        throw new IllegalArgumentException("cannot parse integer: " + value + " to " + enumClass.getName());
    }
}

package com.zyf.springboot.base;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.util.ReflectionUtils;

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
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_VALUE_NAME);
        if (field == null) {
            return null;
        }
        try {
            field.setAccessible(true);
            return Integer.parseInt(field.get(this).toString());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 枚举描述
     * @return 返回枚举描述
     */
    @JsonValue
    default String getMark() {
        Field field = ReflectionUtils.findField(this.getClass(), DEFAULT_LABEL_NAME);
        if (field == null) {
            return null;
        }
        try {
            field.setAccessible(true);
            return field.get(this).toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
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

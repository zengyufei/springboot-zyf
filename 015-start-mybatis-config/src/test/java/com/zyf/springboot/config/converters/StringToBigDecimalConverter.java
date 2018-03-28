/**
 * Copyright (C): 恒大集团©版权所有 Evergrande Group
 * FileName: StringToListConverter
 * Author:   zengyufei
 * Date:     2017-11-6 19:11
 * Description: 字符串转list的转换器
 */
package com.zyf.springboot.config.converters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

/**
 * 字符串转BigDecimal的转换器
 * @author zengyufei
 * @since 1.0.0
 */
public class StringToBigDecimalConverter implements Converter<String, BigDecimal> {

    @Override
    public BigDecimal convert(String source) {
        if (StringUtils.isBlank(source) || "null".equalsIgnoreCase(source)) {
            return new BigDecimal(0);
        }
        return new BigDecimal(source);
    }

}
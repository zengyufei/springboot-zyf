package com.zyf.springboot.config.converters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 字符串转Interger的转换器
 * @author zengyufei
 * @since 1.0.0
 */
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        if (StringUtils.isBlank(source) || "null".equalsIgnoreCase(source)) {
            return 0;
        }
        return new Integer(source);
    }

}
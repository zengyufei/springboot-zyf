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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串转list的转换器
 * @author zengyufei
 * @since 1.0.0
 */
public class StringToListConverter implements Converter<String, List<String>> {

    @Override
    public List<String> convert(String source) {
        if (StringUtils.isBlank(source)) {
            return new ArrayList<>();
        }
        return Arrays
                .stream(source.split(","))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }

}
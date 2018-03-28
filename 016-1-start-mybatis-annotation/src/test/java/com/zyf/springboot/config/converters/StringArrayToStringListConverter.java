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
public class StringArrayToStringListConverter implements Converter<String[], List<String>> {

    @Override
    public List<String> convert(String[] source) {
        if (source == null || source.length == 0) {
            return new ArrayList<>();
        }
        if (source.length == 1) {
            return Arrays
                    .stream(source[0].split(","))
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toList());

        }
        return Arrays
                .stream(source)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }

}
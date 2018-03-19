package com.zyf.springboot.config.languageDrivers;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertByMapLanguageDriver extends XMLLanguageDriver {

    private final Pattern pattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {

        Matcher matcher = pattern.matcher(script);

        if (matcher.find()) {
            String field = "<foreach collection=\"$1\" index=\"__key\" separator=\",\">\\${__key}</foreach>";
            String value = "<foreach collection=\"$1\" item=\"__value\" separator=\",\">#{__value}</foreach>";

            script = matcher.replaceAll("(" + field + ") VALUES (" + value + ")");
        }

        script = "<script>" + script + "</script>";

        return super.createSqlSource(configuration, script, parameterType);
    }
}
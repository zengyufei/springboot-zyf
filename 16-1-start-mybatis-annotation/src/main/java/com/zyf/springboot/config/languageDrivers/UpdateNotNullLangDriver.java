package com.zyf.springboot.config.languageDrivers;

import com.zyf.springboot.base.Pass;
import com.zyf.springboot.base.PassEnd;
import com.zyf.springboot.base.PassStart;
import com.zyf.springboot.base.SqlValue;
import com.zyf.springboot.utils.CamelCaseUtils;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateNotNullLangDriver extends XMLLanguageDriver implements LanguageDriver {

    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        boolean isMapUnderscoreToCamelCase = configuration.isMapUnderscoreToCamelCase();
        Matcher matcher = inPattern.matcher(script);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append("<set>");

            for (Field field : getFields(parameterType)) {
                String fieldName = field.getName();
                Class<?> fieldType = field.getType();
                if (field.isAnnotationPresent(Pass.class)
                        || field.isAnnotationPresent(PassStart.class)
                        || field.isAnnotationPresent(PassEnd.class)) {
                    continue;
                }
                if (Collection.class.isAssignableFrom(fieldType)
                        || Map.class.isAssignableFrom(fieldType)) {
                    continue;
                }
                if (hasGetter(parameterType, fieldName)) {
                    continue;
                }

                String column = CamelCaseUtils.toUnderlineName(fieldName);
                String tmp = "<if test=\"_field != null\">_column=#{_field}, </if>";
                if (field.isAnnotationPresent(SqlValue.class)) {
                    SqlValue declaredAnnotation = field.getDeclaredAnnotation(SqlValue.class);
                    String value = declaredAnnotation.value();
                    boolean isUpdate = declaredAnnotation.isUpdate();
                    if (isUpdate) {
                        tmp = "_column=" + value + ",";
                    }
                } else if (field.isAnnotationPresent(PassStart.class)) {
                    PassStart declaredAnnotation = field.getDeclaredAnnotation(PassStart.class);
                    String value = declaredAnnotation.value();
                    boolean eq = declaredAnnotation.isEq();
                    if (eq) {
                        tmp = "<if test=\"_field != null\">_column &gt;= #{_field}, </if>";
                    } else {
                        tmp = "<if test=\"_field != null\">_column &gt; #{_field}, </if>";
                    }
                    column = CamelCaseUtils.toUnderlineName(value);
                } else if (field.isAnnotationPresent(PassEnd.class)) {
                    PassEnd declaredAnnotation = field.getDeclaredAnnotation(PassEnd.class);
                    String value = declaredAnnotation.value();
                    boolean eq = declaredAnnotation.isEq();
                    if (eq) {
                        tmp = "<if test=\"_field != null\">_column &lt;= #{_field}, </if>";
                    } else {
                        tmp = "<if test=\"_field != null\">_column &lt; #{_field}, </if>";
                    }
                    column = CamelCaseUtils.toUnderlineName(value);
                }
                tmp = tmp.replaceAll("_field", fieldName);
                if (isMapUnderscoreToCamelCase) {
                    tmp = tmp.replaceAll("_column", column);
                } else {
                    tmp = tmp.replaceAll("_column", column);
                }
                sb.append(tmp);
            }

            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("</set>");

            script = matcher.replaceAll(sb.toString());
            script = "<script>" + script + "</script>";
        }

        return super.createSqlSource(configuration, script, parameterType);
    }

    private boolean hasGetter(Class<?> parameterType, String fieldName) {
        PropertyDescriptor prop = null;
        try {
            prop = new PropertyDescriptor(fieldName, parameterType);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        if (prop == null) {
            return true;
        }
        //  获取 getter 方法，反射获取 id 值 
        Method readMethod = prop.getReadMethod();
        return readMethod == null;
    }

    private Field[] concat(Field[] a, Field[] b) {
        Field[] c = new Field[a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    private Field[] getFields(Class clazz, int number) {
        Field[] currentField = clazz.getDeclaredFields();
        Field[] temp = new Field[currentField.length];
        Class superClass = clazz.getSuperclass();
        while (number-- > 0) {
            Field[] superClassDeclaredFields = superClass.getDeclaredFields();
            temp = concat(currentField, superClassDeclaredFields);
            superClass = superClass.getSuperclass();
        }
        return temp;
    }

    private Field[] getFields(Class clazz) {
        return getFields(clazz, 1);
    }
}
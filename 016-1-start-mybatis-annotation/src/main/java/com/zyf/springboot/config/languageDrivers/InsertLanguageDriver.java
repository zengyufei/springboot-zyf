package com.zyf.springboot.config.languageDrivers;

import com.zyf.springboot.base.*;
import com.zyf.springboot.utils.CamelCaseUtils;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 注意事项 :
 * 1、务必确保数据库中列名和实体类中字段能一一对应
 * 2、在使用自定义 SQL 解析器的时候，只能传入一个参数，即相应的对象参数即可；传入多个参数会导致解析器中获得到的 class 对象改变，使得 sql 解析异常
 * 3、Update 的实现能满足大部分的业务，但有些业务场景可以会遇到根据查询条件来更新查询参数的情况，比如 Update uesrs SET uesr_name = ‘tom’ WHERE user_name = ‘Jack’; 在这中场景的时候请不要使用自定义的 SQL 解析器
 * 4、请使用 Mybatis 3.3 以上版本。3.2 版本有 bug
 */
public class InsertLanguageDriver extends XMLLanguageDriver implements LanguageDriver {
    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        boolean isMapUnderscoreToCamelCase = configuration.isMapUnderscoreToCamelCase();
        Matcher matcher = inPattern.matcher(script);
        if (matcher.find()) {
            StringBuilder columns = new StringBuilder("(");
            StringBuilder values = new StringBuilder("(");
            /* 目标 :
                INSERT INTO user (
                name,password,age)
                VALUES
                (#{name},#{password},#{age}
                )
            */
            for (Field field : getFields(parameterType)) {
                String fieldName = field.getName();
                Class<?> fieldType = field.getType();
                if (field.isAnnotationPresent(Pass.class)
                        || field.isAnnotationPresent(PassId.class)
                        || field.isAnnotationPresent(PassStart.class)
                        || field.isAnnotationPresent(PassEnd.class)
                        ) {
                    continue;
                }
                if (Collection.class.isAssignableFrom(fieldType)
                        || Map.class.isAssignableFrom(fieldType)) {
                    continue;
                }
                if (hasGetter(parameterType, fieldName)) {
                    continue;
                }
                if (isMapUnderscoreToCamelCase) {
                    columns.append(CamelCaseUtils.toUnderlineName(fieldName)).append(", ");
                } else {
                    columns.append(fieldName).append(", ");
                }

                if (field.isAnnotationPresent(SqlValue.class)) {
                    SqlValue declaredAnnotation = field.getDeclaredAnnotation(SqlValue.class);
                    String value = declaredAnnotation.value();
                    values.append(value).append(",");
                } else if (field.isAnnotationPresent(DateTimeFormat.class)) {
                    values.append("now(),");
                } else {
                    values.append("#{").append(fieldName).append("}, ");
                }
            }
            int findIndex = columns.lastIndexOf(",");
            if (findIndex > -1) {
                columns.deleteCharAt(findIndex).append(") VALUES ");
                values.deleteCharAt(values.lastIndexOf(",")).append(") ");
                columns.append(values.toString());
                script = matcher.replaceAll(columns.toString());
                script = "<script>" + script + "</script>";
            }
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
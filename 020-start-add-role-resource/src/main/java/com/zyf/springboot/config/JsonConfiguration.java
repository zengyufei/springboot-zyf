package com.zyf.springboot.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zyf.springboot.base.BaseEnum;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json 配置类
 * @author zengyufei
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass({FastJsonHttpMessageConverter.class, WebMvcConfigurerAdapter.class})
public class JsonConfiguration {

    static {
        Map<String, Map<String, BaseEnum>> map = new HashMap<>();
        ValueFilter valueFilter = getValueFilter(map);
        AfterFilter afterFilter = getAfterFilter(map);
        JSON.emptyFilters = new SerializeFilter[]{valueFilter, afterFilter};
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteDateUseDateFormat.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.PrettyFormat.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullNumberAsZero.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteMapNullValue.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullBooleanAsFalse.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullListAsEmpty.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteBigDecimalAsPlain.getMask();
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.WriteNullStringAsEmpty.getMask();
        JSON.DEFAULT_GENERATE_FEATURE = SerializerFeature.config(JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.WriteEnumUsingName, false);
    }

    @Bean
    @ConditionalOnMissingBean({FastJsonHttpMessageConverter.class, WebMvcConfigurerAdapter.class})
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        //1.需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //2:添加fastJson的配置信息;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteBigDecimalAsPlain,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setCharset(Charset.forName("UTF8"));
        Map<String, Map<String, BaseEnum>> map = new HashMap<>();
        ValueFilter valueFilter = getValueFilter(map);
        AfterFilter afterFilter = getAfterFilter(map);
        fastJsonConfig.setSerializeFilters(valueFilter, afterFilter);
        //3处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        //4.在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters((HttpMessageConverter<?>) fastJsonHttpMessageConverter);
    }


    private static AfterFilter getAfterFilter(Map<String, Map<String, BaseEnum>> map) {
        return new AfterFilter() {
            @Override
            public void writeAfter(Object bean) {
                Class<?> beanClass = bean.getClass();
                Field[] declaredFields = beanClass.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    if (declaredField.getType().isEnum()) {
                        String fieldName = declaredField.getName();
                        String simpleName = declaredField.getType().getSimpleName();
                        if (map.containsKey(simpleName)) {
                            String typeName = fieldName + "Name";
                            Map<String, BaseEnum> enumsMap = map.get(simpleName);
                            Field enumField = null;
                            try {
                                enumField = beanClass.getDeclaredField(fieldName);
                            } catch (NoSuchFieldException e) {
                                writeKeyValue(typeName, "");
                                continue;
                            }
                            if (enumField != null) {
                                enumField.setAccessible(true);
                                String enumName = enumField.getName();
                                Method enumGetter;
                                try {
                                    enumGetter = beanClass.getMethod("get" + enumName.substring(0, 1).toUpperCase() + enumName.substring(1));
                                    Object enumValue = enumGetter.invoke(bean);
                                    if (enumValue != null) {
                                        BaseEnum baseEnum = enumsMap.get(enumValue.toString());
                                        writeKeyValue(typeName, baseEnum.getMark());
                                    } else {
                                        writeKeyValue(typeName, "");
                                    }
                                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                                    writeKeyValue(typeName, "");
                                }
                            } else {
                                writeKeyValue(typeName, "");
                            }
                        }
                    }
                }
            }
        };
    }

    private static ValueFilter getValueFilter(Map<String, Map<String, BaseEnum>> map) {
        return (bean, keyName, keyValue) -> {
            try {
                if (keyValue == null) {
                    return null;
                }
                if (keyValue instanceof BaseEnum) {
                    Field field = ReflectionUtils.findField(bean.getClass(), keyName);
                    String simpleName = field.getType().getSimpleName();
                    if (!map.containsKey(simpleName)) {
                        Enum[] enumConstants = (Enum[]) keyValue.getClass().getEnumConstants();
                        Map<String, BaseEnum> enumsMap = new HashMap<>(enumConstants.length);
                        map.put(simpleName, enumsMap);
                        for (Enum baseEnum : enumConstants) {
                            String name = baseEnum.name();
                            BaseEnum anEnum = (BaseEnum) baseEnum;
                            enumsMap.put(name, anEnum);
                        }
                    }
                    String typeName = field.getName() + "Name";
                    String first = typeName.replaceFirst(typeName.substring(0, 1), typeName.substring(0, 1).toUpperCase());
                    try {
                        Method method = bean.getClass().getMethod("set" + first, String.class);
                        if (method != null) {
                            method.invoke(bean, ((BaseEnum) keyValue).getMark());
                        }
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
                    }
                    return keyValue;
                }
                return keyValue;
            } catch (Exception ignored) {
                return keyValue;
            }
        };
    }


    /**
     * 关闭 FAIL_ON_EMPTY_BEANS
     */
    /*@Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setTimeZone(TimeZone.getTimeZone(ZoneId.of("GMT+8")));
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return objectMapper;
    }*/
}

package com.zyf.springboot.config;

import com.zyf.springboot.config.converters.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * 类型参数绑定注册
 * @author zengyufei
 * @since 1.0.0
 */
@Configuration
public class DateConverConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new IndexToEnumConverterFactory());
    }

    /**
     * 增加字符串转日期的功能
     */
    @PostConstruct
    public void initEditableValidation() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer) this.handlerAdapter
                .getWebBindingInitializer();
        if (null != initializer.getConversionService()) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer
                    .getConversionService();
            //genericConversionService.addConverter(new StringToIntegerConverter());
            genericConversionService.addConverter(new StringToListConverter());
            genericConversionService.addConverter(new StringToDateConverter());
            genericConversionService.addConverter(new StringToCalendarConverter());
            genericConversionService.addConverter(new StringToIntegerListConverter());
            genericConversionService.addConverter(new StringArrayToIntegerListConverter());
            genericConversionService.addConverter(new StringArrayToStringListConverter());
            genericConversionService.addConverter(new StringToBigDecimalConverter());
        }
    }

    /**
     * 1、 extends WebMvcConfigurationSupport
     * 2、重写下面方法;
     * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
     * -- --  当此参数设置为 true 的时候，那么 /user.html，/user.aa，/user.* 都能是正常访问的。
     * -- --  当此参数设置为 false 的时候，那么只能访问 /user 或者 /user/( 这个前提是 setUseTrailingSlashMatch 设置为 true 了)。
     * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
     * -- --  当此参数设置为 true 的会后，那么地址 /user，/user/ 都能正常访问。
     * -- --  当此参数设置为 false 的时候，那么就只能访问 /user 了。
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false)
                .setUseTrailingSlashMatch(true);
    }

}
package com.zyf.springboot.config;

import com.zyf.springboot.base.orika.OrikaMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class OrikaConfigurer {

    @Bean
    public OrikaMapper orikaMapperBean() {
        return new OrikaMapper();
    }
}
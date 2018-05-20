package com.zyf.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * 配置Druid的监控统计功能
 * @author zengyufei
 * @since 1.0.0
 */
@Profile("local-test")
@Configuration
public class DruidConfiguration {

    @Profile("local-test")
    @Bean     //声明其为Bean实例
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/config/H2_TYPE.sql")
                .addScript("classpath:/config/INIT_TABLE.sql")
                .addScript("classpath:/config/INIT_DATA.sql")
                .build();
    }
}
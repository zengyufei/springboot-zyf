package com.zyf.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * mybatis 相关配置类
 * @author zengyufei
 * @since 1.0.0
 */
//@Configuration
@ConditionalOnClass({SqlSessionFactory.class, org.mybatis.spring.SqlSessionFactoryBean.class})
@AutoConfigureAfter(DataSourceAutoConfiguration.class) //类的载入顺序，在。。。之后
public class MybatisConfiguration {

    @Value("${mybatis.enum-scan-path}")
    private String enumScanPath;
    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;
    @Value("${mybatis.type-handlers-package}")
    private String typeHandlersPackage;
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis.config-location}")
    private String configLocation;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Bean(name = "sqlSessionFactory")
    @ConditionalOnMissingBean //判断是否执行初始化代码，即如果用户已经创建了该类，则相关的初始化代码不再执行
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        CustomSqlSessionFactoryBean factory = new CustomSqlSessionFactoryBean();
        //注册dataSource
        factory.setDataSource(dataSource);
        factory.setConfigLocation(resolver.getResource(configLocation));
        //实体类别名注册，用于 mapper.xml resultMap type
        factory.setTypeAliasesPackage(typeAliasesPackage);
        //扫描 mapper.xml
        factory.setMapperLocations(resolver.getResources(mapperLocations));
        factory.setTypeHandlersPackage(typeHandlersPackage);
        factory.setEnumScanPath(enumScanPath);
        return factory.getObject();
    }

}

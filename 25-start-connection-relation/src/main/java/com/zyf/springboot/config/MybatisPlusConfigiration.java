package com.zyf.springboot.config;

import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisMapperRefresh;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;


@Configuration
@EnableTransactionManagement  // 开启事务
@MapperScan("com.zyf.springboot.mapper")
public class MybatisPlusConfigiration {

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    @Profile({"dev", "test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //performanceInterceptor.setFormat(true); // SQL是否格式化 默认false
        performanceInterceptor.setMaxTime(100); // maxTime 指的是 sql 最大执行时长
        return performanceInterceptor;
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持

        return paginationInterceptor;
    }

    /**
     * 乐观锁插件
     * 当要更新一条记录的时候，希望这条记录没有被别人更新
     * 乐观锁实现方式：
     * ------取出记录时，获取当前 version
     * ------更新时，带上这个 version
     * ------执行更新时，set version = yourVersion+1 where version = yourVersion
     * ------如果 version 不对，就更新失败
     */
    @Bean
    public OptimisticLockerInterceptor getOptimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 编译 XML 热刷新
     */
    @Bean
    public MybatisMapperRefresh getMybatisMapperRefresh() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(this.mapperLocations);
        return new MybatisMapperRefresh(
                resources,
                this.sqlSessionFactory,
                10,
                10,
                true
        );
    }

}
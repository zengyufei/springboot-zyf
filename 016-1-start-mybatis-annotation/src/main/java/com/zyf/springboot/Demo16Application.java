package com.zyf.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zyf.springboot.mapper")
@SpringBootApplication
public class Demo16Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo16Application.class, args);
    }
}

package com.zyf.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo27Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Demo27Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}

package com.zyf.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo26Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Demo26Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}

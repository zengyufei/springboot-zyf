package com.zyf.springboot.service.test;

import com.zyf.springboot.Demo26ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

public class TestServiceTest extends Demo26ApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    public void insert() {
        com.zyf.springboot.entity.test.Test test = new com.zyf.springboot.entity.test.Test();
        test.setName("test");
        test.setAge(1);
        test.setCreateTime(new Date());
        test.setUpdateTime(Calendar.getInstance());
        this.testService.insert(test);
    }
}
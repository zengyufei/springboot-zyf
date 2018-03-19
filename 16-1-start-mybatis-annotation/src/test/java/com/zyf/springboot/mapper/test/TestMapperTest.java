package com.zyf.springboot.mapper.test;

import com.alibaba.fastjson.JSONObject;
import com.zyf.springboot.Demo16ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestMapperTest extends Demo16ApplicationTests {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void add() {
        com.zyf.springboot.entity.test.Test test = new com.zyf.springboot.entity.test.Test();
        int effect = testMapper.add(test);
        System.out.println(effect);
        System.out.println(JSONObject.toJSONString(test));
    }

    @Test
    public void update() {
        com.zyf.springboot.entity.test.Test test = new com.zyf.springboot.entity.test.Test();
        test.setId(new BigDecimal(1));
        test.setName("zengyufei");
        int effect = testMapper.update(test);
        System.out.println(effect);
        System.out.println(JSONObject.toJSONString(test));
    }

    @Test
    public void selectInIds() {
        List<BigDecimal> ids = new ArrayList<>();
        ids.add(new BigDecimal(1));
        ids.add(new BigDecimal(2));
        List<com.zyf.springboot.entity.test.Test> tests = testMapper.selectInIds(ids);
        System.out.println(JSONObject.toJSONString(tests));
    }

    @Test
    public void selectList() {
        com.zyf.springboot.entity.test.Test test = new com.zyf.springboot.entity.test.Test();
        test.setId(new BigDecimal(1));
        List<com.zyf.springboot.entity.test.Test> tests = testMapper.selectList(test);
        System.out.println(JSONObject.toJSONString(tests));
    }

    @Test
    public void count() {
        com.zyf.springboot.entity.test.Test test = new com.zyf.springboot.entity.test.Test();
        test.setId(new BigDecimal(1));
        int count = testMapper.count(test);
        System.out.println(count);
    }
}
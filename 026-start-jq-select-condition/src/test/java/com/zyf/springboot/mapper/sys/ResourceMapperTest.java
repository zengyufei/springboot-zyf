package com.zyf.springboot.mapper.sys;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zyf.springboot.Demo26ApplicationTests;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.enums.LevelType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResourceMapperTest extends Demo26ApplicationTests {

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    public void list() {
        Resource resource = new Resource();
        resource.setLevel(LevelType.TWO);
        Wrapper<Resource> wrapper = new EntityWrapper<>(resource);
        List<Resource> resources = this.resourceMapper.selectList(wrapper);
        System.out.println(JSONObject.toJSONString(resources));
    }

    @Test
    public void selectAllParent() {
        List<Resource> resources = this.resourceMapper.selectAllParent(2);
        System.out.println(JSONObject.toJSONString(resources));
    }
}
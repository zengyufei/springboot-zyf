package com.zyf.springboot.mapper.sys;

import com.alibaba.fastjson.JSONObject;
import com.zyf.springboot.Demo25ApplicationTests;
import com.zyf.springboot.entity.sys.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResourceMapperTest extends Demo25ApplicationTests {

    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    public void selectAllParent() {
        List<Resource> resources = this.resourceMapper.selectAllParent(2);
        System.out.println(JSONObject.toJSONString(resources));
    }
}
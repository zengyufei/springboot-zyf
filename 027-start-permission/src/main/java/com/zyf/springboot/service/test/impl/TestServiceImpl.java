package com.zyf.springboot.service.test.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zyf.springboot.entity.test.Test;
import com.zyf.springboot.mapper.test.TestMapper;
import com.zyf.springboot.service.test.TestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Override
    public boolean insert(Test entity) {
        boolean insert = super.insert(entity);
        int i = 1 / 0;
        return insert;
    }
}

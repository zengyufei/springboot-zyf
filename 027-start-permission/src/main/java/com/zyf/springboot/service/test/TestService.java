package com.zyf.springboot.service.test;

import com.baomidou.mybatisplus.service.IService;
import com.zyf.springboot.entity.test.Test;

/**
 * 测试类
 * @author zengyufei
 * @since 1.0.0
 */
public interface TestService extends IService<Test> {

    @Override
    boolean insert(Test entity);
}

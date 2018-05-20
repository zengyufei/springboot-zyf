package com.zyf.springboot.service.sys.operation;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.OperationService;
import com.zyf.springboot.vo.sys.OperationVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class OperationServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private OperationService operationService;

    @Test
    public void get() {
        OperationVo operationVo = this.operationService.selectVoById(1);
        Assert.notNull(operationVo, "get 查询为空");
    }

    @Test
    public void list() {
        List<OperationVo> operationVos = this.operationService.selectVoList(new EntityWrapper<>(new OperationVo()));
        Assert.notEmpty(operationVos, "list 数据为空");
    }

}
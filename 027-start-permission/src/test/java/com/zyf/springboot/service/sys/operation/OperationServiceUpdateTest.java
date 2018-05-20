package com.zyf.springboot.service.sys.operation;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.Operation;
import com.zyf.springboot.service.sys.OperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class OperationServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private OperationService operationService;

    @Test
    public void update() {
        Operation operation = this.operationService.selectById(1);
        operation.setOperationName("测试");
        boolean effect = this.operationService.updateById(operation);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
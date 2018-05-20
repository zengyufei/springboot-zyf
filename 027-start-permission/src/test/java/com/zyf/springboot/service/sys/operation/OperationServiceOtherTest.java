package com.zyf.springboot.service.sys.operation;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.OperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class OperationServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private OperationService operationService;

    @Test
    public void deleteById() {
        boolean effect = this.operationService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
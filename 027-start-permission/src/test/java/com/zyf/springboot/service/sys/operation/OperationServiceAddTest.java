package com.zyf.springboot.service.sys.operation;

import com.github.jsonzou.jmockdata.JMockData;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.OperationService;
import com.zyf.springboot.vo.sys.OperationVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class OperationServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private OperationService operationService;

    private OperationVo getMock() {
        OperationVo operationVo = new OperationVo();
        operationVo.setOperationName(JMockData.mock(String.class));
        operationVo.setParentId(1);
        return operationVo;
    }

    @Test
    public void addSuccess() {
        OperationVo mock = getMock();
        boolean effect = this.operationService.insertVo(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void addOperationnameNull() {
        OperationVo mock = getMock();
        mock.setOperationName(null);
        boolean effect = this.operationService.insertVo(mock);
        Assert.isTrue(effect == Boolean.TRUE, "insert 预期失败");
    }

    @Test
    public void addOperationnameBlank() {
        OperationVo mock = getMock();
        mock.setOperationName("");
        boolean effect = this.operationService.insertVo(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
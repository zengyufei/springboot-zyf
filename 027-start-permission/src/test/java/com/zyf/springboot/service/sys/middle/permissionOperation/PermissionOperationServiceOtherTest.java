package com.zyf.springboot.service.sys.middle.permissionOperation;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.middle.PermissionOperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class PermissionOperationServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private PermissionOperationService permissionOperationService;

    @Test
    public void deleteById() {
        boolean effect = this.permissionOperationService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
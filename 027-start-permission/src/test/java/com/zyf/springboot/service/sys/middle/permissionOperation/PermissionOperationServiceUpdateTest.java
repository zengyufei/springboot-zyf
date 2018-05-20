package com.zyf.springboot.service.sys.middle.permissionOperation;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.PermissionOperation;
import com.zyf.springboot.service.sys.middle.PermissionOperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class PermissionOperationServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private PermissionOperationService permissionOperationService;

    @Test
    public void update() {
        PermissionOperation permissionOperation = this.permissionOperationService.selectById(1);
        permissionOperation.setOperationId(2);
        boolean effect = this.permissionOperationService.updateById(permissionOperation);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
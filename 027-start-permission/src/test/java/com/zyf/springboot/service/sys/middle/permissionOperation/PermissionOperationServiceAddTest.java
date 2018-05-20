package com.zyf.springboot.service.sys.middle.permissionOperation;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.PermissionOperation;
import com.zyf.springboot.service.sys.middle.PermissionOperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class PermissionOperationServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private PermissionOperationService permissionOperationService;

    private PermissionOperation getMock() {
        PermissionOperation permissionOperation = new PermissionOperation();
        permissionOperation.setPermissionId(2);
        permissionOperation.setOperationId(1);
        return permissionOperation;
    }

    @Test
    public void addSuccess() {
        PermissionOperation mock = getMock();
        boolean effect = this.permissionOperationService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
package com.zyf.springboot.service.sys.permission;

import com.github.jsonzou.jmockdata.JMockData;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.service.sys.PermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class PermissionServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private PermissionService permissionService;

    private Permission getMock() {
        Permission permission = new Permission();
        permission.setPermissionName(JMockData.mock(String.class));
        permission.setParentId(1);
        return permission;
    }

    @Test
    public void addSuccess() {
        Permission mock = getMock();
        boolean effect = this.permissionService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void addPermissionnameNull() {
        Permission mock = getMock();
        mock.setPermissionName(null);
        boolean effect = this.permissionService.insert(mock);
        Assert.isTrue(effect == Boolean.TRUE, "insert 预期失败");
    }

    @Test
    public void addPermissionnameBlank() {
        Permission mock = getMock();
        mock.setPermissionName("");
        boolean effect = this.permissionService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
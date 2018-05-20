package com.zyf.springboot.service.sys.middle.rolePermission;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.RolePermission;
import com.zyf.springboot.service.sys.middle.RolePermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RolePermissionServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private RolePermissionService rolePermissionService;

    private RolePermission getMock() {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(1);
        rolePermission.setPermissionId(2);
        return rolePermission;
    }

    @Test
    public void addSuccess() {
        RolePermission mock = getMock();
        boolean effect = this.rolePermissionService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
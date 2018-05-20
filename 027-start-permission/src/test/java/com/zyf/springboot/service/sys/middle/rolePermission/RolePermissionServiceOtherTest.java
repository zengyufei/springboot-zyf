package com.zyf.springboot.service.sys.middle.rolePermission;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.middle.RolePermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RolePermissionServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Test
    public void deleteById() {
        boolean effect = this.rolePermissionService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
package com.zyf.springboot.service.sys.permission;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.service.sys.PermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class PermissionServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void update() {
        Permission permission = this.permissionService.selectById(1);
        permission.setPermissionName("测试");
        boolean effect = this.permissionService.updateById(permission);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
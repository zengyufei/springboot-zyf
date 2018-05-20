package com.zyf.springboot.service.sys.middle.rolePermission;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.RolePermission;
import com.zyf.springboot.service.sys.middle.RolePermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RolePermissionServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Test
    public void update() {
        RolePermission rolePermission = this.rolePermissionService.selectById(1);
        rolePermission.setRoleId(2);
        boolean effect = this.rolePermissionService.updateById(rolePermission);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
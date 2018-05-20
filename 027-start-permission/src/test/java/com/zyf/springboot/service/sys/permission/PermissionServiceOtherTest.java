package com.zyf.springboot.service.sys.permission;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.PermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class PermissionServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void deleteById() {
        boolean effect = this.permissionService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
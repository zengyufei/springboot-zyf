package com.zyf.springboot.service.sys.middle.userRole;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.UserRole;
import com.zyf.springboot.service.sys.middle.UserRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserRoleServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void update() {
        UserRole userRole = this.userRoleService.selectById(1);
        userRole.setRoleId(2);
        boolean effect = this.userRoleService.updateById(userRole);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
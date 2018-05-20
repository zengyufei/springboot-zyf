package com.zyf.springboot.service.sys.middle.userRole;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.middle.UserRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserRoleServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void deleteById() {
        boolean effect = this.userRoleService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
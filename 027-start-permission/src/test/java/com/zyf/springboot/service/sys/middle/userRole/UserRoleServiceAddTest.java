package com.zyf.springboot.service.sys.middle.userRole;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.UserRole;
import com.zyf.springboot.service.sys.middle.UserRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserRoleServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private UserRoleService userRoleService;

    private UserRole getMock() {
        UserRole userRole = new UserRole();
        userRole.setUserId(2);
        userRole.setRoleId(1);
        return userRole;
    }

    @Test
    public void addSuccess() {
        UserRole mock = getMock();
        boolean effect = this.userRoleService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
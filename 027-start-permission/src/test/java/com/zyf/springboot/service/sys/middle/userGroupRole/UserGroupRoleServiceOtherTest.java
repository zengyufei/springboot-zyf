package com.zyf.springboot.service.sys.middle.userGroupRole;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.middle.UserGroupRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserGroupRoleServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupRoleService userGroupRoleService;

    @Test
    public void deleteById() {
        boolean effect = this.userGroupRoleService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
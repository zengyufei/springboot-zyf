package com.zyf.springboot.service.sys.middle.userGroupRole;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.UserGroupRole;
import com.zyf.springboot.service.sys.middle.UserGroupRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserGroupRoleServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupRoleService userGroupRoleService;

    private UserGroupRole getMock() {
        UserGroupRole userGroupRole = new UserGroupRole();
        userGroupRole.setUserGroupId(2);
        userGroupRole.setRoleId(1);
        return userGroupRole;
    }

    @Test
    public void addSuccess() {
        UserGroupRole mock = getMock();
        boolean effect = this.userGroupRoleService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
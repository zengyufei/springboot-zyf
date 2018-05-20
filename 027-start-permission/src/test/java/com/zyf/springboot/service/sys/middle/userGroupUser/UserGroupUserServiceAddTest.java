package com.zyf.springboot.service.sys.middle.userGroupUser;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.UserGroupUser;
import com.zyf.springboot.service.sys.middle.UserGroupUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserGroupUserServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupUserService userGroupUserService;

    private UserGroupUser getMock() {
        UserGroupUser userGroupUser = new UserGroupUser();
        userGroupUser.setUserGroupId(2);
        userGroupUser.setUserId(1);
        return userGroupUser;
    }

    @Test
    public void addSuccess() {
        UserGroupUser mock = getMock();
        boolean effect = this.userGroupUserService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
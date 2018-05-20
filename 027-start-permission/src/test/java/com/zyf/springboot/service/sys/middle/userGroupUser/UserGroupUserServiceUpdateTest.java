package com.zyf.springboot.service.sys.middle.userGroupUser;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.UserGroupUser;
import com.zyf.springboot.service.sys.middle.UserGroupUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserGroupUserServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupUserService userGroupUserService;

    @Test
    public void update() {
        UserGroupUser userGroupUser = this.userGroupUserService.selectById(1);
        userGroupUser.setUserId(2);
        boolean effect = this.userGroupUserService.updateById(userGroupUser);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
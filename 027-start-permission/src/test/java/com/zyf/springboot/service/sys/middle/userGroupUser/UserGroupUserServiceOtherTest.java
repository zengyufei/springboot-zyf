package com.zyf.springboot.service.sys.middle.userGroupUser;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.middle.UserGroupUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserGroupUserServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupUserService userGroupUserService;

    @Test
    public void deleteById() {
        boolean effect = this.userGroupUserService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
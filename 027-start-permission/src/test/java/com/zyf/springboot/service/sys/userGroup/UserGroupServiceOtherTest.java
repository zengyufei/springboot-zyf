package com.zyf.springboot.service.sys.userGroup;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.UserGroupService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserGroupServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupService userGroupService;

    @Test
    public void deleteById() {
        boolean effect = this.userGroupService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
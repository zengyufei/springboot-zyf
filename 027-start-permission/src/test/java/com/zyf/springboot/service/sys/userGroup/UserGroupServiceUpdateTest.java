package com.zyf.springboot.service.sys.userGroup;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.service.sys.UserGroupService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserGroupServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupService userGroupService;

    @Test
    public void update() {
        UserGroup userGroup = this.userGroupService.selectById(1);
        userGroup.setUserGroupName("测试");
        boolean effect = this.userGroupService.updateById(userGroup);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
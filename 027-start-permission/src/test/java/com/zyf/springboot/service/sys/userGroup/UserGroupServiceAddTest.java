package com.zyf.springboot.service.sys.userGroup;

import com.github.jsonzou.jmockdata.JMockData;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.service.sys.UserGroupService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserGroupServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupService userGroupService;

    private UserGroup getMock() {
        UserGroup userGroup = new UserGroup();
        userGroup.setUserGroupName(JMockData.mock(String.class));
        userGroup.setParentId(1);
        return userGroup;
    }

    @Test
    public void addSuccess() {
        UserGroup mock = getMock();
        boolean effect = this.userGroupService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void addUserGroupnameNull() {
        UserGroup mock = getMock();
        mock.setUserGroupName(null);
        boolean effect = this.userGroupService.insert(mock);
        Assert.isTrue(effect == Boolean.TRUE, "insert 预期失败");
    }

    @Test
    public void addUserGroupnameBlank() {
        UserGroup mock = getMock();
        mock.setUserGroupName("");
        boolean effect = this.userGroupService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
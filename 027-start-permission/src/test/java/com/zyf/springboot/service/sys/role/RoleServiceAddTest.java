package com.zyf.springboot.service.sys.role;

import com.github.jsonzou.jmockdata.JMockData;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.service.sys.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RoleServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private RoleService roleService;

    private Role getMock() {
        Role role = new Role();
        role.setRoleName(JMockData.mock(String.class));
        role.setDescription(JMockData.mock(String.class));
        role.setParentId(1);
        role.setEnable(true);
        return role;
    }

    @Test
    public void addSuccess() {
        Role mock = getMock();
        boolean effect = this.roleService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void addRolenameNull() {
        Role mock = getMock();
        mock.setRoleName(null);
        boolean effect = this.roleService.insert(mock);
        Assert.isTrue(effect == Boolean.TRUE, "insert 预期失败");
    }

    @Test
    public void addRolenameBlank() {
        Role mock = getMock();
        mock.setRoleName("");
        boolean effect = this.roleService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
package com.zyf.springboot.service.sys.role;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.service.sys.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RoleServiceUpdateTest extends Demo27ApplicationTests {

    @Autowired
    private RoleService roleService;

    @Test
    public void update() {
        Role role = this.roleService.selectById(1);
        role.setRoleName("测试");
        boolean effect = this.roleService.updateById(role);
        Assert.isTrue(effect, "update 失败，数据库层面失败");
    }

}
package com.zyf.springboot.service.sys.role;

import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RoleServiceOtherTest extends Demo27ApplicationTests {

    @Autowired
    private RoleService roleService;

    @Test
    public void deleteById() {
        boolean effect = this.roleService.deleteById(2);
        Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
    }

}
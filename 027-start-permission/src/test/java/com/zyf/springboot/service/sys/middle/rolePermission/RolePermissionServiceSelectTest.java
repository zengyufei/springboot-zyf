package com.zyf.springboot.service.sys.middle.rolePermission;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.RolePermission;
import com.zyf.springboot.service.sys.middle.RolePermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class RolePermissionServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Test
    public void get() {
        RolePermission rolePermission = this.rolePermissionService.selectById(1);
        Assert.notNull(rolePermission, "get 查询为空");
    }

    @Test
    public void list() {
        List<RolePermission> rolePermissionVos = this.rolePermissionService.selectList(new EntityWrapper<>(new RolePermission()));
        Assert.notEmpty(rolePermissionVos, "list 数据为空");
    }

}
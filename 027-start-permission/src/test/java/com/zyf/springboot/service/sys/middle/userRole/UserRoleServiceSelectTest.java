package com.zyf.springboot.service.sys.middle.userRole;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.UserRole;
import com.zyf.springboot.service.sys.middle.UserRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class UserRoleServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void get() {
        UserRole userRole = this.userRoleService.selectById(1);
        Assert.notNull(userRole, "get 查询为空");
    }

    @Test
    public void list() {
        List<UserRole> userRoleVos = this.userRoleService.selectList(new EntityWrapper<>(new UserRole()));
        Assert.notEmpty(userRoleVos, "list 数据为空");
    }

}
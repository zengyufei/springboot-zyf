package com.zyf.springboot.service.sys.middle.userGroupRole;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.UserGroupRole;
import com.zyf.springboot.service.sys.middle.UserGroupRoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class UserGroupRoleServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupRoleService userGroupRoleService;

    @Test
    public void get() {
        UserGroupRole userGroupRole = this.userGroupRoleService.selectById(1);
        Assert.notNull(userGroupRole, "get 查询为空");
    }

    @Test
    public void list() {
        List<UserGroupRole> userGroupRoleVos = this.userGroupRoleService.selectList(new EntityWrapper<>(new UserGroupRole()));
        Assert.notEmpty(userGroupRoleVos, "list 数据为空");
    }

}
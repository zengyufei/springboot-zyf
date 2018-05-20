package com.zyf.springboot.service.sys.middle.userGroupUser;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.UserGroupUser;
import com.zyf.springboot.service.sys.middle.UserGroupUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class UserGroupUserServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupUserService userGroupUserService;

    @Test
    public void get() {
        UserGroupUser userGroupUser = this.userGroupUserService.selectById(1);
        Assert.notNull(userGroupUser, "get 查询为空");
    }

    @Test
    public void list() {
        List<UserGroupUser> userGroupUserVos = this.userGroupUserService.selectList(new EntityWrapper<>(new UserGroupUser()));
        Assert.notEmpty(userGroupUserVos, "list 数据为空");
    }

}
package com.zyf.springboot.service.sys.userGroup;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.UserGroupService;
import com.zyf.springboot.vo.sys.UserGroupVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class UserGroupServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private UserGroupService userGroupService;

    @Test
    public void get() {
        UserGroupVo userGroupVo = this.userGroupService.selectVoById(1);
        Assert.notNull(userGroupVo, "get 查询为空");
    }

    @Test
    public void list() {
        List<UserGroupVo> userGroupVos = this.userGroupService.selectVoList(new EntityWrapper<>(new UserGroupVo()));
        Assert.notEmpty(userGroupVos, "list 数据为空");
    }

}
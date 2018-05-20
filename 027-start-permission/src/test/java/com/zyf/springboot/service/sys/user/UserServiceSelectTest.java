package com.zyf.springboot.service.sys.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.UserService;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class UserServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void get() {
        UserVo userVo = this.userService.selectVoById(1);
        Assert.notNull(userVo, "get 查询为空");
    }

    @Test
    public void list() {
        List<UserVo> userVos = this.userService.selectVoList(new EntityWrapper<>(new UserVo()));
        Assert.notEmpty(userVos, "list 数据为空");
    }

}
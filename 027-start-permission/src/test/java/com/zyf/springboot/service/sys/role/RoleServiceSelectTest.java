package com.zyf.springboot.service.sys.role;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class RoleServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private RoleService roleService;

    @Test
    public void get() {
        RoleVo roleVo = this.roleService.selectVoById(1);
        Assert.notNull(roleVo, "get 查询为空");
    }

    @Test
    public void list() {
        List<RoleVo> roleVos = this.roleService.selectVoList(new EntityWrapper<>(new RoleVo()));
        Assert.notEmpty(roleVos, "list 数据为空");
    }

}
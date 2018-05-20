package com.zyf.springboot.service.sys.permission;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.service.sys.PermissionService;
import com.zyf.springboot.vo.sys.PermissionVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class PermissionServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void get() {
        PermissionVo permissionVo = this.permissionService.selectVoById(1);
        Assert.notNull(permissionVo, "get 查询为空");
    }

    @Test
    public void list() {
        List<PermissionVo> permissionVos = this.permissionService.selectVoList(new EntityWrapper<>(new PermissionVo()));
        Assert.notEmpty(permissionVos, "list 数据为空");
    }

}
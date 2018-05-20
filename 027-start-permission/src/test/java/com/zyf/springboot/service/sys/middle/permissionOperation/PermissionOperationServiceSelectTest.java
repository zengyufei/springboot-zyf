package com.zyf.springboot.service.sys.middle.permissionOperation;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.middle.PermissionOperation;
import com.zyf.springboot.service.sys.middle.PermissionOperationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class PermissionOperationServiceSelectTest extends Demo27ApplicationTests {

    @Autowired
    private PermissionOperationService permissionOperationService;

    @Test
    public void get() {
        PermissionOperation permissionOperation = this.permissionOperationService.selectById(1);
        Assert.notNull(permissionOperation, "get 查询为空");
    }

    @Test
    public void list() {
        List<PermissionOperation> permissionOperationVos = this.permissionOperationService.selectList(new EntityWrapper<>(new PermissionOperation()));
        Assert.notEmpty(permissionOperationVos, "list 数据为空");
    }

}
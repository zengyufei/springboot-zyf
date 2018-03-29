package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo26ApplicationTests;
import com.zyf.springboot.entity.sys.RoleResource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class RoleResourceServiceTest extends Demo26ApplicationTests {

    @Autowired
    private RoleResourceService roleResourceService;

    @Test
    public void curd() {
        add();
        get();
        list();
        update();
        deleteById();
    }

    @Test
    public void get() {
        RoleResource roleResource = this.roleResourceService.selectById(1);
        Assert.notNull(roleResource, "get 查询为空");
    }

    @Test
    public void list() {
        List<RoleResource> roleResources = this.roleResourceService.selectList(new EntityWrapper<>(new RoleResource()));
        Assert.notEmpty(roleResources, "list 数据为空");
    }

    @Test
    public void add() {
        RoleResource roleResource = new RoleResource();
        roleResource.setRoleId(1);
        roleResource.setResourceId(1);
        boolean effect = this.roleResourceService.insert(roleResource);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void update() {
        RoleResource lastVo = getLast();
        if (lastVo != null) {
            lastVo.setResourceId(2);
            boolean effect = this.roleResourceService.updateById(lastVo);
            Assert.isTrue(effect, "update 失败，数据库层面失败");
        }
    }

    @Test
    public void deleteById() {
        RoleResource lastVo = getLast();
        if (lastVo != null) {
            boolean effect = this.roleResourceService.deleteById(lastVo.getId());
            Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
        }
    }

    private RoleResource getLast() {
        List<RoleResource> roleResources = this.roleResourceService.selectList(new EntityWrapper<>(new RoleResource()));
        if (!CollectionUtils.isEmpty(roleResources)) {
            return roleResources.get(roleResources.size() - 1);
        }
        return null;
    }
}
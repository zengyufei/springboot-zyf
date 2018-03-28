package com.zyf.springboot.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo25ApplicationTests;
import com.zyf.springboot.entity.sys.UserRole;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class UserRoleServiceTest extends Demo25ApplicationTests {

    @Autowired
    private UserRoleService userRoleService;

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
        UserRole userRole = this.userRoleService.selectById(1);
        Assert.notNull(userRole, "get 查询为空");
    }

    @Test
    public void list() {
        List<UserRole> userRoles = this.userRoleService.selectList(new EntityWrapper<>(new UserRole()));
        Assert.notEmpty(userRoles, "list 数据为空");
    }

    @Test
    public void add() {
        UserRole userRole = new UserRole();
        userRole.setUserId(1);
        userRole.setRoleId(1);
        boolean effect = this.userRoleService.insert(userRole);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void update() {
        UserRole lastVo = getLast();
        if (lastVo != null) {
            lastVo.setUserId(2);
            boolean effect = this.userRoleService.updateById(lastVo);
            Assert.isTrue(effect, "update 失败，数据库层面失败");
        }
    }

    @Test
    public void deleteById() {
        UserRole lastVo = getLast();
        if (lastVo != null) {
            boolean effect = this.userRoleService.deleteById(lastVo.getId());
            Assert.isTrue(effect, "deleteById 失败，数据库层面失败");
        }
    }

    private UserRole getLast() {
        List<UserRole> userRoles = this.userRoleService.selectList(new EntityWrapper<>(new UserRole()));
        if (!CollectionUtils.isEmpty(userRoles)) {
            return userRoles.get(userRoles.size() - 1);
        }
        return null;
    }
}
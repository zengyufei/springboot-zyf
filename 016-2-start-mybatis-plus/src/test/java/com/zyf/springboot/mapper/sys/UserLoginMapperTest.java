package com.zyf.springboot.mapper.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo162ApplicationTests;
import com.zyf.springboot.entity.sys.UserLogin;
import com.zyf.springboot.enums.UserType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class UserLoginMapperTest extends Demo162ApplicationTests {

    @Autowired
    private UserLoginMapper userLoginMapper;

    @Test
    public void get() {
        UserLogin userLogin = userLoginMapper.selectById(1);
        Assert.notNull(userLogin, "get 查询为空");
    }

    @Test
    public void list() {
        EntityWrapper<UserLogin> wrapper = new EntityWrapper<>();
        List<UserLogin> list = userLoginMapper.selectList(wrapper);
        Assert.notEmpty(list, "list 数据为空");
    }

    @Test
    public void count() {
        EntityWrapper<UserLogin> wrapper = new EntityWrapper<>();
        Integer count = userLoginMapper.selectCount(wrapper);
        Assert.isTrue(count > 0, "count 为 0");
    }

    @Test
    public void add() {
        UserLogin userLogin = new UserLogin();
        userLogin.setEnable(true);
        userLogin.setPassword("admin");
        userLogin.setType(UserType.SYSTEM_USER);
        userLogin.setUserId(1);
        userLogin.setUsername("admin");
        int effect = userLoginMapper.insert(userLogin);
        Assert.isTrue(effect > 0, "insert 失败，数据库层面失败");
    }

    @Test
    public void update() {
        UserLogin last = getLast();
        if (last != null) {
            last.setType(UserType.OTHER_USER);
            int effect = userLoginMapper.updateById(last);
            Assert.isTrue(effect > 0, "update 失败，数据库层面失败");
        }
    }

    @Test
    public void deleteById() {
        Integer effect = userLoginMapper.deleteById(1);
        Assert.isTrue(effect > 0, "deleteById 失败，数据库层面失败");
    }

    private UserLogin getLast() {
        EntityWrapper<UserLogin> entityWrapper = new EntityWrapper();
        entityWrapper.last("limit 1");
        List<UserLogin> userLogins = userLoginMapper.selectList(entityWrapper);
        if (!CollectionUtils.isEmpty(userLogins)) {
            return userLogins.get(userLogins.size() - 1);
        }
        return null;
    }
}
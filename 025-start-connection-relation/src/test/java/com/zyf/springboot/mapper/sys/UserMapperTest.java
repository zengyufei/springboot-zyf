package com.zyf.springboot.mapper.sys;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.Demo25ApplicationTests;
import com.zyf.springboot.entity.sys.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class UserMapperTest extends Demo25ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void get() {
        User user = this.userMapper.selectById(1);
        Assert.notNull(user, "get 查询为空");
    }

    @Test
    public void list() {
        List<User> users = this.userMapper.selectList(Condition.EMPTY);
        Assert.notEmpty(users, "list 数据为空");
    }

    @Test
    public void count() {
        int count = this.userMapper.selectCount(Condition.EMPTY);
        Assert.isTrue(count > 0, "count 为 0");
    }

    @Test
    public void add() {
        User user = new User();
        user.setRealName("曾大佬");
        user.setAge(27);
        int effect = this.userMapper.insert(user);
        Assert.isTrue(effect > 0, "insert 失败，数据库层面失败");
    }

    @Test
    public void update() {
        User lastUser = getLast();
        if (lastUser != null) {
            lastUser.setAge(99);
            int effect = this.userMapper.updateById(lastUser);
            Assert.isTrue(effect > 0, "update 失败，数据库层面失败");
        }
    }

    @Test
    public void deleteById() {
        User lastUser = getLast();
        if (lastUser != null) {
            int effect = this.userMapper.deleteById(lastUser.getId());
            Assert.isTrue(effect > 0, "deleteById 失败，数据库层面失败");
        }
    }

    private User getLast() {
        EntityWrapper<User> entityWrapper = new EntityWrapper();
        entityWrapper.last("limit 1");
        List<User> users = this.userMapper.selectList(entityWrapper);
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(users.size() - 1);
        }
        return null;
    }
}
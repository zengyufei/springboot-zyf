package com.zyf.springboot.mapper.sys;

import com.alibaba.fastjson.JSONObject;
import com.zyf.springboot.Demo16ApplicationTests;
import com.zyf.springboot.entity.sys.User;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class UserMapperTest extends Demo16ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void get() {
        User user = userMapper.get(1);
        System.out.println(JSONObject.toJSONString(user));
    }

    @Test
    public void list() {
        List<User> users = userMapper.list(new User());
        System.out.println(JSONObject.toJSONString(users));
    }

    @Test
    public void listTime() throws ParseException {
        User user = new User();
        Date createStartTime = DateUtils.parseDate("2018-03-18 19:17:51", "yyyy-MM-dd HH:mm:ss");
        Date createEndTime = DateUtils.parseDate("2018-03-18 19:24:06", "yyyy-MM-dd HH:mm:ss");
        user.setCreateStartTime(createStartTime);
        user.setCreateEndTime(createEndTime);
        List<User> users = userMapper.list(user);
        System.out.println(JSONObject.toJSONString(users));
    }

    @Test
    public void count() {
        int count = userMapper.count(new User());
        System.out.println(count);
    }

    @Test
    public void add() {
        User user = new User();
        user.setRealName("曾大佬");
        user.setAge(27);
        int effect = userMapper.add(user);
        System.out.println(effect);
        System.out.println(JSONObject.toJSONString(user));
    }

    @Test
    public void update() {
        User lastUser = getLast();
        if (lastUser != null) {
            lastUser.setAge(99);
            int effect = userMapper.update(lastUser);
            System.out.println(effect);
        }
    }

    @Test
    public void deleteById() {
        User lastUser = getLast();
        if (lastUser != null) {
            int effect = userMapper.deleteById(lastUser.getId());
            System.out.println(effect);
        }
    }

    private User getLast() {
        List<User> users = userMapper.list(new User());
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(users.size() - 1);
        }
        return null;
    }
}
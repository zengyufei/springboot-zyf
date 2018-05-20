package com.zyf.springboot.service.sys.user;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.zyf.springboot.Demo27ApplicationTests;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.enums.SexType;
import com.zyf.springboot.service.sys.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserServiceAddTest extends Demo27ApplicationTests {

    @Autowired
    private UserService userService;

    private User getMock() {
        MockConfig mockConfig = new MockConfig();
        mockConfig.intRange(1, 99);
        User user = new User();
        user.setRealName(JMockData.mock(String.class));
        user.setAge(JMockData.mock(Integer.class, mockConfig));
        user.setSex(JMockData.mock(SexType.class));
        user.setUsername(JMockData.mock(String.class));
        user.setPassword(JMockData.mock(String.class));
        return user;
    }

    @Test
    public void addSuccess() {
        User mock = getMock();
        boolean effect = this.userService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

    @Test
    public void addUsernameNull() {
        User mock = getMock();
        mock.setUsername(null);
        boolean effect = this.userService.insert(mock);
        Assert.isTrue(effect == Boolean.TRUE, "insert 预期失败");
    }

    @Test
    public void addUsernameBlank() {
        User mock = getMock();
        mock.setUsername("");
        boolean effect = this.userService.insert(mock);
        Assert.isTrue(effect, "insert 失败，数据库层面失败");
    }

}
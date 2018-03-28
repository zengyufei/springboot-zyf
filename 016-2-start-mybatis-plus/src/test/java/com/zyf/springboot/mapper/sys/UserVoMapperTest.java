package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.Demo162ApplicationTests;
import com.zyf.springboot.vo.sys.UserVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class UserVoMapperTest extends Demo162ApplicationTests {

    @Autowired
    private UserVoMapper userVoMapper;

    @Test
    public void get() {
        UserVo userVo = userVoMapper.get(1);
        Assert.notNull(userVo, "get 查询为空");
    }

    @Test
    public void list() {
        List<UserVo> userVos = userVoMapper.selectList(new UserVo());
        Assert.notEmpty(userVos, "list 查询为空");
    }

    private UserVo getLast() {
        List<UserVo> userVos = userVoMapper.selectList(new UserVo());
        if (!CollectionUtils.isEmpty(userVos)) {
            return userVos.get(userVos.size() - 1);
        }
        return null;
    }
}
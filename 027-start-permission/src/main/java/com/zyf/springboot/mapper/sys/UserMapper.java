package com.zyf.springboot.mapper.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyf.springboot.entity.sys.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> selectListLeftJoin();
}

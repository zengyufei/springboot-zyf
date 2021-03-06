package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.entity.sys.UserLogin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserLoginMapper {

    @ResultMap(value = "userLoginMap")
    @Select("select * from user_login where id = #{id}")
    UserLogin get(@Param("id") Object id);

    List<UserLogin> list(UserLogin user);

    int count(UserLogin user);

    int add(UserLogin user);

    int update(UserLogin user);

    @Delete("delete from user_login where id = #{id}")
    int deleteById(Object id);
}

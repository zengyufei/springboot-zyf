package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.entity.sys.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @ResultMap(value = "userMap")
    @Select("select * from user where id = #{id}")
    User get(@Param("id") Object id);

    List<User> list(@Param("user") User user);

    int count(@Param("user") User user);

    @ResultMap(value = "userMap")
    @Select("select * from user_login where username = #{username} and password = #{password}")
    User login(@Param("username") String username,
               @Param("password") String password);

    int add(User user);

    int update(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(Object id);
}

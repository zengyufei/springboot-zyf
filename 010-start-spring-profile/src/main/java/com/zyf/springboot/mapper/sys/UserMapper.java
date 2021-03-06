package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.entity.sys.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User get(@Param("id") Object id);

    List<User> list(User user);

    int count(User user);

    @Select("select * from user_login where username = #{username} and password = #{password}")
    User login(@Param("username") String username,
               @Param("password") String password);

    int add(User user);

    int update(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(Object id);
}

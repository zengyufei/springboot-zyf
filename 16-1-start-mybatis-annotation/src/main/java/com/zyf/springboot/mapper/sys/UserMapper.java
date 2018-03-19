package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.config.languageDrivers.InsertLanguageDriver;
import com.zyf.springboot.config.languageDrivers.SelectWhereLangDriver;
import com.zyf.springboot.config.languageDrivers.UpdateNotNullLangDriver;
import com.zyf.springboot.entity.sys.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User get(@Param("id") Object id);

    @Lang(InsertLanguageDriver.class)
    @Insert("insert into user(#{user})")
    int add(User user);

    @Lang(SelectWhereLangDriver.class)
    @Select("select * from user (#{user})")
    List<User> list(User user);

    @Lang(SelectWhereLangDriver.class)
    @Select("select count(*) from user (#{user})")
    int count(User user);

    @Lang(UpdateNotNullLangDriver.class)
    @Update("update user(#{user}) where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(Object id);
}

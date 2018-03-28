package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.config.languageDrivers.InsertLanguageDriver;
import com.zyf.springboot.config.languageDrivers.SelectWhereLangDriver;
import com.zyf.springboot.config.languageDrivers.UpdateNotNullLangDriver;
import com.zyf.springboot.entity.sys.UserLogin;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserLoginMapper {

    @Select("select * from user_login where id = #{id}")
    UserLogin get(@Param("id") Object id);

    @Lang(SelectWhereLangDriver.class)
    @Select("select * from user_login (#{userLogin})")
    List<UserLogin> list(UserLogin userLogin);

    @Lang(SelectWhereLangDriver.class)
    @Select("select count(*) from user_login (#{userLogin})")
    int count(UserLogin userLogin);

    @Lang(InsertLanguageDriver.class)
    @Insert("insert into user_login(#{userLogin})")
    int add(UserLogin userLogin);

    @Lang(UpdateNotNullLangDriver.class)
    @Update("update user_login(#{userLogin}) where id = #{id}")
    int update(UserLogin user);

    @Delete("delete from user_login where id = #{id}")
    int deleteById(Object id);

}

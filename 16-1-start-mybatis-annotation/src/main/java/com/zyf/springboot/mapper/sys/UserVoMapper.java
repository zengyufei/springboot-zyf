package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.config.languageDrivers.SelectWhereLangDriver;
import com.zyf.springboot.vo.sys.UserVo;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserVoMapper {

    String ALL_COLUMN = "u.id,u.real_name,u.age,u.sex,u.create_time,u.update_time,ul.user_id,ul.username,ul.password,ul.type,ul.enable";

    @ResultMap("userVoMap")
    @Select("select " + ALL_COLUMN + " from user as u left join user_login as ul on u.id = ul.user_id where u.id = #{id}")
    UserVo get(@Param("id") Object id);

    @Lang(SelectWhereLangDriver.class)
    @Select("select " + ALL_COLUMN + " from user as u left join user_login as ul on u.id = ul.user_id (#{userVo})")
    List<UserVo> list(UserVo userVo);

    @Lang(SelectWhereLangDriver.class)
    @Select("select count(*) from user as u left join user_login as ul on u.id = ul.user_id (#{userVo})")
    int count(@Param("userVo") UserVo userVo);

    @ResultMap(value = "userVoMap")
    @Select("select " + ALL_COLUMN + " from user as u left join user_login as ul on u.id = ul.user_id " +
            "where username = #{username} and password = #{password}")
    UserVo login(@Param("username") String username,
                 @Param("password") String password);
}

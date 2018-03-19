package com.zyf.springboot.mapper.test;

import com.zyf.springboot.config.languageDrivers.InsertLanguageDriver;
import com.zyf.springboot.config.languageDrivers.SelectInLangDriver;
import com.zyf.springboot.config.languageDrivers.SelectWhereLangDriver;
import com.zyf.springboot.config.languageDrivers.UpdateLangDriver;
import com.zyf.springboot.entity.test.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

public interface TestMapper {

    @Lang(InsertLanguageDriver.class)
    @Insert("insert into test(#{test}) ")
    int add(Test test);

    @Lang(UpdateLangDriver.class)
    @Insert("update test(#{test}) where id = #{id}")
    int update(Test test);

    @Lang(SelectInLangDriver.class)
    @Select("select * from test where id in (#{ids})")
    List<Test> selectInIds(@Param("ids") List<BigDecimal> ids);

    @Lang(SelectWhereLangDriver.class)
    @Select("SELECT * FROM test (#{test})")
    List<Test> selectList(Test test);

    @Lang(SelectWhereLangDriver.class)
    @Select("SELECT count(*) FROM test (#{test})")
    int count(Test test);
}

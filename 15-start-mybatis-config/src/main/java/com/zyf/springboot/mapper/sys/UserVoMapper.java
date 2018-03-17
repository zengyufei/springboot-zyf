package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.vo.sys.UserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserVoMapper {

    @ResultMap("userVoMap")
    @Select("select * from user as u left join user_login as ul on u.id = ul.user_id")
    UserVo get(@Param("id") Object id);

    List<UserVo> list(@Param("userVo") UserVo userVo);

    int count(@Param("userVo") UserVo userVo);

}

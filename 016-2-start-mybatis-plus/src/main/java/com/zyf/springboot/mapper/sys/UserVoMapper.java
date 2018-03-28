package com.zyf.springboot.mapper.sys;

import com.zyf.springboot.vo.sys.UserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserVoMapper {

    String SELECT_COLUMN = "u.*,ul.user_id,ul.username,ul.password,ul.type,ul.enable,ul.enable_time";

    @Select("select " + SELECT_COLUMN + " from user as u left join user_login as ul on u.id = ul.user_id where u.id = #{id}")
    UserVo get(@Param("id") Object id);

    List<UserVo> selectList(@Param("userVo") UserVo userVo);

    int count(@Param("userVo") UserVo userVo);

}

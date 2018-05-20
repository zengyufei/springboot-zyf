package com.zyf.springboot.mapper.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyf.springboot.entity.sys.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectAllParent(@Param("id") Integer id);

    List<Permission> selectAllChildren(@Param("id") Integer id);

}

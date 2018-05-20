package com.zyf.springboot.mapper.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyf.springboot.entity.sys.Operation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationMapper extends BaseMapper<Operation> {

    List<Operation> selectAllParent(@Param("id") Integer id);

    List<Operation> selectAllChildren(@Param("id") Integer id);

}

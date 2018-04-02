package com.zyf.springboot.mapper.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyf.springboot.entity.sys.Resource;

import java.util.List;

public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> selectAllParent(Integer id);

    List<Resource> selectAllChildren(Integer id);

}

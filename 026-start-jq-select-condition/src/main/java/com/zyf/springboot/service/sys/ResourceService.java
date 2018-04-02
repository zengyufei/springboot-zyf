package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVo;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.vo.sys.ResourceVo;

public interface ResourceService extends AbstractServiceVo<Resource, ResourceVo> {

    Msg addResource(ResourceVo resourceVo);

    Msg updateResource(ResourceVo resourceVo);

    Msg deleteResource(Integer id);

    Msg tree();

    Msg list(ResourceVo resourceVo);
}

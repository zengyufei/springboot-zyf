package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractService;
import com.zyf.springboot.entity.sys.RoleResource;
import com.zyf.springboot.vo.sys.ResourceVo;

import java.util.List;

public interface RoleResourceService extends AbstractService<RoleResource> {

    List<ResourceVo> selectResourceVoList(Integer roleId);

    boolean deleteRoleResourceByRoleId(Integer roleId);

    Msg updateRoleResource(List<RoleResource> roleResources);
}

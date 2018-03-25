package com.zyf.springboot.service.sys.impl;

import com.google.common.collect.Lists;
import com.zyf.springboot.base.mvc.AbstractServiceImpl;
import com.zyf.springboot.entity.sys.RoleResource;
import com.zyf.springboot.mapper.sys.RoleResourceMapper;
import com.zyf.springboot.service.sys.ResourceService;
import com.zyf.springboot.service.sys.RoleResourceService;
import com.zyf.springboot.vo.sys.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleResourceServiceImpl extends AbstractServiceImpl<RoleResourceMapper, RoleResource, Integer> implements RoleResourceService {

    @Autowired
    private ResourceService resourceService;

    @Override
    public List<ResourceVo> selectResourceVoList(Integer roleId) {
        List<RoleResource> userRoles = baseMapper.selectList(getWrapper(new RoleResource(roleId)));
        List<Integer> roleIds = userRoles.stream().map(RoleResource::getRoleId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(roleIds)) {
            return resourceService.selectVoBatchIds(roleIds);
        }
        return Lists.newArrayList();
    }

    @Override
    public boolean deleteRoleResourceByRoleId(Integer roleId) {
        Integer effect = baseMapper.delete(getWrapper(new RoleResource(roleId)));
        return effect > 0;
    }
}

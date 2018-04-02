package com.zyf.springboot.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.Lists;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceImpl;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.entity.sys.RoleResource;
import com.zyf.springboot.mapper.sys.ResourceMapper;
import com.zyf.springboot.mapper.sys.RoleResourceMapper;
import com.zyf.springboot.service.sys.ResourceService;
import com.zyf.springboot.service.sys.RoleResourceService;
import com.zyf.springboot.vo.sys.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleResourceServiceImpl extends AbstractServiceImpl<RoleResourceMapper, RoleResource, Integer> implements RoleResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceService resourceService;

    @Override
    public List<ResourceVo> selectResourceVoList(Integer roleId) {
        Wrapper<ResourceVo> wrapper = new EntityWrapper<>();
        List<RoleResource> userRoles = this.baseMapper.selectList(getWrapper(new RoleResource(roleId)));
        List<Object> resourceIds = CollUtil.getFieldValues(userRoles, "resourceId");
        if (CollUtil.isNotEmpty(resourceIds)) {
            wrapper.setSqlSelect("id")
                    .in("id", resourceIds)
                    .orderDesc(Collections.singleton("parent_id"));
            return this.resourceService.selectVoList(wrapper);
        }
        return Lists.newArrayList();
    }

    @Override
    public boolean deleteRoleResourceByRoleId(Integer roleId) {
        return this.baseMapper.delete(getWrapper(new RoleResource(roleId))) > 0;
    }

    @Override
    public Msg updateRoleResource(List<RoleResource> roleResources) {
        String ok = "更新用户权限成功！";
        String error = "更新用户权限失败！";
        if (CollUtil.isNotEmpty(roleResources)) {
            Integer roleId = roleResources.get(0).getRoleId();

            Set<RoleResource> newRoleResources = CollUtil.newHashSet(roleResources);
            for (RoleResource roleResource : roleResources) {
                Integer resourceId = roleResource.getResourceId();
                /*
                 * 获取所有上级，勾选所有上级，使用 set + equals 排除重复值
                 */
                List<Resource> temp = this.resourceMapper.selectAllParent(resourceId);
                for (Resource resource : temp) {
                    newRoleResources.add(new RoleResource(roleId, resource.getId()));
                }
            }
            /*
             * 先删除角色所有权限，再新增角色权限
             */
            this.deleteRoleResourceByRoleId(roleId);
            if (this.insertOrUpdateBatch(CollUtil.newArrayList(newRoleResources))) {
                this.log.info(ok);
                return Msg.ok(ok);
            } else {
                this.log.error(error);
                return Msg.error(error);
            }
        }
        this.log.error(error);
        return Msg.error(error);
    }
}

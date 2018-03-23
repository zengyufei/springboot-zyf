package com.zyf.springboot.service.sys.impl;

import com.google.common.collect.Lists;
import com.zyf.springboot.base.mvc.AbstractServiceImpl;
import com.zyf.springboot.entity.sys.UserRole;
import com.zyf.springboot.mapper.sys.UserRoleMapper;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.service.sys.UserRoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl extends AbstractServiceImpl<UserRoleMapper, UserRole, Integer> implements UserRoleService {

    @Autowired
    private RoleService roleService;

    @Override
    public List<RoleVo> selectRoleVoList(Integer userId) {
        List<UserRole> userRoles = baseMapper.selectList(getWrapper(new UserRole(userId)));
        List<Integer> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(roleIds)) {
            return roleService.selectVoBatchIds(roleIds);
        }
        return Lists.newArrayList();
    }

    @Override
    public boolean deleteUserRoleByUserId(Integer userId) {
        Integer effect = baseMapper.delete(getWrapper(new UserRole(userId)));
        return effect > 0;
    }


}

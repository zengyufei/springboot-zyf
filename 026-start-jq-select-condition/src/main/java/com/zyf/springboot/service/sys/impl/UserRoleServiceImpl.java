package com.zyf.springboot.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.zyf.springboot.base.mvc.AbstractServiceImpl;
import com.zyf.springboot.entity.sys.UserRole;
import com.zyf.springboot.mapper.sys.UserRoleMapper;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.service.sys.UserRoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserRoleServiceImpl extends AbstractServiceImpl<UserRoleMapper, UserRole, Integer> implements UserRoleService {

    @Autowired
    private RoleService roleService;

    @Override
    public void selectRoleVoList(List<UserVo> userVos) {
        if (CollUtil.isEmpty(userVos)) {
            return;
        }
        List<Object> userIds = CollUtil.getFieldValues(userVos, "id");
        Wrapper wrapper = Condition.create().in("user_id", userIds);
        List<UserRole> userRoles = this.baseMapper.selectList(wrapper);
        if (CollUtil.isEmpty(userRoles)) {
            return;
        }

        List<Integer> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        roleIds = CollUtil.distinct(roleIds); //去重
        List<RoleVo> roleVos = this.roleService.selectVoBatchIds(roleIds);
        if (CollUtil.isEmpty(roleVos)) {
            return;
        }
        Multimap<Integer, UserRole> userRoleMap = ArrayListMultimap.create();
        userRoles.forEach(item -> {
            Integer userId = item.getUserId();
            userRoleMap.put(userId, item);
        });
        Map<Object, RoleVo> roleVoMap = IterUtil.fieldValueMap(roleVos, "id");

        for (UserVo userVo : userVos) {
            Integer userId = userVo.getId();
            List<RoleVo> currentRoleVos = CollUtil.newArrayList();
            if (userRoleMap.containsKey(userId)) {
                for (UserRole currentUserRole : userRoleMap.get(userId)) {
                    Integer roleId = currentUserRole.getRoleId();
                    if (roleVoMap.containsKey(roleId)) {
                        RoleVo roleVo = roleVoMap.get(roleId);
                        currentRoleVos.add(roleVo);
                    }
                }
            }
            userVo.setRoleVos(currentRoleVos);
        }
    }

    @Override
    public List<RoleVo> selectRoleVoList(Integer userId) {
        List<UserRole> userRoles = this.baseMapper.selectList(getWrapper(new UserRole(userId)));
        List<Integer> roleIds = userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(roleIds)) {
            return this.roleService.selectVoBatchIds(roleIds);
        }
        return Lists.newArrayList();
    }

    @Override
    public boolean deleteUserRoleByUserId(Integer userId) {
        Integer effect = this.baseMapper.delete(getWrapper(new UserRole(userId)));
        return effect > 0;
    }


}

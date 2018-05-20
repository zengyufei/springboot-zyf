package com.zyf.springboot.service.sys.impl.middle;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.zyf.springboot.base.mvc.AbstractMiddleServiceImpl;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.entity.sys.middle.UserGroupRole;
import com.zyf.springboot.mapper.sys.RoleMapper;
import com.zyf.springboot.mapper.sys.UserGroupMapper;
import com.zyf.springboot.mapper.sys.middle.UserGroupRoleMapper;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.service.sys.middle.UserGroupRoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import com.zyf.springboot.vo.sys.UserGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserGroupRoleServiceImpl extends AbstractMiddleServiceImpl<
        UserGroupRoleMapper, UserGroupRole,
        UserGroupMapper, UserGroup,
        RoleMapper, Role,
        Integer> implements UserGroupRoleService {

    @Autowired
    private RoleService roleService;

    @Override
    public void setRoleVoList(List<UserGroupVo> userGroupVos) {
        if (CollUtil.isEmpty(userGroupVos)) {
            return;
        }
        List<Object> userGroupIds = CollUtil.getFieldValues(userGroupVos, "id");
        Wrapper wrapper = Condition.create().in("user_group_id", userGroupIds);
        List<UserGroupRole> userGroupRoles = this.baseMapper.selectList(wrapper);
        if (CollUtil.isEmpty(userGroupRoles)) {
            return;
        }

        List<Integer> roleIds = userGroupRoles.stream().map(UserGroupRole::getRoleId).collect(Collectors.toList());
        roleIds = CollUtil.distinct(roleIds); //去重
        List<RoleVo> roleVos = this.roleService.selectVoBatchIds(roleIds);
        if (CollUtil.isEmpty(roleVos)) {
            return;
        }
        Multimap<Integer, UserGroupRole> userGroupRoleMap = ArrayListMultimap.create();
        userGroupRoles.forEach(item -> {
            Integer userGroupId = item.getUserGroupId();
            userGroupRoleMap.put(userGroupId, item);
        });
        Map<Object, RoleVo> roleVoMap = IterUtil.fieldValueMap(roleVos, "id");

        for (UserGroupVo userGroupVo : userGroupVos) {
            Integer userGroupId = userGroupVo.getId();
            List<RoleVo> currentRoleVos = CollUtil.newArrayList();
            if (userGroupRoleMap.containsKey(userGroupId)) {
                for (UserGroupRole currentUserGroupRole : userGroupRoleMap.get(userGroupId)) {
                    Integer roleId = currentUserGroupRole.getRoleId();
                    if (roleVoMap.containsKey(roleId)) {
                        RoleVo roleVo = roleVoMap.get(roleId);
                        currentRoleVos.add(roleVo);
                    }
                }
            }
            userGroupVo.setRoleVos(currentRoleVos);
        }
    }

}

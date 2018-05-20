package com.zyf.springboot.service.sys.impl.middle;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.zyf.springboot.base.mvc.AbstractMiddleServiceImpl;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.entity.sys.middle.UserRole;
import com.zyf.springboot.mapper.sys.RoleMapper;
import com.zyf.springboot.mapper.sys.UserMapper;
import com.zyf.springboot.mapper.sys.middle.UserRoleMapper;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.service.sys.middle.UserRoleService;
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
public class UserRoleServiceImpl extends AbstractMiddleServiceImpl<
        UserRoleMapper, UserRole,
        UserMapper, User,
        RoleMapper, Role,
        Integer> implements UserRoleService {

    @Autowired
    private RoleService roleService;

    @Override
    public void setRoleVoList(List<UserVo> userVos) {
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

}

package com.zyf.springboot.service.sys.impl.middle;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.zyf.springboot.base.mvc.AbstractMiddleServiceImpl;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.entity.sys.middle.UserGroupUser;
import com.zyf.springboot.mapper.sys.UserGroupMapper;
import com.zyf.springboot.mapper.sys.UserMapper;
import com.zyf.springboot.mapper.sys.middle.UserGroupUserMapper;
import com.zyf.springboot.service.sys.UserService;
import com.zyf.springboot.service.sys.middle.UserGroupUserService;
import com.zyf.springboot.vo.sys.UserGroupVo;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserGroupUserServiceImpl extends AbstractMiddleServiceImpl<
        UserGroupUserMapper, UserGroupUser,
        UserGroupMapper, UserGroup,
        UserMapper, User,
        Integer> implements UserGroupUserService {

    @Autowired
    private UserService userService;

    @Override
    public void setUserVoList(List<UserGroupVo> userGroupVos) {
        if (CollUtil.isEmpty(userGroupVos)) {
            return;
        }
        List<Object> userGroupIds = CollUtil.getFieldValues(userGroupVos, "id");
        Wrapper wrapper = Condition.create().in("user_group_id", userGroupIds);
        List<UserGroupUser> userGroupUsers = this.baseMapper.selectList(wrapper);
        if (CollUtil.isEmpty(userGroupUsers)) {
            return;
        }

        List<Integer> userIds = userGroupUsers.stream().map(UserGroupUser::getUserId).collect(Collectors.toList());
        userIds = CollUtil.distinct(userIds); //去重
        List<UserVo> userVos = this.userService.selectVoBatchIds(userIds);
        if (CollUtil.isEmpty(userVos)) {
            return;
        }
        Multimap<Integer, UserGroupUser> userGroupUserMap = ArrayListMultimap.create();
        userGroupUsers.forEach(item -> {
            Integer userGroupId = item.getUserGroupId();
            userGroupUserMap.put(userGroupId, item);
        });
        Map<Object, UserVo> userVoMap = IterUtil.fieldValueMap(userVos, "id");

        for (UserGroupVo userGroupVo : userGroupVos) {
            Integer userGroupId = userGroupVo.getId();
            List<UserVo> currentUserGroupVos = CollUtil.newArrayList();
            if (userGroupUserMap.containsKey(userGroupId)) {
                for (UserGroupUser currentUserGroupUser : userGroupUserMap.get(userGroupId)) {
                    Integer userId = currentUserGroupUser.getUserId();
                    if (userVoMap.containsKey(userId)) {
                        UserVo userVo = userVoMap.get(userId);
                        currentUserGroupVos.add(userVo);
                    }
                }
            }
            userGroupVo.setUserVos(currentUserGroupVos);
        }
    }

}

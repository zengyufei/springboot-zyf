package com.zyf.springboot.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.controller.sys.utils.UserGroupTreeUtils;
import com.zyf.springboot.entity.sys.UserGroup;
import com.zyf.springboot.entity.sys.middle.UserGroupUser;
import com.zyf.springboot.mapper.sys.UserGroupMapper;
import com.zyf.springboot.service.sys.UserGroupService;
import com.zyf.springboot.service.sys.middle.UserGroupUserService;
import com.zyf.springboot.vo.sys.UserGroupVo;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserGroupServiceImpl extends AbstractServiceVoImpl<UserGroupMapper, UserGroup, UserGroupVo, Integer> implements UserGroupService {

    @Autowired
    private UserGroupUserService userGroupUserService;

    @Override
    public Msg addUserGroup(UserGroupVo userGroupVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        if (this.insertVo(userGroupVo)) {
            final Integer userGroupId = userGroupVo.getId();
            if (!CollectionUtils.isEmpty(userGroupVo.getUserVos())) {
                List<UserGroupUser> userGroupUsers = userGroupVo.getUserVos().stream()
                        .map(item -> new UserGroupUser(userGroupId, item.getId()))
                        .collect(Collectors.toList());
                this.userGroupUserService.insertBatch(userGroupUsers);
            }
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateAllColumnUserGroup(UserGroupVo userGroupVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (this.updateVoAllColumnById(userGroupVo)) {
            Integer userGroupId = userGroupVo.getId();
            this.userGroupUserService.deleteMiddleByPrimaryId(userGroupId);
            List<UserVo> userVos = userGroupVo.getUserVos();
            if (CollUtil.isNotEmpty(userVos)) {
                List<UserGroupUser> userGroupUsers = userVos.stream()
                        .map(item -> new UserGroupUser(userGroupId, item.getId()))
                        .collect(Collectors.toList());
                this.userGroupUserService.insertBatch(userGroupUsers);
            }
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateUserGroup(UserGroupVo userGroupVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (this.updateVoById(userGroupVo)) {
            Integer userGroupId = userGroupVo.getId();
            this.userGroupUserService.deleteMiddleByPrimaryId(userGroupId);
            List<UserVo> userVos = userGroupVo.getUserVos();
            if (CollUtil.isNotEmpty(userVos)) {
                List<UserGroupUser> userGroupUsers = userVos.stream()
                        .map(item -> new UserGroupUser(userGroupId, item.getId()))
                        .collect(Collectors.toList());
                this.userGroupUserService.insertBatch(userGroupUsers);
            }
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg deleteUserGroup(Integer id) {
        String ok = "删除用户成功！";
        String error = "删除用户失败！";
        String userOk = "删除关联用户组成功！";
        String userError = "删除关联用户组失败！";
        if (this.deleteById(id)) {
            this.log.info(ok);
            if (this.userGroupUserService.deleteMiddleByPrimaryId(id)) {
                this.log.info(userOk);
                return Msg.ok(ok);
            } else {
                this.log.error(userError);
                return Msg.ok(userError);
            }
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg selectUserGroupPage(UserGroupVo userGroupVo) {
        Wrapper<UserGroup> wrapper = create(userGroupVo);

        Date createTimeLt = userGroupVo.getCreateTimeLt();
        Date createTimeGt = userGroupVo.getCreateTimeGt();

        if (ObjectUtil.isNotNull(createTimeLt)) {
            wrapper.le("create_time", DateUtil.endOfDay(createTimeLt));
        }
        if (ObjectUtil.isNotNull(createTimeGt)) {
            wrapper.ge("create_time", DateUtil.beginOfDay(createTimeGt));
        }

        Page<UserGroupVo> userGroupVoPage = this.selectVoPage(
                new Page<>(userGroupVo.getPageIndex(), userGroupVo.getPageSize()),
                wrapper
        );

        return Msg.ok(userGroupVoPage);
    }

    @Override
    public Msg tree() {
        List<UserGroup> userGroups = this.selectList(Condition.EMPTY);
        List<UserGroupTreeUtils.Tree> trees = UserGroupTreeUtils.toTree(userGroups);
        return Msg.ok(trees);
    }
}

package com.zyf.springboot.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.entity.sys.middle.UserRole;
import com.zyf.springboot.enums.SexType;
import com.zyf.springboot.enums.UserType;
import com.zyf.springboot.mapper.sys.UserMapper;
import com.zyf.springboot.service.sys.UserService;
import com.zyf.springboot.service.sys.middle.UserRoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractServiceVoImpl<UserMapper, User, UserVo, Integer> implements UserService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserVo login(String userName, String password) {
        Wrapper<User> wrapper = create(new User(userName, password));
        List<User> users = this.baseMapper.selectList(wrapper);
        if (CollUtil.isNotEmpty(users)) {
            return this.orikaMapper.convert(users.get(0), UserVo.class);
        }
        return null;
    }

    @Override
    public Msg addUser(UserVo userVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        userVo.setPassword("admin");
        if (this.insertVo(userVo)) {
            Integer userId = userVo.getId();
            List<RoleVo> roleVos = userVo.getRoleVos();
            List<Role> roles = this.orikaMapper.convertList(roleVos, Role.class);
            boolean insert = this.userRoleService.updateByPrimaryId(userId, roles);
            if (insert) {
                this.log.info(ok);
                return Msg.ok(ok);
            } else {
                this.log.error(error);
                return Msg.error(error);
            }
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateUserAllColumn(UserVo userVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (this.updateVoAllColumnById(userVo)) {
            Integer userId = userVo.getId();
            List<RoleVo> roleVos = userVo.getRoleVos();
            if (CollUtil.isNotEmpty(roleVos)) {
                List<Role> roles = this.orikaMapper.convertList(roleVos, Role.class);
                boolean insert = this.userRoleService.updateByPrimaryId(userId, roles);
                if (insert) {
                    this.log.info(ok);
                    return Msg.ok(ok);
                } else {
                    this.log.error(error);
                    return Msg.error(error);
                }
            } else {
                this.log.info(ok);
                return Msg.ok(ok);
            }
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateUser(UserVo userVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (this.updateVoById(userVo)) {
            Integer userId = userVo.getId();
            List<RoleVo> roleVos = userVo.getRoleVos();
            if (CollUtil.isNotEmpty(roleVos)) {
                List<Role> roles = this.orikaMapper.convertList(roleVos, Role.class);
                boolean insert = this.userRoleService.updateByPrimaryId(userId, roles);
                if (insert) {
                    this.log.info(ok);
                    return Msg.ok(ok);
                } else {
                    this.log.error(error);
                    return Msg.error(error);
                }
            } else {
                this.log.info(ok);
                return Msg.ok(ok);
            }
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg deleteUser(Integer id) {
        String ok = "删除用户成功！";
        String error = "删除用户失败！";
        String roleOk = "删除关联用户成功！";
        String roleError = "删除关联用户失败！";
        if (this.deleteById(id)) {
            this.log.info(ok);
            if (this.userRoleService.deleteMiddleByPrimaryId(id)) {
                this.log.info(roleOk);
                return Msg.ok(ok);
            } else {
                this.log.error(roleError);
                return Msg.ok(roleError);
            }
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg selectUserPage(UserVo userVo) {
        EntityWrapper<User> wrapper = create(userVo);

        Integer ageLt = userVo.getAgeLt();
        Integer ageGt = userVo.getAgeGt();
        Date createTimeLt = userVo.getCreateTimeLt();
        Date createTimeGt = userVo.getCreateTimeGt();
        List<Integer> roleIds = userVo.getRoleIds();
        List<Integer> enableList = userVo.getEnableList();
        List<SexType> sexList = userVo.getSexList();
        List<UserType> typeList = userVo.getTypeList();

        if (CollUtil.isNotEmpty(enableList)) {
            wrapper.in("enable", enableList);
        }
        if (CollUtil.isNotEmpty(sexList)) {
            wrapper.in("sex", sexList);
        }
        if (CollUtil.isNotEmpty(typeList)) {
            wrapper.in("type", typeList);
        }
        if (CollUtil.isNotEmpty(roleIds)) {
            Wrapper search = Condition.create().in("role_id", roleIds);
            List<UserRole> userRoleList = this.userRoleService.selectList(search);
            if (CollUtil.isNotEmpty(userRoleList)) {
                wrapper.in("id", CollUtil.getFieldValues(userRoleList, "userId"));
            }
        }
        if (Convert.toInt(ageLt, 0) > 0) {
            wrapper.lt("age", ageLt);
        }
        if (Convert.toInt(ageGt, 0) > 0) {
            wrapper.gt("age", ageGt);
        }
        if (ObjectUtil.isNotNull(createTimeLt)) {
            wrapper.le("create_time", DateUtil.endOfDay(createTimeLt));
        }
        if (ObjectUtil.isNotNull(createTimeGt)) {
            wrapper.ge("create_time", DateUtil.beginOfDay(createTimeGt));
        }

        Page<UserVo> userVoPage = this.selectVoPage(
                new Page<>(userVo.getPageIndex(), userVo.getPageSize()),
                wrapper
        );

        /* 关联 role */
        this.userRoleService.setRoleVoList(userVoPage.getRecords());
        return Msg.ok(userVoPage);
    }
}

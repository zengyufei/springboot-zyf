package com.zyf.springboot.service.sys.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.entity.sys.UserRole;
import com.zyf.springboot.mapper.sys.UserMapper;
import com.zyf.springboot.service.sys.UserRoleService;
import com.zyf.springboot.service.sys.UserService;
import com.zyf.springboot.vo.sys.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends AbstractServiceVoImpl<UserMapper, User, UserVo, Integer> implements UserService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserVo login(String userName, String password) {
        User search = new User();
        search.setUsername(userName);
        search.setPassword(password);
        List<User> users = this.baseMapper.selectList(new EntityWrapper<>(search));
        if (users != null && !users.isEmpty()) {
            User user = this.baseMapper.selectById(users.get(0).getId());
            if (user == null) {
                return null;
            }
            return this.orikaMapper.convert(user, UserVo.class);
        }
        return null;
    }

    @Override
    public Msg addUser(UserVo userVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        userVo.setPassword("admin");
        boolean effect = this.insertVo(userVo);
        if (effect) {
            Integer userId = userVo.getId();
            if (!CollectionUtils.isEmpty(userVo.getRoleVos())) {
                List<UserRole> userRoles = userVo.getRoleVos().stream()
                        .map(item -> new UserRole(userId, item.getId()))
                        .collect(Collectors.toList());
                this.userRoleService.insertBatch(userRoles);
            }
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateUser(UserVo userVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        boolean effect = this.updateVoById(userVo);
        if (effect) {
            Integer userId = userVo.getId();
            this.userRoleService.deleteUserRoleByUserId(userId);
            List<UserRole> userRoles = userVo.getRoleVos().stream()
                    .map(item -> new UserRole(userId, item.getId()))
                    .collect(Collectors.toList());
            this.userRoleService.insertBatch(userRoles);
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg deleteUser(Integer id) {
        String ok = "删除用户成功！";
        String error = "删除用户失败！";
        String roleOk = "删除关联角色成功！";
        String roleError = "删除关联角色失败！";
        boolean b = this.deleteById(id);
        if (b) {
            this.log.info(ok);
            boolean delSuccess = this.userRoleService.deleteUserRoleByUserId(id);
            if (delSuccess) {
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

}

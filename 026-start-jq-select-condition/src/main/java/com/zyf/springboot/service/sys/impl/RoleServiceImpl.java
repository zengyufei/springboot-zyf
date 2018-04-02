package com.zyf.springboot.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.mapper.sys.RoleMapper;
import com.zyf.springboot.service.sys.RoleResourceService;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractServiceVoImpl<RoleMapper, Role, RoleVo, Integer> implements RoleService {

    @Autowired
    private RoleResourceService roleResourceService;

    @Override
    public Msg addRole(RoleVo roleVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        if (this.insertVo(roleVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateRole(RoleVo roleVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (this.updateVoById(roleVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg deleteRole(Integer id) {
        String ok = "删除角色成功！";
        String error = "删除角色失败！";
        String roleOk = "删除关联资源成功！";
        String roleError = "删除关联资源失败！";
        if (this.deleteById(id)) {
            this.log.info(ok);
            if (this.roleResourceService.deleteRoleResourceByRoleId(id)) {
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
    public Msg list(RoleVo roleVo) {
        Wrapper<RoleVo> wrapper = getWrapper(roleVo);

        Date createTimeLt = roleVo.getCreateTimeLt();
        Date createTimeGt = roleVo.getCreateTimeGt();
        List<Integer> enableList = roleVo.getEnableList();
        
        if (CollUtil.isNotEmpty(enableList)) {
            wrapper.in("enable", enableList);
        }
        if (ObjectUtil.isNotNull(createTimeLt)) {
            wrapper.le("create_time", DateUtil.endOfDay(createTimeLt));
        }
        if (ObjectUtil.isNotNull(createTimeGt)) {
            wrapper.ge("create_time", DateUtil.beginOfDay(createTimeGt));
        }

        Page<RoleVo> roleVoPage = this.selectVoPage(
                new Page<>(roleVo.getPageIndex(), roleVo.getPageSize()),
                wrapper
        );
        return Msg.ok(roleVoPage);
    }
}

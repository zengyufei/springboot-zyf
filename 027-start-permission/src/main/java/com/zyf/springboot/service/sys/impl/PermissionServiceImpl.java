package com.zyf.springboot.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.controller.sys.utils.PermissionTreeUtils;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.enums.LevelType;
import com.zyf.springboot.mapper.sys.PermissionMapper;
import com.zyf.springboot.service.sys.PermissionService;
import com.zyf.springboot.vo.sys.PermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl extends AbstractServiceVoImpl<PermissionMapper, Permission, PermissionVo, Integer> implements PermissionService {

    @Override
    public Msg addPermission(PermissionVo permissionVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        if (this.insertVo(permissionVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateAllColumnPermission(PermissionVo permissionVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (ObjectUtil.equal(permissionVo.getId(), permissionVo.getParentId())) {
            this.log.info(error + "不能关联自己成为父/子关系");
            return Msg.error(error + "不能关联自己成为父/子关系");
        }
        if (this.updateVoAllColumnById(permissionVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updatePermission(PermissionVo permissionVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (ObjectUtil.equal(permissionVo.getId(), permissionVo.getParentId())) {
            this.log.info(error + "不能关联自己成为父/子关系");
            return Msg.error(error + "不能关联自己成为父/子关系");
        }
        if (this.updateVoById(permissionVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg deletePermission(Integer id) {
        String ok = "删除权限成功！";
        String error = "删除权限失败！";
        if (this.deleteById(id)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg tree() {
        List<Permission> permissionVos = this.selectList(Condition.EMPTY);
        List<PermissionTreeUtils.Tree> menus = PermissionTreeUtils.toTree(permissionVos);
        return Msg.ok(menus);
    }

    @Override
    public Msg list(PermissionVo permissionVo) {
        Wrapper<Permission> wrapper = create(permissionVo);

        Date createTimeLt = permissionVo.getCreateTimeLt();
        Date createTimeGt = permissionVo.getCreateTimeGt();
        List<LevelType> levelList = permissionVo.getLevelList();

        if (CollUtil.isNotEmpty(levelList)) {
            wrapper.in("level", levelList);
        }
        if (ObjectUtil.isNotNull(createTimeLt)) {
            wrapper.le("create_time", DateUtil.endOfDay(createTimeLt));
        }
        if (ObjectUtil.isNotNull(createTimeGt)) {
            wrapper.ge("create_time", DateUtil.beginOfDay(createTimeGt));
        }

        Page<PermissionVo> permissionVoPage = this.selectVoPage(
                new Page<>(permissionVo.getPageIndex(), permissionVo.getPageSize()),
                wrapper
        );
        return Msg.ok(permissionVoPage);
    }
}

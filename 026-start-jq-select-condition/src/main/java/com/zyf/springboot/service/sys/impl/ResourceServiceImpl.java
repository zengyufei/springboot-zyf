package com.zyf.springboot.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.controller.sys.resource.MenuUtils;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.enums.LevelType;
import com.zyf.springboot.mapper.sys.ResourceMapper;
import com.zyf.springboot.service.sys.ResourceService;
import com.zyf.springboot.vo.sys.ResourceVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl extends AbstractServiceVoImpl<ResourceMapper, Resource, ResourceVo, Integer> implements ResourceService {

    @Override
    public Msg addResource(ResourceVo resourceVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        if (this.insertVo(resourceVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateResource(ResourceVo resourceVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (ObjectUtil.equal(resourceVo.getId(), resourceVo.getParentId())) {
            this.log.info(error + "不能关联自己成为父/子关系");
            return Msg.error(error + "不能关联自己成为父/子关系");
        }
        if (this.updateVoById(resourceVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg deleteResource(Integer id) {
        String ok = "删除资源成功！";
        String error = "删除资源失败！";
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
        List<Resource> resourceVos = this.selectList(Condition.EMPTY);
        List<MenuUtils.Menu> menus = MenuUtils.toTree(resourceVos);
        return Msg.ok(menus);
    }

    @Override
    public Msg list(ResourceVo resourceVo) {
        Wrapper<ResourceVo> wrapper = getWrapper(resourceVo);

        Date createTimeLt = resourceVo.getCreateTimeLt();
        Date createTimeGt = resourceVo.getCreateTimeGt();
        List<Integer> enableList = resourceVo.getEnableList();
        List<LevelType> levelList = resourceVo.getLevelList();

        if (CollUtil.isNotEmpty(levelList)) {
            wrapper.in("level", levelList);
        }
        if (CollUtil.isNotEmpty(enableList)) {
            wrapper.in("enable", enableList);
        }
        if (ObjectUtil.isNotNull(createTimeLt)) {
            wrapper.le("create_time", DateUtil.endOfDay(createTimeLt));
        }
        if (ObjectUtil.isNotNull(createTimeGt)) {
            wrapper.ge("create_time", DateUtil.beginOfDay(createTimeGt));
        }

        Page<ResourceVo> resourceVoPage = this.selectVoPage(
                new Page<>(resourceVo.getPageIndex(), resourceVo.getPageSize()),
                wrapper
        );
        return Msg.ok(resourceVoPage);
    }
}

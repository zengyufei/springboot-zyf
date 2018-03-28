package com.zyf.springboot.service.sys.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.controller.sys.resource.MenuUtils;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.mapper.sys.ResourceMapper;
import com.zyf.springboot.service.sys.ResourceService;
import com.zyf.springboot.vo.sys.ResourceVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl extends AbstractServiceVoImpl<ResourceMapper, Resource, ResourceVo, Integer> implements ResourceService {

    @Override
    public Msg addResource(ResourceVo resourceVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        boolean effect = this.insertVo(resourceVo);
        if (effect) {
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
        if (resourceVo.getId().equals(resourceVo.getParentId())) {
            this.log.info(error + "不能关联自己成为父/子关系");
            return Msg.error(error + "不能关联自己成为父/子关系");
        }
        boolean effect = this.updateVoById(resourceVo);
        if (effect) {
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
        boolean b = this.deleteById(id);
        if (b) {
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

}

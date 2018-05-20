package com.zyf.springboot.service.sys.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.controller.sys.utils.MenuUtils;
import com.zyf.springboot.entity.sys.Operation;
import com.zyf.springboot.enums.LevelType;
import com.zyf.springboot.mapper.sys.OperationMapper;
import com.zyf.springboot.service.sys.OperationService;
import com.zyf.springboot.vo.sys.OperationVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OperationServiceImpl extends AbstractServiceVoImpl<OperationMapper, Operation, OperationVo, Integer> implements OperationService {

    @Override
    public Msg addOperation(OperationVo operationVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        if (this.insertVo(operationVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateOperation(OperationVo operationVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (ObjectUtil.equal(operationVo.getId(), operationVo.getParentId())) {
            this.log.info(error + "不能关联自己成为父/子关系");
            return Msg.error(error + "不能关联自己成为父/子关系");
        }
        if (this.updateVoById(operationVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateAllColumnOperation(OperationVo operationVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        if (ObjectUtil.equal(operationVo.getId(), operationVo.getParentId())) {
            this.log.info(error + "不能关联自己成为父/子关系");
            return Msg.error(error + "不能关联自己成为父/子关系");
        }
        if (this.updateVoAllColumnById(operationVo)) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg deleteOperation(Integer id) {
        String ok = "删除操作成功！";
        String error = "删除操作失败！";
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
        List<Operation> operationVos = this.selectList(Condition.EMPTY);
        List<MenuUtils.Menu> menus = MenuUtils.toTree(operationVos);
        return Msg.ok(menus);
    }

    @Override
    public Msg list(OperationVo operationVo) {
        EntityWrapper<Operation> wrapper = create(operationVo);

        Date createTimeLt = operationVo.getCreateTimeLt();
        Date createTimeGt = operationVo.getCreateTimeGt();
        List<LevelType> levelList = operationVo.getLevelList();

        if (CollUtil.isNotEmpty(levelList)) {
            wrapper.in("level", levelList);
        }
        if (ObjectUtil.isNotNull(createTimeLt)) {
            wrapper.le("create_time", DateUtil.endOfDay(createTimeLt));
        }
        if (ObjectUtil.isNotNull(createTimeGt)) {
            wrapper.ge("create_time", DateUtil.beginOfDay(createTimeGt));
        }

        Page<OperationVo> operationVoPage = this.selectVoPage(
                new Page<>(operationVo.getPageIndex(), operationVo.getPageSize()),
                wrapper
        );
        return Msg.ok(operationVoPage);
    }
}

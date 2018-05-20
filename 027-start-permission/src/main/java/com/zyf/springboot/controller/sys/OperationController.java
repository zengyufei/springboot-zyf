package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Operation;
import com.zyf.springboot.service.sys.OperationService;
import com.zyf.springboot.vo.sys.OperationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 操作控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
@RequestMapping("operation")
public class OperationController extends AbstractControllerVo<Operation, OperationVo> {

    @Autowired
    private OperationService operationService;

    /**
     * 条件查询单个
     */
    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        OperationVo operationVo = this.service.selectVoById(id);
        return Msg.ok(operationVo);
    }

    /**
     * 分页条件查询集合
     */
    @PostMapping("list")
    public Msg list(@RequestBody OperationVo operationVo) {
        operationVo = Optional.ofNullable(operationVo).orElse(new OperationVo());
        return this.operationService.list(operationVo);
    }

    @GetMapping("all/{level}")
    public Msg leveAll(@PathVariable("level") Integer level) {
        Wrapper wrapper = Condition.create().eq("level", level);
        List<OperationVo> leveAll = this.service.selectVoList(wrapper);
        return Msg.ok(leveAll);
    }

    @GetMapping("tree")
    public Msg tree(OperationVo operationVo) {
        return this.operationService.tree();
    }

    /**
     * 新增
     */
    @PostMapping
    public Msg add(@RequestBody OperationVo operationVo) {
        operationVo = Optional.ofNullable(operationVo).orElse(new OperationVo());
        return this.operationService.addOperation(operationVo);
    }

    /**
     * 全量修改
     */
    @PutMapping
    public Msg updateAllColumn(@RequestBody OperationVo operationVo) {
        operationVo = Optional.ofNullable(operationVo).orElse(new OperationVo());
        return this.operationService.updateAllColumnOperation(operationVo);
    }

    /**
     * 局部修改
     */
    @PatchMapping
    public Msg update(@RequestBody OperationVo operationVo) {
        operationVo = Optional.ofNullable(operationVo).orElse(new OperationVo());
        return this.operationService.updateOperation(operationVo);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        return this.operationService.deleteOperation(id);
    }

}

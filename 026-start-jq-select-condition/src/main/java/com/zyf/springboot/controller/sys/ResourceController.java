package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.mapper.Condition;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.service.sys.ResourceService;
import com.zyf.springboot.vo.sys.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
@RequestMapping("resource")
public class ResourceController extends AbstractControllerVo<Resource, ResourceVo> {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        ResourceVo resourceVo = this.service.selectVoById(id);
        return Msg.ok(resourceVo);
    }

    @PostMapping("list")
    public Msg list(@RequestBody ResourceVo resourceVo) {
        return this.resourceService.list(resourceVo);
    }

    @GetMapping("all/{level}")
    public Msg leveAll(@PathVariable("level") Integer level) {
        List<ResourceVo> leveAll = this.service.selectVoList(Condition.create().eq("level", level));
        return Msg.ok(leveAll);
    }

    @GetMapping("tree")
    public Msg tree(ResourceVo resourceVo) {
        return this.resourceService.tree();
    }

    @PostMapping
    public Msg add(@RequestBody ResourceVo resourceVo) {
        return this.resourceService.addResource(resourceVo);
    }

    @PutMapping
    public Msg update(@RequestBody ResourceVo resourceVo) {
        return this.resourceService.updateResource(resourceVo);
    }

    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        return this.resourceService.deleteResource(id);
    }

}

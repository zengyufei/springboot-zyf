package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.vo.sys.ResourceVo;
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

    @GetMapping("{id}")
    public ResourceVo getVo(@PathVariable("id") Integer id) {
        return this.service.selectVoById(id);
    }

    @GetMapping
    public Msg list(ResourceVo roleVo) {
        List<ResourceVo> userVos = this.service.selectVoList(getWrapper(roleVo));
        Page<ResourceVo> resourceVoPage = new Page<ResourceVo>(roleVo.getPageIndex(), roleVo.getPageSize())
                .setRecords(userVos);
        return Msg.ok(resourceVoPage);
    }

    @PostMapping
    public boolean add(@RequestBody ResourceVo roleVo) {
        this.log.info("开始新增！");
        boolean effect = this.service.insertVo(roleVo);
        if (effect) {
            this.log.info("新增成功！");
        } else {
            this.log.info("新增失败！");
        }
        return effect;
    }

    @PutMapping
    public boolean update(@RequestBody ResourceVo roleVo) {
        this.log.info("开始修改！");
        boolean effect = this.service.updateVoById(roleVo);
        if (effect) {
            this.log.info("修改成功！");
        } else {
            this.log.info("修改失败！");
        }
        return effect;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return this.service.deleteById(id);
    }

}

package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.plugins.Page;
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
        return service.selectVoById(id);
    }

    @GetMapping
    public Page<ResourceVo> list(ResourceVo roleVo) {
        List<ResourceVo> userVos = service.selectVoList(getWrapper(roleVo));
        return new Page<ResourceVo>(roleVo.getPageIndex(), roleVo.getPageSize())
                .setRecords(userVos);
    }

    @PostMapping
    public boolean add(@RequestBody ResourceVo roleVo) {
        log.info("开始新增！");
        boolean effect = service.insertVo(roleVo);
        if (effect) {
            log.info("新增成功！");
        } else {
            log.info("新增失败！");
        }
        return effect;
    }

    @PutMapping
    public boolean update(@RequestBody ResourceVo roleVo) {
        log.info("开始修改！");
        boolean effect = service.updateVoById(roleVo);
        if (effect) {
            log.info("修改成功！");
        } else {
            log.info("修改失败！");
        }
        return effect;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }

}

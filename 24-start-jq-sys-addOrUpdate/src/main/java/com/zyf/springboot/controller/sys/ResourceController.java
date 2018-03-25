package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Resource;
import com.zyf.springboot.vo.sys.ResourceVo;
import org.springframework.web.bind.annotation.*;

/**
 * 资源控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
@RequestMapping("resource")
public class ResourceController extends AbstractControllerVo<Resource, ResourceVo> {

    @GetMapping("{id}")
    public Msg getVo(@PathVariable("id") Integer id) {
        ResourceVo resourceVo = this.service.selectVoById(id);
        return Msg.ok(resourceVo);
    }

    @GetMapping
    public Msg list(ResourceVo roleVo) {
        Page<ResourceVo> resourceVoPage = this.service.selectVoPage(
                new Page<>(roleVo.getPageIndex(), roleVo.getPageSize()),
                getWrapper(roleVo)
        );
        return Msg.ok(resourceVoPage);
    }

    @PostMapping
    public Msg add(@RequestBody ResourceVo roleVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        boolean effect = this.service.insertVo(roleVo);
        if (effect) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @PutMapping
    public Msg update(@RequestBody ResourceVo roleVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        boolean effect = this.service.updateVoById(roleVo);
        if (effect) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.info(error);
            return Msg.error(error);
        }
    }

    @DeleteMapping("{id}")
    public Msg delete(@PathVariable("id") Integer id) {
        String ok = "删除资源成功！";
        String error = "删除资源失败！";
        boolean b = this.service.deleteById(id);
        if (b) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

}

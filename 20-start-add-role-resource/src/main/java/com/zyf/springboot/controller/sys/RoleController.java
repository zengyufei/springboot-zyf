package com.zyf.springboot.controller.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyf.springboot.base.mvc.AbstractControllerVo;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.service.sys.RoleResourceService;
import com.zyf.springboot.vo.sys.ResourceVo;
import com.zyf.springboot.vo.sys.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制层
 * @author zengyufei
 * @since 1.0.0
 */
@RestController
@RequestMapping("role")
public class RoleController extends AbstractControllerVo<Role, RoleVo> {

    @Autowired
    private RoleResourceService roleResourceService;

    @GetMapping("{id}")
    public RoleVo getVo(@PathVariable("id") Integer id) {
        RoleVo roleVo = service.selectVoById(id);

        /* 关联资源信息 */
        List<ResourceVo> resourceVos = roleResourceService.selectResourceVoList(roleVo.getId());
        roleVo.setResourceVos(resourceVos);
        return roleVo;
    }

    @GetMapping
    public Page<RoleVo> list(RoleVo roleVo) {
        List<RoleVo> userVos = service.selectVoList(getWrapper(roleVo));
        return new Page<RoleVo>(roleVo.getPageIndex(), roleVo.getPageSize())
                .setRecords(userVos);
    }

    @PostMapping
    public boolean add(@RequestBody RoleVo roleVo) {
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
    public boolean update(@RequestBody RoleVo roleVo) {
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

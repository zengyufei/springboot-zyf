package com.zyf.springboot.service.sys.impl;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVoImpl;
import com.zyf.springboot.entity.sys.Role;
import com.zyf.springboot.mapper.sys.RoleMapper;
import com.zyf.springboot.service.sys.RoleResourceService;
import com.zyf.springboot.service.sys.RoleService;
import com.zyf.springboot.vo.sys.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends AbstractServiceVoImpl<RoleMapper, Role, RoleVo, Integer> implements RoleService {

    @Autowired
    private RoleResourceService roleResourceService;

    @Override
    public Msg addRole(RoleVo roleVo) {
        this.log.info("开始新增！");
        String ok = "新增成功！";
        String error = "新增失败！";
        boolean effect = this.insertVo(roleVo);
        if (effect) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg updateRole(RoleVo roleVo) {
        this.log.info("开始修改！");
        String ok = "修改成功！";
        String error = "修改失败！";
        boolean effect = this.updateVoById(roleVo);
        if (effect) {
            this.log.info(ok);
            return Msg.ok(ok);
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }

    @Override
    public Msg deleteRole(Integer id) {
        String ok = "删除角色成功！";
        String error = "删除角色失败！";
        String roleOk = "删除关联资源成功！";
        String roleError = "删除关联资源失败！";
        boolean b = this.deleteById(id);
        if (b) {
            this.log.info(ok);
            boolean delSuccess = this.roleResourceService.deleteRoleResourceByRoleId(id);
            if (delSuccess) {
                this.log.info(roleOk);
                return Msg.ok(ok);
            } else {
                this.log.error(roleError);
                return Msg.ok(roleError);
            }
        } else {
            this.log.error(error);
            return Msg.error(error);
        }
    }


}

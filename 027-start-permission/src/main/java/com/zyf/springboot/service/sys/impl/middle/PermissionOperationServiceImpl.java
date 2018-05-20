package com.zyf.springboot.service.sys.impl.middle;

import cn.hutool.core.collection.CollUtil;
import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractMiddleServiceImpl;
import com.zyf.springboot.entity.sys.Operation;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.entity.sys.middle.PermissionOperation;
import com.zyf.springboot.mapper.sys.OperationMapper;
import com.zyf.springboot.mapper.sys.PermissionMapper;
import com.zyf.springboot.mapper.sys.middle.PermissionOperationMapper;
import com.zyf.springboot.service.sys.middle.PermissionOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionOperationServiceImpl extends AbstractMiddleServiceImpl<
        PermissionOperationMapper, PermissionOperation,
        PermissionMapper, Permission,
        OperationMapper, Operation,
        Integer> implements PermissionOperationService {

    @Autowired
    private OperationMapper operationMapper;

    @Override
    public Msg updatePermissionOperation(List<PermissionOperation> permissionOperations) {
        String ok = "更新用户操作成功！";
        String error = "更新用户操作失败！";
        if (CollUtil.isNotEmpty(permissionOperations)) {
            Integer permissionId = permissionOperations.get(0).getPermissionId();

            Set<PermissionOperation> newPermissionOperations = CollUtil.newHashSet(permissionOperations);
            for (PermissionOperation permissionOperation : permissionOperations) {
                Integer operationId = permissionOperation.getPermissionId();
                /*
                 * 获取所有上级，勾选所有上级，使用 set + equals 排除重复值
                 */
                List<Operation> parents = this.operationMapper.selectAllParent(operationId);
                for (Operation parent : parents) {
                    newPermissionOperations.add(new PermissionOperation(permissionId, parent.getId()));
                }
            }
            /*
             * 先删除角色所有操作，再新增角色操作
             */
            this.deleteMiddleByPrimaryId(permissionId);
            if (this.insertOrUpdateBatch(CollUtil.newArrayList(newPermissionOperations))) {
                this.log.info(ok);
                return Msg.ok(ok);
            } else {
                this.log.error(error);
                return Msg.error(error);
            }
        }
        this.log.error(error);
        return Msg.error(error);
    }
}

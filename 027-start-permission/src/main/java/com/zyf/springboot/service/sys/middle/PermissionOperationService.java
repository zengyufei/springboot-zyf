package com.zyf.springboot.service.sys.middle;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractMiddleService;
import com.zyf.springboot.entity.sys.Operation;
import com.zyf.springboot.entity.sys.Permission;
import com.zyf.springboot.entity.sys.middle.PermissionOperation;

import java.util.List;

public interface PermissionOperationService extends AbstractMiddleService<PermissionOperation, Permission, Operation> {

    Msg updatePermissionOperation(List<PermissionOperation> permissionOperation);
    
}

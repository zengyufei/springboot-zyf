package com.zyf.springboot.service.sys;

import com.zyf.springboot.base.Msg;
import com.zyf.springboot.base.mvc.AbstractServiceVo;
import com.zyf.springboot.entity.sys.Operation;
import com.zyf.springboot.vo.sys.OperationVo;

public interface OperationService extends AbstractServiceVo<Operation, OperationVo> {

    Msg addOperation(OperationVo operationVo);

    Msg updateAllColumnOperation(OperationVo operationVo);

    Msg updateOperation(OperationVo operationVo);

    Msg deleteOperation(Integer id);

    Msg tree();

    Msg list(OperationVo operationVo);
}

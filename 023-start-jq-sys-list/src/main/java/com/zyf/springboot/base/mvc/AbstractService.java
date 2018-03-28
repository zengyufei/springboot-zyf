package com.zyf.springboot.base.mvc;

import com.baomidou.mybatisplus.service.IService;
import com.zyf.springboot.base.PO;

/**
 * AbstractServiceVo 层 基础接口，其他Service 接口 请继承该接口
 */
public interface AbstractService<
        T extends PO>
        extends IService<T> {

}
package com.zyf.springboot.base.mvc;

import com.baomidou.mybatisplus.service.IService;
import com.zyf.springboot.base.PO;

import java.io.Serializable;
import java.util.List;

/**
 * AbstractServiceVo 层 基础接口，其他Service 接口 请继承该接口
 * D : Middle 中间表对象
 * P : Primary-主 关联对象 主表对象
 * F : From-从 关联对象 从表对象
 */
public interface AbstractMiddleService<
        T extends PO, P extends PO, F extends PO>
        extends IService<T> {

    List<F> selectFromListByPrimaryId(Serializable primaryId);

    List<F> selectFromListByPrimaryIds(List<Serializable> ids);

    boolean updateByPrimaryId(Serializable primaryId, List<F> froms);

    boolean deleteMiddleByPrimaryId(Serializable primaryId);

    boolean deleteMiddleByFromId(Serializable fromId);

}
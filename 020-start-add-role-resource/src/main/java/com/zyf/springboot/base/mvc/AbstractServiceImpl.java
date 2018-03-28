package com.zyf.springboot.base.mvc;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.base.orika.OrikaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * @author qixiaobo
 */
public abstract class AbstractServiceImpl<M extends BaseMapper<T>,
        T extends PO<T, PK>,
        PK extends Serializable>
        extends ServiceImpl<M, T> implements AbstractService<T> {

    protected Class<T> poClazz;
    protected Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected OrikaMapper orikaMapper;

    public AbstractServiceImpl() {
        TypeToken<T> poType = new TypeToken<T>(getClass()) {
        };
        poClazz = (Class<T>) poType.getRawType();
    }

    protected EntityWrapper<T> getWrapper() {
        return new EntityWrapper<>();
    }

    protected EntityWrapper<T> getWrapper(T t) {
        return new EntityWrapper<>(t);
    }

}

package com.zyf.springboot.base.mvc;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.BaseEntity;
import com.zyf.springboot.base.BaseVoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AbstractControllerVo<T extends BaseEntity, V extends BaseVoEntity, PK extends Serializable> {

    protected Class<V> voClazz;
    @Autowired
    protected AbstractServiceVo<T, V, PK> service;

    protected Logger log = LoggerFactory.getLogger(getClass());

    public AbstractControllerVo() {
        TypeToken<V> voType = new TypeToken<V>(getClass()) {
        };
        voClazz = (Class<V>) voType.getRawType();
    }

    protected EntityWrapper<V> getWrapper() {
        return new EntityWrapper<>();
    }

    protected EntityWrapper<V> getWrapper(V v) {
        return new EntityWrapper<>();
    }

}

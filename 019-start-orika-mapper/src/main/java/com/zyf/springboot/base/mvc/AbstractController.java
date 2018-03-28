package com.zyf.springboot.base.mvc;

import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AbstractController<T extends BaseEntity, PK extends Serializable> {

    protected Class<T> poClazz;
    @Autowired
    protected AbstractService<T, PK> service;

    protected Logger log = LoggerFactory.getLogger(getClass());

    public AbstractController() {
        TypeToken<T> voType = new TypeToken<T>(getClass()) {
        };
        poClazz = (Class<T>) voType.getRawType();
    }

}

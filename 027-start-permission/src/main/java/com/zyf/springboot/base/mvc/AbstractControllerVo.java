package com.zyf.springboot.base.mvc;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.base.VO;
import com.zyf.springboot.base.orika.OrikaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractControllerVo<T extends PO, V extends VO> {

    protected Class<V> voClazz;
    @Autowired
    protected AbstractServiceVo<T, V> service;
    @Autowired
    protected OrikaMapper orikaMapper;

    protected Logger log = LoggerFactory.getLogger(getClass());

    public AbstractControllerVo() {
        TypeToken<V> voType = new TypeToken<V>(getClass()) {
        };
        this.voClazz = (Class<V>) voType.getRawType();
    }

    protected EntityWrapper<V> getWrapper() {
        return new EntityWrapper<>();
    }

    protected EntityWrapper<V> getWrapper(V v) {
        return new EntityWrapper<>(v);
    }

}

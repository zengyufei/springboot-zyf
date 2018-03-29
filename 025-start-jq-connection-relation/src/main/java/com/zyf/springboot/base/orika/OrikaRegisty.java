package com.zyf.springboot.base.orika;

import ma.glasnost.orika.MapperFactory;

/**
 * 当出现字段名称不相同时，可以使用该类注册
 */
public interface OrikaRegisty {
    /**
     * @param factory
     */
    void register(MapperFactory factory);
}
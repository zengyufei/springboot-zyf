package com.zyf.springboot.base.orika;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrikaMapper {
    private MapperFacade mapperFacade = null;

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    @Autowired(required = false)
    private List<OrikaRegisty> orikaRegistyList = Lists.newArrayList();

    /**
     * 初始化Orika注册
     */
    @PostConstruct
    public void init() {
        if (!orikaRegistyList.isEmpty()) {
            for (OrikaRegisty orikaRegisty : orikaRegistyList) {
                orikaRegisty.register(mapperFactory);
            }
        }
        mapperFacade = mapperFactory.getMapperFacade();
    }


    public <T, V> V convert(T base, Class<V> target) {
        return mapperFacade.map(base, target);
    }

    public void convert(Object base, Object target) {
        mapperFacade.map(base, target);
    }

    public <T, V> List<V> convertList(List<T> baseList, Class<V> target) {
        return baseList.isEmpty() ? Collections.<V>emptyList() : mapperFacade.mapAsList(baseList, target);
    }

    public <S> Map<String, Object> convertMap(S source) {
        String temp = JSONObject.toJSONString(source);
        return JSONObject.parseObject(temp);
    }

    public <T, V> Page<V> convertPage(List<T> baseList, Class<V> target) {
        List<V> list = baseList.isEmpty() ? Collections.<V>emptyList() : mapperFacade.mapAsList(baseList, target);
        Page page = new Page();
        page.setRecords(list);
        page.setTotal(list.size());
        return page;
    }

    public MapperFacade getMapperFacade() {
        return mapperFacade;
    }

    public void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    public MapperFactory getMapperFactory() {
        return mapperFactory;
    }

    public void setMapperFactory(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    public List<OrikaRegisty> getOrikaRegistyList() {
        return orikaRegistyList;
    }

    public void setOrikaRegistyList(List<OrikaRegisty> orikaRegistyList) {
        this.orikaRegistyList = orikaRegistyList;
    }
}

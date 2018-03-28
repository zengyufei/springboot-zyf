package com.zyf.springboot.base.mvc;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.BaseEntity;
import com.zyf.springboot.base.BaseVoEntity;
import com.zyf.springboot.base.orika.OrikaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * @author qixiaobo
 */
public abstract class AbstractServiceVoImpl<M extends BaseMapper<T>,
        T extends BaseEntity<T, PK>,
        V extends BaseVoEntity<PK>,
        PK extends Serializable>
        extends ServiceImpl<M, T> implements AbstractServiceVo<T, V, PK> {

    protected Class<V> vClass;
    protected Class<T> tClass;
    protected Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected OrikaMapper orikaMapper;

    public AbstractServiceVoImpl() {
        TypeToken<T> poType = new TypeToken<T>(getClass()) {
        };
        TypeToken<V> voType = new TypeToken<V>(getClass()) {
        };
        tClass = (Class<T>) poType.getRawType();
        vClass = (Class<V>) voType.getRawType();
    }

    @Override
    public int selectCount(V v) {
        Preconditions.checkArgument(v != null);
        T convert = orikaMapper.convert(v, tClass);
        return baseMapper.selectCount(new EntityWrapper<T>(convert));
    }

    @Override
    public boolean insertVo(V v) {
        Preconditions.checkArgument(v != null);
        T t = orikaMapper.convert(v, tClass);
        return this.insert(t);
    }

    @Override
    public boolean insertVoAllColumn(V v) {
        Preconditions.checkArgument(v != null);
        T t = orikaMapper.convert(v, tClass);
        return this.insertAllColumn(t);
    }

    @Override
    public boolean insertVoBatch(List<V> vList) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.insertBatch(list);
    }

    @Override
    public boolean insertVoBatch(List<V> vList, int batchSize) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.insertBatch(list, batchSize);
    }

    @Override
    public boolean insertOrUpdateVoBatch(List<V> vList) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.insertOrUpdateBatch(list);
    }

    @Override
    public boolean insertOrUpdateVoBatch(List<V> vList, int batchSize) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.insertOrUpdateBatch(list, batchSize);
    }

    @Override
    public boolean insertOrUpdateVoAllColumnBatch(List<V> vList) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.insertOrUpdateAllColumnBatch(list);
    }

    @Override
    public boolean insertOrUpdateVoAllColumnBatch(List<V> vList, int batchSize) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.insertOrUpdateAllColumnBatch(list, batchSize);
    }

    @Override
    public boolean deleteVoById(Serializable id) {
        return this.deleteById(id);
    }

    @Override
    public boolean deleteVoByMap(Map<String, Object> columnMap) {
        return deleteByMap(columnMap);
    }

    @Override
    public boolean deleteVo(Wrapper<V> wrapper) {
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        return delete(entityWrapper);
    }

    @Override
    public boolean deleteVoBatchIds(Collection<? extends Serializable> idList) {
        return this.deleteBatchIds(idList);
    }

    @Override
    public boolean updateVoById(V v) {
        T t = orikaMapper.convert(v, tClass);
        return this.updateById(t);
    }

    @Override
    public boolean updateVoAllColumnById(V v) {
        T t = orikaMapper.convert(v, tClass);
        return this.updateAllColumnById(t);
    }

    @Override
    public boolean updateVo(V entity, Wrapper<V> wrapper) {
        T t = orikaMapper.convert(entity, tClass);
        EntityWrapper<T> entityWrapper = new EntityWrapper<>(t);
        return update(t, entityWrapper);
    }

    @Override
    public boolean updateVoBatchById(List<V> vList) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.updateBatchById(list);
    }

    @Override
    public boolean updateVoBatchById(List<V> vList, int batchSize) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.updateBatchById(list, batchSize);
    }

    @Override
    public boolean updateVoAllColumnBatchById(List<V> vList) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.updateAllColumnBatchById(list);
    }

    @Override
    public boolean updateVoAllColumnBatchById(List<V> vList, int batchSize) {
        List<T> list = orikaMapper.convertList(vList, tClass);
        return this.updateAllColumnBatchById(list, batchSize);
    }

    @Override
    public boolean insertOrUpdateVo(V v) {
        T t = orikaMapper.convert(v, tClass);
        return this.insertOrUpdate(t);
    }

    @Override
    public boolean insertOrUpdateVoAllColumn(V v) {
        T t = orikaMapper.convert(v, tClass);
        return this.insertOrUpdateAllColumn(t);
    }

    @Override
    public V selectVoById(Serializable id) {
        T t = this.selectById(id);
        return orikaMapper.convert(t, vClass);
    }

    @Override
    public List<V> selectVoBatchIds(Collection<? extends Serializable> idList) {
        List<T> list = this.selectBatchIds(idList);
        return orikaMapper.convertList(list, vClass);
    }

    @Override
    public List<V> selectVoByMap(Map<String, Object> columnMap) {
        List<T> list = this.selectByMap(columnMap);
        return orikaMapper.convertList(list, vClass);
    }

    @Override
    public V selectVoOne(Wrapper<V> wrapper) {
        Wrapper<T> poWrapper = getPoWrapper(wrapper);
        T t = this.selectOne(poWrapper);
        return orikaMapper.convert(t, vClass);
    }

    @Override
    public Map<String, Object> selectVoMap(Wrapper<V> wrapper) {
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        return this.selectMap(entityWrapper);
    }

    @Override
    public Object selectVoObj(Wrapper<V> wrapper) {
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        return this.selectObj(entityWrapper);
    }

    @Override
    public int selectVoCount(Wrapper<V> wrapper) {
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        return selectCount(entityWrapper);
    }

    @Override
    public List<V> selectVoList(Wrapper<V> wrapper) {
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        List<T> list = this.selectList(entityWrapper);
        return orikaMapper.convertList(list, vClass);
    }

    @Override
    public Page<V> selectVoPage(Page<V> page) {
        Page<T> tPage = orikaMapper.convertPage(page.getRecords(), tClass);
        Page<T> page2 = this.selectPage(tPage);
        return orikaMapper.convertPage(page2.getRecords(), vClass);
    }

    @Override
    public List<Map<String, Object>> selectVoMaps(Wrapper<V> wrapper) {
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        return selectMaps(entityWrapper);
    }

    @Override
    public List<Object> selectVoObjs(Wrapper<V> wrapper) {
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        return selectObjs(entityWrapper);
    }

    @Override
    public Page<Map<String, Object>> selectVoMapsPage(Page page, Wrapper<V> wrapper) {
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        return this.selectMapsPage(page, entityWrapper);
    }

    @Override
    public Page<V> selectVoPage(Page<V> page, Wrapper<V> wrapper) {
        Page<T> page1 = orikaMapper.convert(page, Page.class);
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        Page<T> tPage1 = selectPage(page1, entityWrapper);
        page.setTotal(tPage1.getTotal());
        return page.setRecords(orikaMapper.convertList(tPage1.getRecords(), vClass));
    }

    private Wrapper<T> getPoWrapper(Wrapper<V> wrapper) {
        V v = wrapper.getEntity();
        if (v == null) {
            T t = orikaMapper.convert(v, tClass);
            return new EntityWrapper<T>(t);
        }
        return new EntityWrapper<T>();
    }
}
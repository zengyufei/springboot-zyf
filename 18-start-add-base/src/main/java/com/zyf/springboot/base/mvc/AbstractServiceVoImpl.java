package com.zyf.springboot.base.mvc;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.BaseEntity;
import com.zyf.springboot.base.BaseVoEntity;
import com.zyf.springboot.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    protected Class<V> voClazz;
    protected Class<T> poClazz;

    protected Logger log = LoggerFactory.getLogger(getClass());

    public AbstractServiceVoImpl() {
        TypeToken<T> poType = new TypeToken<T>(getClass()) {
        };
        TypeToken<V> voType = new TypeToken<V>(getClass()) {
        };
        poClazz = (Class<T>) poType.getRawType();
        voClazz = (Class<V>) voType.getRawType();
    }

    @Override
    public int selectCount(V v) {
        Preconditions.checkArgument(v != null);
        T convert = BeanUtils.copy(v, poClazz);
        return baseMapper.selectCount(new EntityWrapper<T>(convert));
    }

    @Override
    public boolean insertVo(V entity) {
        T t = BeanUtils.copy(entity, poClazz);
        return this.insert(t);
    }

    @Override
    public boolean insertVoAllColumn(V entity) {
        T t = BeanUtils.copy(entity, poClazz);
        return this.insertAllColumn(t);
    }

    @Override
    public boolean insertVoBatch(List<V> entityList) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.insertBatch(list);
    }

    @Override
    public boolean insertVoBatch(List<V> entityList, int batchSize) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.insertBatch(list, batchSize);
    }

    @Override
    public boolean insertOrUpdateVoBatch(List<V> entityList) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.insertOrUpdateBatch(list);
    }

    @Override
    public boolean insertOrUpdateVoBatch(List<V> entityList, int batchSize) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.insertOrUpdateBatch(list, batchSize);
    }

    @Override
    public boolean insertOrUpdateVoAllColumnBatch(List<V> entityList) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.insertOrUpdateAllColumnBatch(list);
    }

    @Override
    public boolean insertOrUpdateVoAllColumnBatch(List<V> entityList, int batchSize) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
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
    public boolean updateVoById(V entity) {
        T t = BeanUtils.copy(entity, poClazz);
        return this.updateById(t);
    }

    @Override
    public boolean updateVoAllColumnById(V entity) {
        T t = BeanUtils.copy(entity, poClazz);
        return this.updateAllColumnById(t);
    }

    @Override
    public boolean updateVo(V entity, Wrapper<V> wrapper) {
        T t = BeanUtils.copy(entity, poClazz);
        EntityWrapper<T> entityWrapper = new EntityWrapper<>(t);
        return update(t, entityWrapper);
    }

    @Override
    public boolean updateVoBatchById(List<V> entityList) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.updateBatchById(list);
    }

    @Override
    public boolean updateVoBatchById(List<V> entityList, int batchSize) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.updateBatchById(list, batchSize);
    }

    @Override
    public boolean updateVoAllColumnBatchById(List<V> entityList) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.updateAllColumnBatchById(list);
    }

    @Override
    public boolean updateVoAllColumnBatchById(List<V> entityList, int batchSize) {
        List<T> list = Lists.newArrayList();
        for (V v : entityList) {
            T t = BeanUtils.copy(v, poClazz);
            list.add(t);
        }
        return this.updateAllColumnBatchById(list, batchSize);
    }

    @Override
    public boolean insertOrUpdateVo(V entity) {
        T t = BeanUtils.copy(entity, poClazz);
        return this.insertOrUpdate(t);
    }

    @Override
    public boolean insertOrUpdateVoAllColumn(V entity) {
        T t = BeanUtils.copy(entity, poClazz);
        return this.insertOrUpdateAllColumn(t);
    }

    @Override
    public V selectVoById(Serializable id) {
        T t = this.selectById(id);
        return BeanUtils.copy(t, voClazz);
    }

    @Override
    public List<V> selectVoBatchIds(Collection<? extends Serializable> idList) {
        List<T> entityList = this.selectBatchIds(idList);
        List<V> list = Lists.newArrayList();
        for (T t : entityList) {
            V v = BeanUtils.copy(t, voClazz);
            list.add(v);
        }
        return list;
    }

    @Override
    public List<V> selectVoByMap(Map<String, Object> columnMap) {
        List<T> entityList = this.selectByMap(columnMap);
        List<V> list = Lists.newArrayList();
        for (T t : entityList) {
            V v = BeanUtils.copy(t, voClazz);
            list.add(v);
        }
        return list;
    }

    @Override
    public V selectVoOne(Wrapper<V> wrapper) {
        Wrapper<T> poWrapper = getPoWrapper(wrapper);
        T t = this.selectOne(poWrapper);
        return BeanUtils.copy(t, voClazz);
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
        List<T> entityList = this.selectList(entityWrapper);
        List<V> list = Lists.newArrayList();
        for (T t : entityList) {
            V v = BeanUtils.copy(t, voClazz);
            list.add(v);
        }
        return list;
    }

    @Override
    public Page<V> selectVoPage(Page<V> page) {
        Page<T> tPage = new Page<>(page.getCurrent(), page.getSize());
        Page<T> page2 = this.selectPage(tPage);
        List<T> entityList = page2.getRecords();
        List<V> list = Lists.newArrayList();
        for (T t : entityList) {
            V v = BeanUtils.copy(t, voClazz);
            list.add(v);
        }
        page.setRecords(list);
        page.setTotal(list.size());
        return page;
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
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        Page<T> tPage = new Page<>(page.getCurrent(), page.getSize());
        Page<T> page2 = this.selectPage(tPage, entityWrapper);
        List<T> entityList = page2.getRecords();
        List<V> list = Lists.newArrayList();
        for (T t : entityList) {
            V v = BeanUtils.copy(t, voClazz);
            list.add(v);
        }
        page.setRecords(list);
        page.setTotal(list.size());
        return page;
    }

    private Wrapper<T> getPoWrapper(Wrapper<V> wrapper) {
        V entity = wrapper.getEntity();
        if (entity != null) {
            T convert = BeanUtils.copy(entity, poClazz);
            return new EntityWrapper<T>(convert);
        }
        return new EntityWrapper<T>();
    }
}

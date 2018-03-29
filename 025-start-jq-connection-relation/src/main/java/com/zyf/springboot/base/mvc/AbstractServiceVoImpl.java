package com.zyf.springboot.base.mvc;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.base.VO;
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
        T extends PO<T, PK>,
        V extends VO,
        PK extends Serializable>
        extends ServiceImpl<M, T> implements AbstractServiceVo<T, V> {

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
        this.tClass = (Class<T>) poType.getRawType();
        this.vClass = (Class<V>) voType.getRawType();
    }

    protected EntityWrapper<V> getWrapper() {
        return new EntityWrapper<>();
    }

    protected EntityWrapper<V> getWrapper(V v) {
        return new EntityWrapper<>(v);
    }

    @Override
    public int selectCount(V v) {
        Preconditions.checkArgument(v != null);
        T convert = this.orikaMapper.convert(v, this.tClass);
        return this.baseMapper.selectCount(new EntityWrapper<T>(convert));
    }

    @Override
    public boolean insertVo(V v) {
        Preconditions.checkArgument(v != null);
        T t = this.orikaMapper.convert(v, this.tClass);
        boolean insert = this.insert(t);
        if (insert) {
            this.orikaMapper.convert(t, v);
        }
        return insert;
    }

    @Override
    public boolean insertVoAllColumn(V v) {
        Preconditions.checkArgument(v != null);
        T t = this.orikaMapper.convert(v, this.tClass);
        boolean b = this.insertAllColumn(t);
        if (b) {
            this.orikaMapper.convert(t, v);
        }
        return b;
    }

    @Override
    public boolean insertVoBatch(List<V> vList) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        boolean b = this.insertBatch(list);
        if (b) {
            this.orikaMapper.convert(list, vList);
        }
        return b;
    }

    @Override
    public boolean insertVoBatch(List<V> vList, int batchSize) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        boolean b = this.insertBatch(list, batchSize);
        if (b) {
            this.orikaMapper.convert(list, vList);
        }
        return b;
    }

    @Override
    public boolean insertOrUpdateVoBatch(List<V> vList) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        boolean b = this.insertOrUpdateBatch(list);
        if (b) {
            this.orikaMapper.convert(list, vList);
        }
        return b;
    }

    @Override
    public boolean insertOrUpdateVoBatch(List<V> vList, int batchSize) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        return this.insertOrUpdateBatch(list, batchSize);
    }

    @Override
    public boolean insertOrUpdateVoAllColumnBatch(List<V> vList) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        boolean b = this.insertOrUpdateAllColumnBatch(list);
        if (b) {
            this.orikaMapper.convert(list, vList);
        }
        return b;
    }

    @Override
    public boolean insertOrUpdateVoAllColumnBatch(List<V> vList, int batchSize) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        boolean b = this.insertOrUpdateAllColumnBatch(list, batchSize);
        if (b) {
            this.orikaMapper.convert(list, vList);
        }
        return b;
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
        T t = this.orikaMapper.convert(v, this.tClass);
        return this.updateById(t);
    }

    @Override
    public boolean updateVoAllColumnById(V v) {
        T t = this.orikaMapper.convert(v, this.tClass);
        return this.updateAllColumnById(t);
    }

    @Override
    public boolean updateVo(V entity, Wrapper<V> wrapper) {
        T t = this.orikaMapper.convert(entity, this.tClass);
        EntityWrapper<T> entityWrapper = new EntityWrapper<>(t);
        return update(t, entityWrapper);
    }

    @Override
    public boolean updateVoBatchById(List<V> vList) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        return this.updateBatchById(list);
    }

    @Override
    public boolean updateVoBatchById(List<V> vList, int batchSize) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        return this.updateBatchById(list, batchSize);
    }

    @Override
    public boolean updateVoAllColumnBatchById(List<V> vList) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        return this.updateAllColumnBatchById(list);
    }

    @Override
    public boolean updateVoAllColumnBatchById(List<V> vList, int batchSize) {
        List<T> list = this.orikaMapper.convertList(vList, this.tClass);
        return this.updateAllColumnBatchById(list, batchSize);
    }

    @Override
    public boolean insertOrUpdateVo(V v) {
        T t = this.orikaMapper.convert(v, this.tClass);
        return this.insertOrUpdate(t);
    }

    @Override
    public boolean insertOrUpdateVoAllColumn(V v) {
        T t = this.orikaMapper.convert(v, this.tClass);
        return this.insertOrUpdateAllColumn(t);
    }

    @Override
    public V selectVoById(Serializable id) {
        T t = this.selectById(id);
        return this.orikaMapper.convert(t, this.vClass);
    }

    @Override
    public List<V> selectVoBatchIds(Collection<? extends Serializable> idList) {
        List<T> list = this.selectBatchIds(idList);
        return this.orikaMapper.convertList(list, this.vClass);
    }

    @Override
    public List<V> selectVoByMap(Map<String, Object> columnMap) {
        List<T> list = this.selectByMap(columnMap);
        return this.orikaMapper.convertList(list, this.vClass);
    }

    @Override
    public V selectVoOne(Wrapper<V> wrapper) {
        Wrapper<T> poWrapper = getPoWrapper(wrapper);
        T t = this.selectOne(poWrapper);
        return this.orikaMapper.convert(t, this.vClass);
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
        return this.orikaMapper.convertList(list, this.vClass);
    }

    @Override
    public Page<V> selectVoPage(Page<V> page) {
        Page<T> tPage = this.orikaMapper.convertPage(page.getRecords(), this.tClass);
        Page<T> page2 = this.selectPage(tPage);
        return this.orikaMapper.convertPage(page2.getRecords(), this.vClass);
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
        Page<T> page1 = this.orikaMapper.convert(page, Page.class);
        Wrapper<T> entityWrapper = getPoWrapper(wrapper);
        Page<T> tPage1 = this.selectPage(page1, entityWrapper);
        page.setTotal(tPage1.getTotal());
        return page.setRecords(this.orikaMapper.convertList(tPage1.getRecords(), this.vClass));
    }

    private Wrapper getPoWrapper(Wrapper<V> wrapper) {
        return wrapper;
    }
}
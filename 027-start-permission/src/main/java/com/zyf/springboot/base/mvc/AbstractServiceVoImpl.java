package com.zyf.springboot.base.mvc;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.base.VO;
import com.zyf.springboot.base.orika.OrikaMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * @author zengyufei
 */
@SuppressWarnings("all")
public abstract class AbstractServiceVoImpl<M extends BaseMapper<T>,
        T extends PO<T, PK>,
        V extends VO,
        PK extends Serializable>
        extends ServiceImpl<M, T> implements AbstractServiceVo<T, V> {

    protected Class<V> vClass;
    protected Class<T> tClass;
    protected final Log log = LogFactory.get();

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

    protected EntityWrapper<T> create() {
        return new EntityWrapper<>();
    }

    protected EntityWrapper<T> create(V v) {
        T t = orikaMapper.convert(v, tClass);
        return new EntityWrapper<>(t);
    }

    protected EntityWrapper<T> create(T t) {
        return new EntityWrapper<>(t);
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
    public Page<V> selectVoPage(Page<V> page, Wrapper<T> wrapper) {
        Page<T> page1 = this.orikaMapper.convert(page, Page.class);

        Page<T> tPage1 = this.selectPage(page1, wrapper);
        page.setTotal(tPage1.getTotal());
        List<V> records = this.orikaMapper.convertList(tPage1.getRecords(), this.vClass);
        return page.setRecords(records);
    }

    private Wrapper<T> getPoWrapper(Wrapper<V> wrapper) {
        if (wrapper instanceof EntityWrapper) {
            EntityWrapper vEntityWrapper = (EntityWrapper) wrapper;
            T t = orikaMapper.convert(wrapper.getEntity(), tClass);
            vEntityWrapper.setEntity(t);
            return vEntityWrapper;
        } else if (wrapper instanceof Condition) {
            Condition vEntityWrapper = (Condition) wrapper;
            return vEntityWrapper.wrapper();
        } else {
            Wrapper vEntityWrapper = wrapper;
            return vEntityWrapper;
        }
    }
}
package com.zyf.springboot.base.mvc;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.base.VO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * AbstractServiceVo 层 基础接口，其他Service 接口 请继承该接口
 */
public interface AbstractServiceVo<
        T extends PO,
        V extends VO>
        extends IService<T> {

    int selectCount(V v);

    boolean insertVo(V entity);

    boolean insertVoAllColumn(V entity);

    boolean insertVoBatch(List<V> entityList);

    boolean insertVoBatch(List<V> entityList, int batchSize);

    boolean insertOrUpdateVoBatch(List<V> entityList);

    boolean insertOrUpdateVoBatch(List<V> entityList, int batchSize);

    boolean insertOrUpdateVoAllColumnBatch(List<V> entityList);

    boolean insertOrUpdateVoAllColumnBatch(List<V> entityList, int batchSize);

    boolean deleteVoById(Serializable id);

    boolean deleteVoByMap(Map<String, Object> columnMap);

    boolean deleteVo(Wrapper<V> wrapper);

    boolean deleteVoBatchIds(Collection<? extends Serializable> idList);

    boolean updateVoById(V entity);

    boolean updateVoAllColumnById(V entity);

    boolean updateVo(V entity, Wrapper<V> wrapper);

    boolean updateVoBatchById(List<V> entityList);

    boolean updateVoBatchById(List<V> entityList, int batchSize);

    boolean updateVoAllColumnBatchById(List<V> entityList);

    boolean updateVoAllColumnBatchById(List<V> entityList, int batchSize);

    boolean insertOrUpdateVo(V entity);

    boolean insertOrUpdateVoAllColumn(V entity);

    V selectVoById(Serializable id);

    List<V> selectVoBatchIds(Collection<? extends Serializable> idList);

    List<V> selectVoByMap(Map<String, Object> columnMap);

    V selectVoOne(Wrapper<V> wrapper);

    Map<String, Object> selectVoMap(Wrapper<V> wrapper);

    Object selectVoObj(Wrapper<V> wrapper);

    int selectVoCount(Wrapper<V> wrapper);

    List<V> selectVoList(Wrapper<V> wrapper);

    Page<V> selectVoPage(Page<V> page);

    List<Map<String, Object>> selectVoMaps(Wrapper<V> wrapper);

    List<Object> selectVoObjs(Wrapper<V> wrapper);

    Page<Map<String, Object>> selectVoMapsPage(Page page, Wrapper<V> wrapper);

    Page<V> selectVoPage(Page<V> page, Wrapper<T> wrapper);
}
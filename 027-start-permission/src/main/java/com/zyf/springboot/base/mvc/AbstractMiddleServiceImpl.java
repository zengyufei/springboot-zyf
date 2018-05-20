package com.zyf.springboot.base.mvc;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.base.orika.OrikaMapper;
import com.zyf.springboot.config.middle.FromColumn;
import com.zyf.springboot.config.middle.PrimaryColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * D : Middle 中间表对象
 * P : Primary-主 关联对象 主表对象
 * F : From-从 关联对象 从表对象
 */
public abstract class AbstractMiddleServiceImpl<M extends BaseMapper<T>,
        T extends PO<T, PK>,
        S extends BaseMapper<P>,
        P extends PO<P, PK>,
        G extends BaseMapper<F>,
        F extends PO<F, PK>,
        PK extends Serializable>
        extends ServiceImpl<M, T> implements AbstractMiddleService<T, P, F> {

    protected Class<T> tClazz;
    protected Class<P> pClazz;
    protected Class<F> fClazz;

    @Autowired
    protected M baseMapper;
    @Autowired
    protected S primaryMapper;
    @Autowired
    protected G fromMapper;

    protected Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected OrikaMapper orikaMapper;

    @SuppressWarnings("all")
    public AbstractMiddleServiceImpl() {
        TypeToken<T> tType = new TypeToken<T>(getClass()) {
        };
        this.tClazz = (Class<T>) tType.getRawType();
        TypeToken<P> zType = new TypeToken<P>(getClass()) {
        };
        this.pClazz = (Class<P>) zType.getRawType();
        TypeToken<F> cType = new TypeToken<F>(getClass()) {
        };
        this.fClazz = (Class<F>) cType.getRawType();
    }

    protected EntityWrapper<T> craete() {
        return new EntityWrapper<>();
    }

    protected EntityWrapper<T> craete(T t) {
        return new EntityWrapper<>(t);
    }

    @Override
    public boolean updateByPrimaryId(Serializable primaryId, List<F> froms) {
        if (primaryId == null || Integer.parseInt(primaryId.toString()) <= 0) {
            return false;
        }
        if (CollUtil.isEmpty(froms)) {
            return false;
        }
        Wrapper<T> wrapper;
        Field primayColumnField = getPrimayColumnField();
        if (primayColumnField == null) {
            return false;
        }
        Field fromColumnField = getFromColumnField();
        if (fromColumnField == null) {
            return false;
        }

        String value = getPrimaryColumnValue(primayColumnField);
        if (StrUtil.isNotBlank(value)) {
            wrapper = new EntityWrapper<T>().eq(value, primaryId);
        } else {
            T t = ReflectUtil.newInstance(this.tClazz);
            ReflectUtil.setFieldValue(t, primayColumnField, primaryId);
            wrapper = new EntityWrapper<>(t);
        }
        Integer delete = this.baseMapper.delete(wrapper);
        if (delete > 0) {
            List<T> addList = Lists.newArrayList();
            for (F from : froms) {
                T t = ReflectUtil.newInstance(this.tClazz);
                addList.add(t);
                ReflectUtil.setFieldValue(t, primayColumnField, primaryId);
                ReflectUtil.setFieldValue(t, fromColumnField, from.getId());
            }
            return this.insertBatch(addList, addList.size());
        }
        return false;
    }

    @Override
    public List<F> selectFromListByPrimaryId(Serializable primaryId) {
        Wrapper<T> wrapper;
        Field primayColumnField = getPrimayColumnField();
        if (primayColumnField == null) {
            return Lists.newArrayList();
        }
        Field fromColumnField = getFromColumnField();
        if (fromColumnField == null) {
            return Lists.newArrayList();
        }
        String primaryColumnValue = getPrimaryColumnValue(primayColumnField);
        if (StrUtil.isNotBlank(primaryColumnValue)) {
            wrapper = new EntityWrapper<T>().eq(primaryColumnValue, primaryId);
        } else {
            T t = ReflectUtil.newInstance(this.tClazz);
            ReflectUtil.setFieldValue(t, primayColumnField, primaryId);
            wrapper = new EntityWrapper<>(t);
        }
        List<T> middle = this.baseMapper.selectList(wrapper);
        List<PK> fromIds = middle.stream().map(item -> (PK) ReflectUtil.getFieldValue(item, fromColumnField.getName())).collect(Collectors.toList());
        if (CollUtil.isNotEmpty(fromIds)) {
            return this.fromMapper.selectBatchIds(fromIds);
        }
        return Lists.newArrayList();
    }

    @Override
    public boolean deleteMiddleByPrimaryId(Serializable primaryId) {
        Wrapper<T> wrapper;
        Field primayColumnField = getPrimayColumnField();
        if (primayColumnField == null) {
            return false;
        }

        String value = getPrimaryColumnValue(primayColumnField);
        if (StrUtil.isNotBlank(value)) {
            wrapper = new EntityWrapper<T>().eq(value, primaryId);
        } else {
            T t = ReflectUtil.newInstance(this.tClazz);
            ReflectUtil.setFieldValue(t, primayColumnField, primaryId);
            wrapper = new EntityWrapper<>(t);
        }

        Integer delete = this.baseMapper.delete(wrapper);
        return delete > 0;
    }

    @Override
    public boolean deleteMiddleByFromId(Serializable fromId) {
        Wrapper<T> wrapper;
        Field fromColumnField = getFromColumnField();
        if (fromColumnField == null) {
            return false;
        }

        String value = getFromColumnValue(fromColumnField);
        if (StrUtil.isNotBlank(value)) {
            wrapper = new EntityWrapper<T>().eq(value, fromId);
        } else {
            T t = ReflectUtil.newInstance(this.tClazz);
            ReflectUtil.setFieldValue(t, fromColumnField, fromId);
            wrapper = new EntityWrapper<>(t);
        }

        Integer delete = this.baseMapper.delete(wrapper);
        return delete > 0;
    }


    @Override
    public List<F> selectFromListByPrimaryIds(List<Serializable> entityIds) {
        List<F> fList = CollUtil.newArrayList();
        if (CollUtil.isEmpty(entityIds)) {
            return fList;
        }

        Field primayColumnField = getPrimayColumnField();
        if (primayColumnField == null) {
            return fList;
        }

        Field fromColumnField = getFromColumnField();
        if (fromColumnField == null) {
            return fList;
        }

        /* primary in */
        String primayColumnFieldName = primayColumnField.getName();
        Wrapper wrapper = Condition.create().in(StrUtil.toUnderlineCase(primayColumnFieldName), entityIds);
        List<T> entitys = this.baseMapper.selectList(wrapper);
        if (CollUtil.isEmpty(entitys)) {
            return fList;
        }

        /* from in */
        List<PK> fromIds = entitys.stream()
                .map(item -> (PK) ReflectUtil.getFieldValue(item, fromColumnField.getName()))
                .collect(Collectors.toList());
        fromIds = CollUtil.distinct(fromIds); //去重
        List<F> froms = this.fromMapper.selectBatchIds(fromIds);
        if (CollUtil.isEmpty(froms)) {
            return fList;
        }

        /* map */
        Multimap<PK, T> entityMap = ArrayListMultimap.create();
        entitys.forEach(item -> {
            entityMap.put((PK) ReflectUtil.getFieldValue(item, primayColumnField.getName()), item);
        });
        Map<Object, F> fromMap = IterUtil.fieldValueMap(froms, "id");

        for (Serializable id : entityIds) {
            if (entityMap.containsKey(id)) {
                for (T currentEntity : entityMap.get((PK) id)) {
                    PK fromId = (PK) ReflectUtil.getFieldValue(currentEntity, primayColumnField.getName());
                    if (fromMap.containsKey(fromId)) {
                        F from = fromMap.get(fromId);
                        fList.add(from);
                    }
                }
            }
        }
        return fList;
    }

    private Field getPrimayColumnField() {
        Field primaryColumnField = null;
        Field[] declaredFields = ClassUtil.getDeclaredFields(this.tClazz);
        for (Field declaredField : declaredFields) {
            boolean annotationPrimaryColumnPresent = declaredField.isAnnotationPresent(PrimaryColumn.class);
            if (annotationPrimaryColumnPresent) {
                primaryColumnField = declaredField;
            }
        }
        if (primaryColumnField == null) {
            String simpleName = ClassUtil.getClassName(this.pClazz, true);
            primaryColumnField = ClassUtil.getDeclaredField(this.tClazz, StrUtil.lowerFirst(simpleName + "Id"));
        }
        return primaryColumnField;
    }

    private String getPrimaryColumnValue(Field primayColumnField) {
        String value = null;
        PrimaryColumn primaryColumn = primayColumnField.getAnnotation(PrimaryColumn.class);
        if (primaryColumn != null) {
            value = primaryColumn.value();
        }
        return value;
    }


    private Field getFromColumnField() {
        Field fromColumnField = null;
        Field[] declaredFields = ClassUtil.getDeclaredFields(this.tClazz);
        for (Field declaredField : declaredFields) {
            boolean annotationFromColumnPresent = declaredField.isAnnotationPresent(FromColumn.class);
            if (annotationFromColumnPresent) {
                fromColumnField = declaredField;
            }
        }

        if (fromColumnField == null) {
            String simpleName = ClassUtil.getClassName(this.fClazz, true);
            fromColumnField = ClassUtil.getDeclaredField(this.tClazz, StrUtil.lowerFirst(simpleName + "Id"));
        }
        return fromColumnField;
    }

    private String getFromColumnValue(Field fromColumnField) {
        String value = null;
        FromColumn fromColumn = fromColumnField.getAnnotation(FromColumn.class);
        if (fromColumn != null) {
            value = fromColumn.value();
        }
        return value;
    }


}

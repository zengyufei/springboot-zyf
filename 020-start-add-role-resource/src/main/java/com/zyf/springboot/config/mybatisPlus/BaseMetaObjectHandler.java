package com.zyf.springboot.config.mybatisPlus;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * 自定义填充公共 name 字段
 */
public class BaseMetaObjectHandler extends MetaObjectHandler {

    /**
     * 字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 当前用户注入
        Object createId = getFieldValByName("createId", metaObject);//mybatis-plus版本2.0.9+
        if (createId == null) {
            setFieldValByName("createId", 1, metaObject);//mybatis-plus版本2.0.9+
            setFieldValByName("updateId", 1, metaObject);//mybatis-plus版本2.0.9+
        } else if (Integer.parseInt(createId.toString()) == 0) {
            setFieldValByName("createId", 1, metaObject);//mybatis-plus版本2.0.9+
            setFieldValByName("updateId", 1, metaObject);//mybatis-plus版本2.0.9+
        }
        // 创建时间注入
        Object createTime = getFieldValByName("createTime", metaObject);//mybatis-plus版本2.0.9+
        if (createTime == null) {
            setFieldValByName("createTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
        }
        // 修改时间注入
        Object updateTime = getFieldValByName("updateTime", metaObject);//mybatis-plus版本2.0.9+
        if (updateTime == null) {
            setFieldValByName("updateTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
        }
        // 修改开启注入
        Object enableTime = getFieldValByName("enableTime", metaObject);//mybatis-plus版本2.0.9+
        if (enableTime == null) {
            setFieldValByName("enableTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 当前用户注入
        setFieldValByName("updateId", 1, metaObject);//mybatis-plus版本2.0.9+

        // 修改时间注入
        setFieldValByName("updateTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
    }

}
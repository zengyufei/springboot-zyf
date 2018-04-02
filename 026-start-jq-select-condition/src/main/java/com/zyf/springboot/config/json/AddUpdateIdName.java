package com.zyf.springboot.config.json;

import cn.hutool.cache.impl.FIFOCache;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zyf.springboot.entity.sys.User;
import com.zyf.springboot.utils.MyCacheUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

public class AddUpdateIdName implements ObjectSerializer {

    private static final ThreadLocal<FIFOCache> fifoCacheThreadLocal = new ThreadLocal<>();

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                      int features) {
        serializer.write(object);

        FIFOCache fifoCache = MyCacheUtil.getCache();
        if (fifoCache.containsKey(object)) {
            String value = fifoCache.get(object).toString();
            serializer.getWriter().writeFieldValue(',', "updateName", StringUtils.isBlank(value) ? "" : value);
        } else {
            Wrapper wrapper = Condition.create().setSqlSelect("real_name").eq("id", object);
            User user = (User) new User().selectOne(wrapper);
            if (user != null) {
                String value = user.getRealName();
                fifoCache.put(object, value);
                serializer.getWriter().writeFieldValue(',', "updateName", StringUtils.isBlank(value) ? "" : value);
            }
        }

    }

}
package com.zyf.springboot.config.json;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.zyf.springboot.base.BaseEnum;

import java.lang.reflect.Type;

public class AddEnumTypeName implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                      int features) {
        serializer.write(object);
        if (object instanceof BaseEnum) {
            String value = ((BaseEnum) object).getMark();
            serializer.getWriter().writeFieldValue(',', fieldName + "Name", value);
        }
    }
}
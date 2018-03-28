package com.zyf.springboot.config.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zyf.springboot.base.BaseEnum;

import java.lang.reflect.Type;

public class AddEnumTypeName implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                      int features) {
        serializer.write(object);
        if (object instanceof BaseEnum) {
            JSON.DEFAULT_GENERATE_FEATURE = SerializerFeature.config(JSON.DEFAULT_GENERATE_FEATURE, SerializerFeature.WriteEnumUsingName, false);
            String index = JSONObject.toJSONString(object);
            BaseEnum[] enumConstants = (BaseEnum[]) ((Class) fieldType).getEnumConstants();
            for (BaseEnum enumConstant : enumConstants) {
                if (enumConstant.getIndex() == Integer.parseInt(index)) {
                    serializer.getWriter().writeFieldValue(',', fieldName + "Name", enumConstant.getMark());
                }
            }
        }
    }
}
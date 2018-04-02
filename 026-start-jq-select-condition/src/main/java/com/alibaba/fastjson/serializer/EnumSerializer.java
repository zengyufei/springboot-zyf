package com.alibaba.fastjson.serializer;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReflectUtil;
import com.zyf.springboot.base.BaseEnum;

import java.io.IOException;
import java.lang.reflect.Type;

public class EnumSerializer implements ObjectSerializer {

    public final static EnumSerializer instance = new EnumSerializer();

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        if (object instanceof BaseEnum) {
            BaseEnum baseEnum = (BaseEnum) object;
            Object indexObj = ReflectUtil.getFieldValue(baseEnum, "index");
            Integer index = Convert.toInt(indexObj, 0);
            out.writeInt(index);
            out.writeFieldValue(',', fieldName + "Name", baseEnum.getMark());
        } else {
            out.writeEnum((Enum<?>) object);
        }
    }
}

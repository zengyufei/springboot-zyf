package com.zyf.springboot.config.json;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zyf.springboot.entity.sys.User;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

public class AddUpdateIdName implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType,
                      int features) {
        serializer.write(object);
        Wrapper wrapper = Condition.create().setSqlSelect("real_name").eq("id", object);
        User user = (User) new User().selectOne(wrapper);
        if (user != null) {
            String value = user.getRealName();
            serializer.getWriter().writeFieldValue(',', "updateName", StringUtils.isBlank(value) ? "" : value);
        }
    }

}
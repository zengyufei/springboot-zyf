package com.zyf.springboot.base;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 消息传输类。结果返回集。
 * 可用在 service 服务层或 controller 控制层层
 * 有三种快捷方式: ok,fail 和 error
 * error 与 fail 一样的功能，只是名称不一样。
 * @author zengyufei
 * @since 1.0.0
 */
public class Msg<T> {

    private boolean success = true;    //是否成功
    private T data;        //数据
    private String message;     //信息
    private long code;       //错误代码

    public T getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public long getCode() {
        return this.code;
    }

    public Msg() {
    }

    public Msg(int status) {
        this.code = status;
    }

    public Msg(String msg, T data) {
        this.message = msg;
        this.data = data;
    }

    public Msg(boolean success, String msg, T data) {
        this.success = success;
        this.message = msg;
        this.data = data;
    }

    public Msg(int status, String msg, T data) {
        this.code = status;
        this.message = msg;
        this.data = data;
    }

    public Msg(boolean success, int status, String msg, T data) {
        this.success = success;
        this.code = status;
        this.message = msg;
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public static class Test {

        private Object invalidData;

        public Test(Object invalidData) {
            this.invalidData = invalidData;
        }

        @Override
        public String toString() {
            if (this.invalidData == null) {
                return "";
            }
            return this.invalidData.toString();
        }

        public String toJson() {
            return JSONObject.toJSONString(this.invalidData);
        }

    }

    public static Msg.BodyBuilder status(boolean success, int code) {
        return new Msg.DefaultBuilder(success, code);
    }

    public static Msg.BodyBuilder status(boolean success) {
        return new Msg.DefaultBuilder(success);
    }

    /* 快捷输出 start */
    public static Msg.BodyBuilder ok() {
        return status(true, 200);
    }

    public static Msg.BodyBuilder ok(int code) {
        return status(true, code);
    }

    public static Msg ok(Object data) {
        Msg.BodyBuilder builder = ok();
        return builder.body(data);
    }

    public static Msg ok(String msg) {
        Msg.BodyBuilder builder = ok(200);
        return builder.msg(msg).build();
    }

    public static Msg ok(int code, Object data) {
        Msg.BodyBuilder builder = ok(code);
        return builder.body(data);
    }

    public static Msg ok(String msg, Object data) {
        Msg.BodyBuilder builder = ok(200);
        return builder.msg(msg).body(data);
    }

    public static Msg ok(int code, String msg, Object data) {
        Msg.BodyBuilder builder = ok(code);
        return builder.msg(msg).body(data);
    }

    public static Msg.BodyBuilder error() {
        return status(false, 501);
    }

    public static Msg error(Object data) {
        Msg.BodyBuilder builder = error(501);
        return builder.body(data);
    }

    public static Msg.BodyBuilder error(int code) {
        return status(false, code);
    }

    public static Msg error(String msg) {
        Msg.BodyBuilder builder = error(501);
        return builder.msg(msg).build();
    }

    public static Msg error(int code, Object data) {
        Msg.BodyBuilder builder = error(code);
        return builder.body(data);
    }

    public static Msg error(String msg, Object data) {
        Msg.BodyBuilder builder = error(501);
        return builder.msg(msg).body(data);
    }

    public static Msg error(int code, String msg, Object data) {
        Msg.BodyBuilder builder = error(code);
        return builder.msg(msg).body(data);
    }
    /* 快捷输出 end */

    private static class DefaultBuilder implements Msg.BodyBuilder {
        private boolean success;
        private int code;
        private String message;

        private DefaultBuilder(boolean success) {
            this.success = success;
        }

        private DefaultBuilder(boolean success, int code) {
            this.success = success;
            this.code = code;
        }

        public DefaultBuilder(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        @Override
        public Msg body(Object data) {
            Msg msg = new Msg();
            msg.success = this.success;
            msg.message = this.message;
            msg.code = this.code;
            if (data instanceof Number) {
                return new Msg(this.success, this.code, this.message, data);
            }
            msg.data = data;
            if (msg.data == null) {
                msg.data = new Object();
            }
            return msg;
        }

        @Override
        public Msg.BodyBuilder msg(String message) {
            this.message = message;
            return this;
        }

        @Override
        public Msg build() {
            return new Msg(this.success, this.code, this.message, "");
        }
    }

    public interface BodyBuilder {

        Msg body(Object var1);

        Msg.BodyBuilder msg(String message);

        Msg build();
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
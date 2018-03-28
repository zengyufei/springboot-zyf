package com.zyf.springboot.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class BaseEntity {

    /**
     * 主键
     */
    @PassId
    Integer id;

    /**
     * 创建时间
     */
    @SqlValue("now()")
    Date createTime;
    @JSONField(serialize = false)
    @PassStart("createTime")
    Date createStartTime;
    @JSONField(serialize = false)
    @PassEnd("createTime")
    Date createEndTime;
    /**
     * 修改时间
     */
    @SqlValue(value = "now()", isUpdate = true)
    Date updateTime;
    @JSONField(serialize = false)
    @PassStart("updateTime")
    Date updateStartTime;
    @JSONField(serialize = false)
    @PassEnd("updateTime")
    Date updateEndTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }

    public Date getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }

    public Date getUpdateStartTime() {
        return updateStartTime;
    }

    public void setUpdateStartTime(Date updateStartTime) {
        this.updateStartTime = updateStartTime;
    }

    public Date getUpdateEndTime() {
        return updateEndTime;
    }

    public void setUpdateEndTime(Date updateEndTime) {
        this.updateEndTime = updateEndTime;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

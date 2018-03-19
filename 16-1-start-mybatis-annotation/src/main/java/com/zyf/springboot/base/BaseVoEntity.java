package com.zyf.springboot.base;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class BaseVoEntity {

    @PassId
    Integer id;
    /**
     * 当前页
     */
    @Pass
    @JSONField(serialize = false)
    private int pageIndex;
    /**
     * 分页大小
     */
    @Pass
    @JSONField(serialize = false)
    private int pageSize;


    @SqlValue("now()")
    Date createTime;
    @PassStart("createTime")
    @JSONField(serialize = false)
    Date createStartTime;
    @PassEnd("createTime")
    @JSONField(serialize = false)
    Date createEndTime;
    @SqlValue(value = "now()", isUpdate = true)
    Date updateTime;
    @PassStart("updateTime")
    @JSONField(serialize = false)
    Date updateStartTime;
    @JSONField(serialize = false)
    @PassEnd("updateTime")
    Date updateEndTime;


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}

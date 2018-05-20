package com.zyf.springboot.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.config.json.AddCreateIdName;
import com.zyf.springboot.config.json.AddUpdateIdName;

import java.util.Date;

public abstract class VO {

    /**
     * 主键
     */
    protected Integer id;

    /**
     * 删除状态
     */
    protected Integer deleteFlag;

    /**
     * 版本
     */
    protected Integer version;

    /**
     * 创建人
     */
    @JSONField(serializeUsing = AddCreateIdName.class)
    protected Integer createId;
    /**
     * 修改人
     */
    @JSONField(serializeUsing = AddUpdateIdName.class)
    protected Integer updateId;

    /**
     * 创建时间
     */
    protected Date createTime;
    /**
     * 修改时间
     */
    protected Date updateTime;

    /**
     * 创建时间开始
     */
    @JSONField(serialize = false)
    protected Date createTimeLt;
    /**
     * 创建时间结束
     */
    @JSONField(serialize = false)
    protected Date createTimeGt;

    /**
     * 修改时间开始
     */
    @JSONField(serialize = false)
    protected Date updateTimeLt;
    /**
     * 修改时间结束
     */
    @JSONField(serialize = false)
    protected Date updateTimeGt;

    /**
     * 当前页
     */
    @JSONField(serialize = false)
    protected int pageIndex = 1;
    /**
     * 分页大小
     */
    @JSONField(serialize = false)
    protected int pageSize = 10;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCreateId() {
        return this.createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getUpdateId() {
        return this.updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTimeLt() {
        return this.createTimeLt;
    }

    public void setCreateTimeLt(Date createTimeLt) {
        this.createTimeLt = createTimeLt;
    }

    public Date getCreateTimeGt() {
        return this.createTimeGt;
    }

    public void setCreateTimeGt(Date createTimeGt) {
        this.createTimeGt = createTimeGt;
    }

    public Date getUpdateTimeLt() {
        return this.updateTimeLt;
    }

    public void setUpdateTimeLt(Date updateTimeLt) {
        this.updateTimeLt = updateTimeLt;
    }

    public Date getUpdateTimeGt() {
        return this.updateTimeGt;
    }

    public void setUpdateTimeGt(Date updateTimeGt) {
        this.updateTimeGt = updateTimeGt;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

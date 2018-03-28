package com.zyf.springboot.base;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class BaseVoEntity<PK extends Serializable> {

    protected PK id;

    /**
     * 当前页
     */
    @JSONField(serialize = false)
    private int pageIndex = 1;
    /**
     * 分页大小
     */
    @JSONField(serialize = false)
    private int pageSize = 10;

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

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
}

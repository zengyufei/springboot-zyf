package com.zyf.springboot.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseVoEntity {

    /**
     * 当前页
     */
    @JsonIgnore
    private int pageIndex;
    /**
     * 分页大小
     */
    @JsonIgnore
    private int pageSize;

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
}

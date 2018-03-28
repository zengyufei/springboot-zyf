package com.zyf.springboot.base;

import com.alibaba.fastjson.annotation.JSONField;

public class BaseVoEntity {

    /**
     * 当前页
     */
    @JSONField(serialize = false)
    private int pageIndex;
    /**
     * 分页大小
     */
    @JSONField(serialize = false)
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

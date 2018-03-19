package com.zyf.springboot.base;

public class PageRequest {

    /**
     * 当前页
     */
    private int pageIndex;
    /**
     * 分页大小
     */
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

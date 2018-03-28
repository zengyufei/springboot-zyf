package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.VO;
import com.zyf.springboot.entity.sys.Resource;

public class ResourceVo extends Resource implements VO {

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
}
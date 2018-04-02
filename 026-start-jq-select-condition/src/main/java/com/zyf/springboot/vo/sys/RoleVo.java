package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.VO;
import com.zyf.springboot.entity.sys.Role;

import java.util.Date;
import java.util.List;

public class RoleVo extends Role implements VO {

    List<ResourceVo> resourceVos;


    @JSONField(serialize = false)
    private List<Integer> enableList;

    @JSONField(serialize = false)
    private Date createTimeLt;
    @JSONField(serialize = false)
    private Date createTimeGt;
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

    public List<ResourceVo> getResourceVos() {
        return this.resourceVos;
    }

    public void setResourceVos(List<ResourceVo> resourceVos) {
        this.resourceVos = resourceVos;
    }

    public List<Integer> getEnableList() {
        return this.enableList;
    }

    public void setEnableList(List<Integer> enableList) {
        this.enableList = enableList;
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
}
package com.zyf.springboot.vo.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyf.springboot.base.VO;
import com.zyf.springboot.enums.LevelType;

import java.util.List;

public class OperationVo extends VO {

    /**
     * 操作名称
     */
    private String operationName;

    /**
     * 操作编码
     */
    private String operationCode;

    /**
     * 操作 URL
     */
    private String url;

    /**
     * 等级
     */
    private LevelType level;

    /**
     * 上级
     */
    private Integer parentId;

    /**
     * 上级名称
     */
    private String parentName;

    /**
     * 排序
     */
    private Integer sort;

    //---------------------------------------------------------------------------

    @JSONField(serialize = false)
    private List<LevelType> levelList;
    @JSONField(serialize = false)
    private List<Integer> parentIdList;

    //---------------------------------------------------------------------------


    public String getOperationName() {
        return this.operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationCode() {
        return this.operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LevelType getLevel() {
        return this.level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }

    public List<LevelType> getLevelList() {
        return this.levelList;
    }

    public void setLevelList(List<LevelType> levelList) {
        this.levelList = levelList;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Integer> getParentIdList() {
        return this.parentIdList;
    }

    public void setParentIdList(List<Integer> parentIdList) {
        this.parentIdList = parentIdList;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
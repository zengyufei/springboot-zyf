package com.zyf.springboot.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.SqlCondition;
import com.zyf.springboot.base.PO;
import com.zyf.springboot.enums.LevelType;

/**
 * 操作实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class Operation extends PO<Operation, Integer> {

    private static final long serialVersionUID = 8493776103489209667L;
    /**
     * 操作名称
     */
    @TableField(condition = SqlCondition.LIKE_RIGHT)
    private String operationName;

    /**
     * 操作编码
     */
    @TableField(condition = SqlCondition.LIKE_RIGHT)
    private String operationCode;

    /**
     * 操作 URL
     */
    @TableField(condition = SqlCondition.LIKE_RIGHT)
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
     * 排序
     */
    private Integer sort;

    /**
     * 删除状态，默认逻辑删除，重写则为物理删除
     */
    protected Integer deleteFlag;

    public String getOperationName() {
        return this.operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return this.sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getOperationCode() {
        return this.operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public LevelType getLevel() {
        return this.level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }

}

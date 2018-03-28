package com.zyf.springboot.base;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity<T, PK extends Serializable> extends Model {

    /**
     * 主键
     */
    protected PK id;

    /**
     * 删除状态
     */
    @TableLogic
    protected Integer deleteFlag;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    protected Integer createId;
    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Integer updateId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    protected Date createTime;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, update = "now()")
    protected Date updateTime;

    @Version
    private Integer version;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

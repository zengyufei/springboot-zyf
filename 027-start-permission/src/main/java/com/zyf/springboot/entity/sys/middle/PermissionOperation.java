package com.zyf.springboot.entity.sys.middle;

import com.zyf.springboot.base.PO;

import java.util.Objects;

/**
 * 权限-功能操作关联实体类
 * @author zengyufei
 * @since 1.0.0
 */
public class PermissionOperation extends PO<PermissionOperation, Integer> {

    /**
     * 权限外键
     */
    private Integer permissionId;
    /**
     * 功能操作外键
     */
    private Integer operationId;
    /**
     * 删除状态，默认逻辑删除，重写则为物理删除
     */
    protected Integer deleteFlag;

    public PermissionOperation(Integer permissionId, Integer operationId) {
        this.permissionId = permissionId;
        this.operationId = operationId;
    }

    public PermissionOperation(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public PermissionOperation() {
    }

    public Integer getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getOperationId() {
        return this.operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    @Override
    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    @Override
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PermissionOperation that = (PermissionOperation) o;
        return Objects.equals(this.operationId, that.operationId) &&
                Objects.equals(this.permissionId, that.permissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.operationId, this.permissionId);
    }
}

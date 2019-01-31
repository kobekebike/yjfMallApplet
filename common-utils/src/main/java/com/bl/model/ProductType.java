package com.bl.model;

import java.util.Date;

public class ProductType {
    /**
     * 唯一标识（主键）
     */
    private Integer typeId;

    /**
     * 分类名称
     */
    private String typeName;

    /**
     * 分类排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 唯一标识（主键）
     * @return type_id 唯一标识（主键）
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * 唯一标识（主键）
     * @param typeId 唯一标识（主键）
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * 分类名称
     * @return type_name 分类名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 分类名称
     * @param typeName 分类名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 分类排序
     * @return sort 分类排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 分类排序
     * @param sort 分类排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", typeName=").append(typeName);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
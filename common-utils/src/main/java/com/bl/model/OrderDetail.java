package com.bl.model;

import java.util.Date;

public class OrderDetail {
    /**
     * 唯一标识（主键）
     */
    private Integer detailId;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 产品类型id,：具体信息关联kz_product表
     */
    private Integer productId;

    /**
     * 购买数量
     */
    private Integer producNum;

    /**
     * 订单金额
     */
    private Long orderAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人标识
     */
    private Integer createId;

    /**
     * 创建人名称
     */
    private String createName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 唯一标识（主键）
     * @return detail_id 唯一标识（主键）
     */
    public Integer getDetailId() {
        return detailId;
    }

    /**
     * 唯一标识（主键）
     * @param detailId 唯一标识（主键）
     */
    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    /**
     * 订单编号
     * @return order_id 订单编号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单编号
     * @param orderId 订单编号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 产品类型id,：具体信息关联kz_product表
     * @return product_id 产品类型id,：具体信息关联kz_product表
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 产品类型id,：具体信息关联kz_product表
     * @param productId 产品类型id,：具体信息关联kz_product表
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 购买数量
     * @return produc_num 购买数量
     */
    public Integer getProducNum() {
        return producNum;
    }

    /**
     * 购买数量
     * @param producNum 购买数量
     */
    public void setProducNum(Integer producNum) {
        this.producNum = producNum;
    }

    /**
     * 订单金额
     * @return order_amount 订单金额
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 订单金额
     * @param orderAmount 订单金额
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
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
     * 创建人标识
     * @return create_id 创建人标识
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 创建人标识
     * @param createId 创建人标识
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 创建人名称
     * @return create_name 创建人名称
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 创建人名称
     * @param createName 创建人名称
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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
        sb.append(", detailId=").append(detailId);
        sb.append(", orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", producNum=").append(producNum);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
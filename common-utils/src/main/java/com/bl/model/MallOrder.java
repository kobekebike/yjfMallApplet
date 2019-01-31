package com.bl.model;

import java.util.Date;

public class MallOrder {
    /**
     * 唯一标识（主键）
     */
    private Integer orderId;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 渠道客户标识（下单公司名称）
     */
    private Integer userId;

    /**
     * 备注留言
     */
    private String comment;

    /**
     * 付款流水
     */
    private Integer paymentId;

    /**
     * 订单金额
     */
    private Long orderAmount;

    /**
     * 发货时间
     */
    private Date sendTime;

    /**
     * 订单状态：未付款/已付款/已发货/取消
     */
    private Integer orderStatus;

    /**
     * 付款时间
     */
    private Date payTime;

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
     * 收件地址标识
     */
    private Integer addressId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 唯一标识（主键）
     * @return order_id 唯一标识（主键）
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 唯一标识（主键）
     * @param orderId 唯一标识（主键）
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 订单编号
     * @return order_num 订单编号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 订单编号
     * @param orderNum 订单编号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    /**
     * 渠道客户标识（下单公司名称）
     * @return user_id 渠道客户标识（下单公司名称）
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 渠道客户标识（下单公司名称）
     * @param userId 渠道客户标识（下单公司名称）
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 备注留言
     * @return comment 备注留言
     */
    public String getComment() {
        return comment;
    }

    /**
     * 备注留言
     * @param comment 备注留言
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * 付款流水
     * @return payment_id 付款流水
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     * 付款流水
     * @param paymentId 付款流水
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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
     * 发货时间
     * @return send_time 发货时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 发货时间
     * @param sendTime 发货时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 订单状态：未付款/已付款/已发货/取消
     * @return order_status 订单状态：未付款/已付款/已发货/取消
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态：未付款/已付款/已发货/取消
     * @param orderStatus 订单状态：未付款/已付款/已发货/取消
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 付款时间
     * @return pay_time 付款时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 付款时间
     * @param payTime 付款时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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
     * 收件地址标识
     * @return address_id 收件地址标识
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * 收件地址标识
     * @param addressId 收件地址标识
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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
        sb.append(", orderId=").append(orderId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", userId=").append(userId);
        sb.append(", comment=").append(comment);
        sb.append(", paymentId=").append(paymentId);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", sendTime=").append(sendTime);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", payTime=").append(payTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createId=").append(createId);
        sb.append(", createName=").append(createName);
        sb.append(", addressId=").append(addressId);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
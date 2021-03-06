package com.bl.model;

import java.math.BigDecimal;
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
     * 用户标识
     */
    private Integer userId;

    /**
     * 备注留言
     */
    private String remark;

    /**
     * 付款流水
     */
    private Integer paymentId;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 发货时间
     */
    private Date sendTime;

    /**
     * 订单状态：1未付款/2已付款/3已发货/4取消
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
     * 商品标识
     */
    private Integer productId;

    /**
     * 商品数量
     */
    private Integer productNum;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * 快递单号
     */
    private String expressNum;

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
     * 用户标识
     * @return user_id 用户标识
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户标识
     * @param userId 用户标识
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 备注留言
     * @return remark 备注留言
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注留言
     * @param remark 备注留言
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 订单金额
     * @param orderAmount 订单金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
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
     * 订单状态：1未付款/2已付款/3已发货/4取消
     * @return order_status 订单状态：1未付款/2已付款/3已发货/4取消
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态：1未付款/2已付款/3已发货/4取消
     * @param orderStatus 订单状态：1未付款/2已付款/3已发货/4取消
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

    /**
     * 商品标识
     * @return product_id 商品标识
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 商品标识
     * @param productId 商品标识
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 商品数量
     * @return product_num 商品数量
     */
    public Integer getProductNum() {
        return productNum;
    }

    /**
     * 商品数量
     * @param productNum 商品数量
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    /**
     * 快递公司
     * @return express_company 快递公司
     */
    public String getExpressCompany() {
        return expressCompany;
    }

    /**
     * 快递公司
     * @param expressCompany 快递公司
     */
    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    /**
     * 快递单号
     * @return express_num 快递单号
     */
    public String getExpressNum() {
        return expressNum;
    }

    /**
     * 快递单号
     * @param expressNum 快递单号
     */
    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum == null ? null : expressNum.trim();
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
        sb.append(", remark=").append(remark);
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
        sb.append(", productId=").append(productId);
        sb.append(", productNum=").append(productNum);
        sb.append(", expressCompany=").append(expressCompany);
        sb.append(", expressNum=").append(expressNum);
        sb.append("]");
        return sb.toString();
    }
}
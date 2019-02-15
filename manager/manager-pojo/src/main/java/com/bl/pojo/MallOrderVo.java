package com.bl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class MallOrderVo {
    /**
     * 唯一标识（主键）
     */
    private Integer orderId;

    /**
     * 订单编号
     */
    private String orderNum;

    /**
     * 备注留言
     */
    private String remark;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 商品数量
     */
    private Integer productNum;

    /**
     * 商品名称
     */
    private String productTitle;

    /**
     * 订单状态：未付款/已付款/已发货/取消
     */
    private Integer orderStatus;

    /**
     * 收件人
     */
    private String addressee;

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}

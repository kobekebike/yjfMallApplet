package com.bl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class MallOrderWXVo {
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
     * 产品描述
     */
    private String productDescribe;

    /**
     * 产品单价
     */
    private BigDecimal productPrice;

    /**
     * 是否启用：用于处理下架的产品（备用）
     */
    private Integer productStatus;

    /**
     * 商品类型
     */
    private String productType;

    /**
     * 商品折扣
     */
    private Integer productDiscount;

    /**
     * 商品主图（限制一张）
     */
    private String productFilePath;

    /**
     * 商品编号
     */
    private String productCode;

    /**
     * 商品标识
     */
    private Integer productId;

    /**
     * 是否选中,用于购物车的展示
     */
    private String selected;

    /**
     * 已售数量
     */
    private Integer soldOutNum;

    public Integer getSoldOutNum() {
        return soldOutNum;
    }

    public void setSoldOutNum(Integer soldOutNum) {
        this.soldOutNum = soldOutNum;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(Integer productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductFilePath() {
        return productFilePath;
    }

    public void setProductFilePath(String productFilePath) {
        this.productFilePath = productFilePath;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "MallOrderWXVo{" +
                "orderId=" + orderId +
                ", orderNum='" + orderNum + '\'' +
                ", remark='" + remark + '\'' +
                ", orderAmount=" + orderAmount +
                ", productNum=" + productNum +
                ", productTitle='" + productTitle + '\'' +
                ", orderStatus=" + orderStatus +
                ", productDescribe='" + productDescribe + '\'' +
                ", productPrice=" + productPrice +
                ", productStatus=" + productStatus +
                ", productType='" + productType + '\'' +
                ", productDiscount=" + productDiscount +
                ", productFilePath='" + productFilePath + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productId=" + productId +
                ", selected='" + selected + '\'' +
                ", soldOutNum=" + soldOutNum +
                '}';
    }
}

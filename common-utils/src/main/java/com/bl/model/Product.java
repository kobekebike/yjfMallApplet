package com.bl.model;

import java.math.BigDecimal;
import java.util.Date;

public class Product extends ProductKey {
    /**
     * 产品描述
     */
    private String productDescribe;

    /**
     * 产品单价
     */
    private BigDecimal productPrice;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建人标识
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否启用：用于处理下架的产品（备用）
     */
    private Integer productStatus;

    /**
     * 商品类型
     */
    private String productType;

    /**
     * 商品类型id
     */
    private Integer productTypeId;

    /**
     * 商品折扣
     */
    private Integer productDiscount;

    /**
     * 商品标题
     */
    private String productTitle;

    /**
     * 商品主图（限制一张）
     */
    private String productFilePath;

    /**
     * 商品排序
     */
    private Integer productSort;

    /**
     * 商品编号
     */
    private String productCode;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 产品描述
     * @return product_describe 产品描述
     */
    public String getProductDescribe() {
        return productDescribe;
    }

    /**
     * 产品描述
     * @param productDescribe 产品描述
     */
    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe == null ? null : productDescribe.trim();
    }

    /**
     * 产品单价
     * @return product_price 产品单价
     */
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    /**
     * 产品单价
     * @param productPrice 产品单价
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 创建人
     * @return create_name 创建人
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 创建人
     * @param createName 创建人
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
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
     * 是否启用：用于处理下架的产品（备用）
     * @return product_status 是否启用：用于处理下架的产品（备用）
     */
    public Integer getProductStatus() {
        return productStatus;
    }

    /**
     * 是否启用：用于处理下架的产品（备用）
     * @param productStatus 是否启用：用于处理下架的产品（备用）
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 商品类型
     * @return product_type 商品类型
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 商品类型
     * @param productType 商品类型
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    /**
     * 商品类型id
     * @return product_type_id 商品类型id
     */
    public Integer getProductTypeId() {
        return productTypeId;
    }

    /**
     * 商品类型id
     * @param productTypeId 商品类型id
     */
    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    /**
     * 商品折扣
     * @return product_discount 商品折扣
     */
    public Integer getProductDiscount() {
        return productDiscount;
    }

    /**
     * 商品折扣
     * @param productDiscount 商品折扣
     */
    public void setProductDiscount(Integer productDiscount) {
        this.productDiscount = productDiscount;
    }

    /**
     * 商品标题
     * @return product_title 商品标题
     */
    public String getProductTitle() {
        return productTitle;
    }

    /**
     * 商品标题
     * @param productTitle 商品标题
     */
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    /**
     * 商品主图（限制一张）
     * @return product_file_path 商品主图（限制一张）
     */
    public String getProductFilePath() {
        return productFilePath;
    }

    /**
     * 商品主图（限制一张）
     * @param productFilePath 商品主图（限制一张）
     */
    public void setProductFilePath(String productFilePath) {
        this.productFilePath = productFilePath == null ? null : productFilePath.trim();
    }

    /**
     * 商品排序
     * @return product_sort 商品排序
     */
    public Integer getProductSort() {
        return productSort;
    }

    /**
     * 商品排序
     * @param productSort 商品排序
     */
    public void setProductSort(Integer productSort) {
        this.productSort = productSort;
    }

    /**
     * 商品编号
     * @return product_code 商品编号
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 商品编号
     * @param productCode 商品编号
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
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
        sb.append(", productDescribe=").append(productDescribe);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", createName=").append(createName);
        sb.append(", createId=").append(createId);
        sb.append(", createTime=").append(createTime);
        sb.append(", productStatus=").append(productStatus);
        sb.append(", productType=").append(productType);
        sb.append(", productTypeId=").append(productTypeId);
        sb.append(", productDiscount=").append(productDiscount);
        sb.append(", productTitle=").append(productTitle);
        sb.append(", productFilePath=").append(productFilePath);
        sb.append(", productSort=").append(productSort);
        sb.append(", productCode=").append(productCode);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
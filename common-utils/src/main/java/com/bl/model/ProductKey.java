package com.bl.model;

public class ProductKey {
    /**
     * 唯一标识
     */
    private Integer productId;

    /**
     * 唯一标识
     * @return product_id 唯一标识
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 唯一标识
     * @param productId 唯一标识
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append("]");
        return sb.toString();
    }
}
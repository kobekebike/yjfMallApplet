package com.bl.model;

public class ProductWithBLOBs extends Product {
    /**
     * 商品详情（通过百度编辑器）
     */
    private byte[] productDetail;

    /**
     * 商品详情（通过百度编辑器）
     * @return product_detail 商品详情（通过百度编辑器）
     */
    public byte[] getProductDetail() {
        return productDetail;
    }

    /**
     * 商品详情（通过百度编辑器）
     * @param productDetail 商品详情（通过百度编辑器）
     */
    public void setProductDetail(byte[] productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productDetail=").append(productDetail);
        sb.append("]");
        return sb.toString();
    }
}
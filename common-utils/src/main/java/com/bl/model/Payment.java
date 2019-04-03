package com.bl.model;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    /**
     * 付款记录标识
     */
    private Integer paymentId;

    /**
     * 付款流水
     */
    private String paymentSerial;

    /**
     * 付款金额
     */
    private BigDecimal paymentAccount;

    /**
     * 付款时间
     */
    private Date paymentTime;

    /**
     * 订单集合
     */
    private String orderIds;

    /**
     * 支付方标识
     */
    private Integer payerId;

    /**
     * 支付方姓名
     */
    private String payerName;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 支付方式：1、微信支付，2、支付宝支付
     */
    private Integer payMethod;

    /**
     * 支付订单号
     */
    private String transactionId;

    /**
     * 下单金额，单位为分
     */
    private Integer totalFee;

    /**
     * 支付状态：0、未完成，1、已完成
     */
    private Integer payState;

    /**
     * 支付完成时间
     */
    private String payTimeEnd;

    /**
     * 用户端ip
     */
    private String clientIp;

    /**
     * 付款银行
     */
    private String bankType;

    /**
     * 设备号
     */
    private String deviceInfo;

    /**
     * 公众号标识：微信的用户标识
     */
    private String openId;

    /**
     * 是否关注公众账号
     */
    private String isSubscribe;

    /**
     * 交易类型：JSAPI、NATIVE、APP
     */
    private String tradeType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 付款记录标识
     * @return payment_id 付款记录标识
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     * 付款记录标识
     * @param paymentId 付款记录标识
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * 付款流水
     * @return payment_serial 付款流水
     */
    public String getPaymentSerial() {
        return paymentSerial;
    }

    /**
     * 付款流水
     * @param paymentSerial 付款流水
     */
    public void setPaymentSerial(String paymentSerial) {
        this.paymentSerial = paymentSerial == null ? null : paymentSerial.trim();
    }

    /**
     * 付款金额
     * @return payment_account 付款金额
     */
    public BigDecimal getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * 付款金额
     * @param paymentAccount 付款金额
     */
    public void setPaymentAccount(BigDecimal paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     * 付款时间
     * @return payment_time 付款时间
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * 付款时间
     * @param paymentTime 付款时间
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 订单集合
     * @return order_ids 订单集合
     */
    public String getOrderIds() {
        return orderIds;
    }

    /**
     * 订单集合
     * @param orderIds 订单集合
     */
    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds == null ? null : orderIds.trim();
    }

    /**
     * 支付方标识
     * @return payer_id 支付方标识
     */
    public Integer getPayerId() {
        return payerId;
    }

    /**
     * 支付方标识
     * @param payerId 支付方标识
     */
    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }

    /**
     * 支付方姓名
     * @return payer_name 支付方姓名
     */
    public String getPayerName() {
        return payerName;
    }

    /**
     * 支付方姓名
     * @param payerName 支付方姓名
     */
    public void setPayerName(String payerName) {
        this.payerName = payerName == null ? null : payerName.trim();
    }

    /**
     * 商户订单号
     * @return out_trade_no 商户订单号
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * 商户订单号
     * @param outTradeNo 商户订单号
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * 支付方式：1、微信支付，2、支付宝支付
     * @return pay_method 支付方式：1、微信支付，2、支付宝支付
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * 支付方式：1、微信支付，2、支付宝支付
     * @param payMethod 支付方式：1、微信支付，2、支付宝支付
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * 支付订单号
     * @return transaction_id 支付订单号
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 支付订单号
     * @param transactionId 支付订单号
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     * 下单金额，单位为分
     * @return total_fee 下单金额，单位为分
     */
    public Integer getTotalFee() {
        return totalFee;
    }

    /**
     * 下单金额，单位为分
     * @param totalFee 下单金额，单位为分
     */
    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * 支付状态：0、未完成，1、已完成
     * @return pay_state 支付状态：0、未完成，1、已完成
     */
    public Integer getPayState() {
        return payState;
    }

    /**
     * 支付状态：0、未完成，1、已完成
     * @param payState 支付状态：0、未完成，1、已完成
     */
    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    /**
     * 支付完成时间
     * @return pay_time_end 支付完成时间
     */
    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    /**
     * 支付完成时间
     * @param payTimeEnd 支付完成时间
     */
    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd == null ? null : payTimeEnd.trim();
    }

    /**
     * 用户端ip
     * @return client_ip 用户端ip
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * 用户端ip
     * @param clientIp 用户端ip
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    /**
     * 付款银行
     * @return bank_type 付款银行
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * 付款银行
     * @param bankType 付款银行
     */
    public void setBankType(String bankType) {
        this.bankType = bankType == null ? null : bankType.trim();
    }

    /**
     * 设备号
     * @return device_info 设备号
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * 设备号
     * @param deviceInfo 设备号
     */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim();
    }

    /**
     * 公众号标识：微信的用户标识
     * @return open_id 公众号标识：微信的用户标识
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 公众号标识：微信的用户标识
     * @param openId 公众号标识：微信的用户标识
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 是否关注公众账号
     * @return is_subscribe 是否关注公众账号
     */
    public String getIsSubscribe() {
        return isSubscribe;
    }

    /**
     * 是否关注公众账号
     * @param isSubscribe 是否关注公众账号
     */
    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe == null ? null : isSubscribe.trim();
    }

    /**
     * 交易类型：JSAPI、NATIVE、APP
     * @return trade_type 交易类型：JSAPI、NATIVE、APP
     */
    public String getTradeType() {
        return tradeType;
    }

    /**
     * 交易类型：JSAPI、NATIVE、APP
     * @param tradeType 交易类型：JSAPI、NATIVE、APP
     */
    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
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
        sb.append(", paymentId=").append(paymentId);
        sb.append(", paymentSerial=").append(paymentSerial);
        sb.append(", paymentAccount=").append(paymentAccount);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", orderIds=").append(orderIds);
        sb.append(", payerId=").append(payerId);
        sb.append(", payerName=").append(payerName);
        sb.append(", outTradeNo=").append(outTradeNo);
        sb.append(", payMethod=").append(payMethod);
        sb.append(", transactionId=").append(transactionId);
        sb.append(", totalFee=").append(totalFee);
        sb.append(", payState=").append(payState);
        sb.append(", payTimeEnd=").append(payTimeEnd);
        sb.append(", clientIp=").append(clientIp);
        sb.append(", bankType=").append(bankType);
        sb.append(", deviceInfo=").append(deviceInfo);
        sb.append(", openId=").append(openId);
        sb.append(", isSubscribe=").append(isSubscribe);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}
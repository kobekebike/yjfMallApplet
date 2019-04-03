package com.bl.service;

import com.bl.base.Response;
import com.bl.constants.Constant;
import com.bl.dao.MallOrderMapper;
import com.bl.dao.PaymentMapper;
import com.bl.dao.UserInfoMapper;
import com.bl.model.MallOrder;
import com.bl.model.Payment;
import com.bl.model.PaymentCriteria;
import com.bl.model.UserInfo;
import com.bl.utils.WeChatPayUtils.MyConfig;
import com.bl.utils.WeChatPayUtils.WXPay;
import com.bl.utils.WeChatPayUtils.WXPayConstants;
import com.bl.utils.WeChatPayUtils.WXPayUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

@Service
public class WeChatPayService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private MallOrderMapper mallOrderMapper;

    /**
     * 保存微信统一下单的信息
     * @param cip
     * @param total
     * @param discountTotal
     * @param userId
     * @param orderId
     * @return
     */
    public Response saveWeChatPayInfo(String cip, String total, String discountTotal, Integer userId, String[] orderId, String addressId) {
        Map<String,String> result = null;
        MyConfig myConfig = new MyConfig();
        Map<String,String> reqDataSign = new HashMap<String,String>();
        try {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
            if(userInfo != null){
                WXPay wxPay = new WXPay(myConfig);
                Map<String,String> reqData = new HashMap<String,String>();
                reqData.put("appid", myConfig.getAppID());
                reqData.put("mch_id", myConfig.getMchID());
    //			reqData.put("device_info", "WEB");
                reqData.put("nonce_str", WXPayUtil.generateNonceStr());
    //			reqData.put("sign_type", "");
                reqData.put("body", "亿吉芙-商品付款");
    //			reqData.put("detail", "");
    //			reqData.put("attach", "");
                String outTradeNoStr = WXPayUtil.getCurrentTimestampMs()+"" + new Random().nextInt(10000);
                reqData.put("out_trade_no", outTradeNoStr);
    //			reqData.put("fee_type", "");
                reqData.put("total_fee", total);
                reqData.put("spbill_create_ip", cip);
    //			reqData.put("time_start", "");
    //			reqData.put("time_expire", "");
    //			reqData.put("goods_tag", "");
                reqData.put("notify_url", "https://www.jfegf.com/wxPayResult/payResult.do");
                reqData.put("trade_type", "JSAPI");
    //			reqData.put("product_id", "");
    //			reqData.put("limit_pay", "");
                reqData.put("openid", userInfo.getOpenId());
    //			reqData.put("scene_info", "");
                WXPayUtil.getLogger().info("reqData {}", reqData);
                reqData.put("sign", WXPayUtil.generateSignature(reqData, myConfig.getKey(), WXPayConstants.SignType.MD5));
                result = wxPay.unifiedOrder(reqData);
                if("SUCCESS".equals(result.get("return_code")) && "SUCCESS".equals(result.get("result_code"))){
                    reqDataSign.put("appId", myConfig.getAppID());
                    String timeStamp = WXPayUtil.getCurrentTimestamp()+"";
                    reqDataSign.put("timeStamp", timeStamp);
                    String nonceStrSign = WXPayUtil.generateNonceStr();
                    reqDataSign.put("nonceStr", nonceStrSign);
                    reqDataSign.put("package", "prepay_id="+result.get("prepay_id"));
                    reqDataSign.put("signType", "MD5");
                    reqDataSign.put("paySign", WXPayUtil.generateSignature(reqDataSign, myConfig.getKey(), WXPayConstants.SignType.MD5));
                    WXPayUtil.getLogger().info("successSign {}", result);
    //				WXPayUtil.getLogger().info("twoSign {}", reqDataSign);
                    //保存支付表信息
                    Payment payment = new Payment();
                    payment.setPaymentSerial(timeStamp);
                    payment.setPaymentAccount(new BigDecimal(discountTotal));
                    payment.setOrderIds(StringUtils.join(orderId, ","));
                    payment.setPayerId(userInfo.getId());
                    payment.setPayMethod(Constant.PAY_METHOD_WX);//支付方式：1、微信支付，2、支付宝支付
                    payment.setTotalFee(Integer.valueOf(total));
                    payment.setPayState(Constant.PAY_STATE_UNFINISHED);//支付状态：0、未完成，1、已完成
                    payment.setClientIp(cip);
                    payment.setOpenId(userInfo.getOpenId());
                    payment.setCreateTime(new Date());
                    payment.setUpdateTime(new Date());
                    payment.setOutTradeNo(outTradeNoStr);
                    paymentMapper.insertSelective(payment);

                    MallOrder mallOrder = null;
                    for(String idStr : orderId){
                        mallOrder = new MallOrder();
                        mallOrder.setOrderId(Integer.valueOf(idStr));
                        mallOrder.setPaymentId(payment.getPaymentId());
                        mallOrder.setAddressId(Integer.valueOf(addressId));
                        mallOrder.setUpdateTime(new Date());
                        mallOrderMapper.updateByPrimaryKeySelective(mallOrder);
                    }

                    return Response.createSuccessResult("调起支付成功", reqDataSign);
                }else{
                    WXPayUtil.getLogger().info("failSign {}", result);
                    return Response.createFailResult("调起支付失败", null);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Response.createFailResult("调起支付失败", null);
    }

    /**
     * 处理接收到的微信推送的支付信息
     * @param request
     * @return
     */
    public String saveWxPayResultInfo(HttpServletRequest request) {
        InputStream inStream = null;
        try {
            inStream = request.getInputStream();
            int _buffer_size = 1024;
            if (inStream != null) {
                MyConfig config = new MyConfig();
                WXPay wxpay = new WXPay(config);
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] tempBytes = new byte[_buffer_size];
                int count = -1;
                while ((count = inStream.read(tempBytes, 0, _buffer_size)) != -1) {
                    outStream.write(tempBytes, 0, count);
                }
                tempBytes = null;
                //将流转换成字符串
                String result = new String(outStream.toByteArray(), "UTF-8");
                WXPayUtil.getLogger().info("支付回调通知xml: {}", result);
                outStream.flush();
                //将XML格式字符串转换为Map
                Map<String, String> notifyMap = WXPayUtil.xmlToMap(result);
                WXPayUtil.getLogger().info("支付回调通知map {}", notifyMap);

                //判断处理重复的通知
                String transactionId = notifyMap.get("transaction_id");//微信支付订单号
                if (StringUtils.isNotBlank(transactionId)) {
                    PaymentCriteria paymentCriteria = new PaymentCriteria();
                    paymentCriteria.createCriteria().andTransactionIdEqualTo(transactionId).andPayStateEqualTo(Constant.PAY_STATE_COMPLETED);
                    int i = paymentMapper.countByExample(paymentCriteria);
                    if (i > 0) {
                        return Constant.RESULT_SUCCESS;
                    }
                }

                //判断支付结果通知中的sign是否有效
                if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
                    // 签名正确
                    // 进行处理。
                    if ("SUCCESS".equals(notifyMap.get("return_code")) && "SUCCESS".equals(notifyMap.get("result_code"))) {
                        //判断订单号是否为空
                        if (StringUtils.isNotBlank(notifyMap.get("out_trade_no"))) {
                            PaymentCriteria paymentCriteria = new PaymentCriteria();
                            paymentCriteria.createCriteria().andOutTradeNoEqualTo(notifyMap.get("out_trade_no"));
                            List<Payment> paymentList = paymentMapper.selectByExample(paymentCriteria);
                            if(paymentList != null && !paymentList.isEmpty()){
                                Payment payment = paymentList.get(0);
                                //判断支付金额和订单金额是为空
                                if (StringUtils.isNotBlank(notifyMap.get("total_fee"))) {
                                    //判断支付金额和订单金额是否一致
                                    if ((payment.getTotalFee() + "").equals(notifyMap.get("total_fee"))) {
                                        //更新支付表
                                        payment.setPaymentTime(new Date());
                                        payment.setTransactionId(transactionId);
                                        payment.setPayState(Constant.PAY_STATE_COMPLETED);
                                        payment.setPayTimeEnd(notifyMap.get("time_end"));
                                        payment.setBankType(notifyMap.get("bank_type"));//付款银行
                                        payment.setDeviceInfo(notifyMap.get("device_info"));//设备号
                                        payment.setIsSubscribe(notifyMap.get("is_subscribe"));//是否关注公众号
                                        payment.setTradeType(notifyMap.get("trade_type"));//交易类型：JSAPI、NATIVE、APP
                                        payment.setUpdateTime(new Date());
                                        paymentMapper.updateByPrimaryKeySelective(payment);

                                        //通知微信支付系统接收到信息
                                        return Constant.RESULT_SUCCESS;
                                    } else {
                                        WXPayUtil.getLogger().info("支付回调通知 {}", "支付金额不等于订单金额");
                                        return Constant.RESULT_FAIL;
                                    }
                                } else {
                                    WXPayUtil.getLogger().info("支付回调通知 {}", "支付金额或订单金额为空");
                                    return Constant.RESULT_FAIL;
                                }
                            }
                        } else {
                            WXPayUtil.getLogger().info("支付回调通知 {}", "订单号为空");
                            return Constant.RESULT_FAIL;
                        }
                    }else{
                        WXPayUtil.getLogger().info("支付回调通知 {}", "支付失败");
                        return Constant.RESULT_FAIL;
                    }
                } else {
                    // 签名错误，如果数据里没有sign字段，也认为是签名错误
                    WXPayUtil.getLogger().info("支付回调通知 {}", "签名错误");
                    return Constant.RESULT_FAIL;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果失败返回错误，微信会再次发送支付信息
        return Constant.RESULT_FAIL;
    }
}

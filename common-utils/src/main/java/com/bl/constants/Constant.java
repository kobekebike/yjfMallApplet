package com.bl.constants;

/**
 * Created by michael on 2018/12/24.
 * 公用模块的常量类
 */
public class Constant {
    /**
     * 支付状态：1、已完成
     */
    public static final int PAY_STATE_COMPLETED = 1;
    /**
     * 支付状态：0、未完成
     */
    public static final int PAY_STATE_UNFINISHED = 0;

    /**
     * 支付方式：1、微信支付
     */
    public static final int PAY_METHOD_WX = 1;

    /**
     * 订单状态：
     *      2已付款，即支付成功后的状态
     */
    public static final int MALL_ORDER_STATUS_MONEY_RECEIPT = 2;
    /**
     * 订单状态：
     *      1未付款，即购物车的状态
     */
    public static final int MALL_ORDER_STATUS_NON_PAYMENT = 1;
    /**
     * 微信支付结果处理后返回值:成功
     */
    public static final String RESULT_SUCCESS = "<xml><return_code><![CDATA[SUCCESS]]></return_code>"+
            "<return_msg><![CDATA[OK]]></return_msg>"+
            "</xml>";
    /**
     * 微信支付结果处理后返回值:失败
     */
    public static final String RESULT_FAIL = "<xml><return_code><![CDATA[FAIL]]></return_code></xml>";
    /**
     * 成功
     */
    public static final String CODE_SUCCESS = "0";

    /**
     * 失败
     */
    public static final String CODE_FAIL = "1";

    /**
     * 静态路径
     */
    public static final String YJF_HOME = "D:/workspace/yjfhome";//远程阿里

    /**
     * 图片映射路径
     */
    public static final String IMAGE_URL = "https://www.jfegf.com/baseFileHome";
    //public static final String IMAGE_URL = "http://image.jfy.com";

}

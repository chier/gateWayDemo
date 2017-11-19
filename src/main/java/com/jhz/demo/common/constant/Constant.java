package com.jhz.demo.common.constant;


/**
 * 系统常量
 *
 * @author lsw
 * @date 2015-3-9
 * @vesion 1.0
 * @desc 简要说明
 */
public abstract class Constant {

    // 请求地址
//    public static final String HOST = "http://pay.hezhongpay.com";
    public static final String HOST = "http://localhost:8084";

    // 商户号
    public static final String MERCHANT_ID = "100210123196234";

    // 商户key
    public static final String MERCHANT_KEY = "25a49187-9e16-4a64-b927-4739777a1fc0";

    // 商户sescet
    public static final String MERCHANT_SECRET = "ef9fca6b-3c23-412e-8d28-291c8eef97ed";


    public static final String GATE_WAY_URL="/gate/way/order/down";

    public static final String ORDER_QUERY_URL="/order/query";


    //代付
    public static final String PROXY_PAY_URL = "/proxy/pay";

}

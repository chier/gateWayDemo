package com.jhz.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.jhz.demo.common.constant.Constant;
import com.jhz.demo.common.secure.SignUtils;
import com.jhz.demo.common.util.MakeOrderNum;
import com.jhz.demo.dto.CommonDto;
import com.jhz.demo.dto.GateWayDto;
import com.jhz.demo.dto.ProxyPayDto;
import com.jhz.demo.service.DemoService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 快捷支付测试用例
 * Created by lishi on 2017/11/8.
 */

public class DemoPayTestJunit extends BaseJunitTest {

    @Resource
    private DemoService demoService;

    /**
     * 查询订单
     *
     * @throws Exception
     */
    @Test
    public void testQuery() throws Exception {
        CommonDto dto = new CommonDto();
        dto.setMerchantId(Constant.MERCHANT_ID);
        dto.setOrderId("20171113163621061000");
        dto.setTimestamp(System.currentTimeMillis());
        dto.setMerchantKey(Constant.MERCHANT_KEY);
        JSONObject result = demoService.query(dto);
        logger.info("{}", result);

    }

    /**
     *
     * @throws Exception
     *
     */
    @Test
    public void gateWayPayTest() throws Exception {
        logger.info("网银支付下单 start");
        GateWayDto data=new GateWayDto();
        data.setOrderId(MakeOrderNum.makeOrderNum());//订单号
        data.setMerchantId(Constant.MERCHANT_ID);//商户号
        data.setTrxType(3);//结算 3,"D0"
        data.setAmount(50L);//交易金额  单位 分
        data.setType(2); // 2 借记卡
        data.setBankCode("CCB");
        data.setName("商户名称");
        data.setBody("商品名称");
        data.setMerchantKey(Constant.MERCHANT_KEY);//商户key
        data.setFrontUrl("http://pay.hezhongpay.com");//前台地址
        data.setNotifyUrl("http://pay.hezhongpay.com/notify");//通知url
        data.setTimestamp(System.currentTimeMillis());

        JSONObject jsonObject=demoService.gateWayPay(data);

        String signBefore = SignUtils.signBefore(jsonObject);
        String sign = SignUtils.sign(signBefore, Constant.MERCHANT_SECRET);
        if(jsonObject.getString("sign").equals(sign)){
            logger.info("签名正确 ");
        }else{
            logger.info("签名错误");
        }
        logger.info("jsonObject:{}", jsonObject);
        //根据 json 返回的 url域 值 响应浏览器 完成交易
    }

    /**
     * 代付
     *
     * @throws Exception
     */
    @Test
    public void proxyPay() throws Exception {
        ProxyPayDto dto = new ProxyPayDto();
        dto.setOrderId(UUID.randomUUID().toString());
        dto.setAmount(100L);
        dto.setMerchantId(Constant.MERCHANT_ID);
        dto.setTimestamp(System.currentTimeMillis());
        dto.setMerchantKey(Constant.MERCHANT_KEY);
        dto.setTrxType(3);//默认3
        dto.setNotifyUrl("http://www.baidu.com");
        dto.setAcctType(1);// 1对私  2对公
        dto.setType(2);//钱包类型 2 网关支付 8 微信  10 QQ钱包
        dto.setAcctName("黎士文");
        dto.setAcctNo("6217003760027926781");
        dto.setBankName("建设银行");
        dto.setBankSettNo("105653011188");
        dto.setBankCode("CCB");
        dto.setProvince("重庆");
        dto.setCity("重庆");
        dto.setCnapsName("中国建设银行股份有限公司重庆沙坪坝西永微电园支行");
        dto.setMobile("13206027068");
        dto.setCertificateCode("500236199307243418");

        JSONObject result = demoService.proxyPay(dto);
        logger.info("{}", result);
    }



}

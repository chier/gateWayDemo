package com.jhz.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.jhz.demo.common.constant.Constant;
import com.jhz.demo.common.secure.SignUtils;
import com.jhz.demo.common.util.Bean2Map;
import com.jhz.demo.common.util.HttpUtil;
import com.jhz.demo.dto.CommonDto;
import com.jhz.demo.dto.GateWayDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * DEMO
 * Created by lishi on 2017/11/8.
 */
@Service
public class DemoService {

    private Logger logger = LoggerFactory.getLogger(Logger.class);

    /**
     * 查询订单状态
     *
     * @param dto
     * @return
     * @throws Exception
     */
    public JSONObject query(CommonDto dto) throws Exception {
        Map<String, Object> params = Bean2Map.Entity2Map(dto);
        String signBefore = SignUtils.signBefore(params);
        String sign = SignUtils.sign(signBefore, Constant.MERCHANT_SECRET);
        params.put("sign", sign);
        String respStr = HttpUtil.post(Constant.HOST + Constant.ORDER_QUERY_URL, params);
        logger.info("respStr:{}", respStr);
        return JSONObject.parseObject(respStr);
    }


    public JSONObject gateWayPay(GateWayDto data) throws Exception {
        Map<String, Object> params = Bean2Map.Entity2Map(data);
        String signBefore = SignUtils.signBefore(params);
        logger.info("signBefore:{}", signBefore);
        String sign = SignUtils.sign(signBefore, Constant.MERCHANT_SECRET);
        params.put("sign", sign);
        String respStr = HttpUtil.post(Constant.HOST + Constant.GATE_WAY_URL, params);
        logger.info("respStr:{}", respStr);
        return JSONObject.parseObject(respStr);
    }

    /**
     * 代付
     *
     * @param dto
     * @return
     * @throws Exception
     */
    public JSONObject proxyPay(CommonDto dto) throws Exception {
        Map<String, Object> params = Bean2Map.Entity2Map(dto);
        String signBefore = SignUtils.signBefore(params);
        String sign = SignUtils.sign(signBefore, Constant.MERCHANT_SECRET);
        params.put("sign", sign);
        String respStr = HttpUtil.post(Constant.HOST + Constant.PROXY_PAY_URL, params);
        logger.info("respStr:{}", respStr);
        return JSONObject.parseObject(respStr);
    }
}

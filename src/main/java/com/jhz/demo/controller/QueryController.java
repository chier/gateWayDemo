package com.jhz.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.jhz.demo.dto.CommonDto;
import com.jhz.demo.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by lishi on 2017/11/8.
 */
@RequestMapping("query/order")
public class QueryController {

    @Resource
    private DemoService demoService;

    @RequestMapping(method = RequestMethod.POST)
    public Object qqPay(CommonDto dto) throws Exception {
        JSONObject result = demoService.query(dto);
        return result;
    }




}

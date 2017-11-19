package com.jhz.demo.controller;

import com.jhz.demo.common.constant.Constant;
import com.jhz.demo.dto.CommonDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lishi on 2017/9/10.
 */
@Controller
public class IndexController {

    /**
     *
     * @return
     */
    @RequestMapping( method = RequestMethod.GET)
    public String index(Model model) {
        CommonDto dto=new CommonDto();
        dto.setMerchantId(Constant.MERCHANT_ID);
        dto.setMerchantKey(Constant.MERCHANT_KEY);
        model.addAttribute("dto",dto);
        return "index";
    }


    @RequestMapping(value = "404", method = RequestMethod.GET)
    public String notFont() {
        return "common/404";
    }

    @RequestMapping(value = "500", method = RequestMethod.GET)
    public String serverError() {
        return "common/500";
    }


    /**
     * 没有权限访问
     *
     * @return
     */
    @RequestMapping(value = {"/unauthor"})
    public ModelAndView unauthor() {
        return new ModelAndView("common/error/unauthor");
    }

    /**
     * 跳转错误页面
     *
     * @return
     */
    @RequestMapping(value = {"/error"})
    public ModelAndView error() {
        return new ModelAndView("common/error/error");
    }

    @RequestMapping("empty")
    public String empty() {
        return "empty_page";
    }


}

package com.jhz.demo.common.util;

/**
 * Created by Tong on 2016/11/30.
 */
public class OilUtil {

    public static String oilNo2Type(String oilNo){
        if ("0093".equals(oilNo)){
            return "92#";
        }else if ("0097".equals(oilNo)){
            return "95#";
        }else if ("0000".equals(oilNo)){
            return "0#";
        }else if ("0010".equals(oilNo)){
            return "-10#";
        }else if ("0020".equals(oilNo)){
            return "-20#";
        }else if ("0035".equals(oilNo)){
            return "-35#";
        }else if ("0092".equals(oilNo)){
            return "92#";
        }else{
            return null;
        }
    }
}

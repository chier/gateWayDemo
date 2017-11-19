package com.jhz.demo.common.util;


import org.apache.commons.lang.StringUtils;

import java.text.DecimalFormat;

/**
 * 数学类
 * User: Jeff
 * Date: 15-6-10
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public class MathUtil {

    /**
     * 把单位为分的数据转换为元
     * @param fen
     * @return
     */
    public static Double fenToYuan(String fen){
         Double yuan = 0.0;
        if(StringUtils.isNotBlank(fen)){
            Double d = Double.parseDouble(fen);
            DecimalFormat df = new DecimalFormat("#.000000");
            yuan = Double.parseDouble(df.format(d/100));
        }
        return  yuan;
    }
    public static Double feilv(String fen){
        Double feilv = 0.0;
       if(StringUtils.isNotBlank(fen)){
           Double d = Double.parseDouble(fen);
           DecimalFormat df = new DecimalFormat("#.000000");
           feilv = Double.parseDouble(df.format(d*100));
       }
       return  feilv;
   }
}

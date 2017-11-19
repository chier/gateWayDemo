package com.jhz.demo.common.util;


import com.jhz.demo.common.date.DateUtil;

import java.util.Date;

/**
 * Created by lishi on 2017/11/1.
 */
public class MakeOrderNum {

    /**
     * 锁对象，可以为任意对象
     */
    private static Object lockObj = "lockerOrder";
    /**
     * 订单号生成计数器
     */
    private static long orderNumCount = 0L;
    /**
     * 每毫秒生成订单号数量最大值
     */
    private static int maxPerMSECSize=1000;
    /**
     * 订单号生成
     */
    public static String makeOrderNum() {
        String finOrderNum = "";
        try {
            // 最终生成的订单号
            synchronized (lockObj) {
                // 取系统当前时间作为订单号变量前半部分，精确到毫秒
                long nowLong = Long.parseLong(DateUtil.format2str(new Date(),"yyyyMMddHHmmssSSS"));
                // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
                if (orderNumCount >= maxPerMSECSize) {
                    orderNumCount = 0L;
                }
                //组装订单号
                String countStr=maxPerMSECSize +orderNumCount+"";
                finOrderNum=nowLong+countStr.substring(1);
                orderNumCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finOrderNum;
    }



    public static void main(String[] args) {
            System.out.println(makeOrderNum());
        System.out.println(makeOrderNum());
    }
}

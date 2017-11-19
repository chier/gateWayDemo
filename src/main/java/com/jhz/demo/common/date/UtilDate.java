
package com.jhz.demo.common.date;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* *
 *类名：UtilDate
 *功能：自定义订单类
 *详细：工具类，可以用作获取系统日期、订单编号等
 *版本：3.3
 *日期：2012-08-17
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class UtilDate {
    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String dtLong = "yyyyMMddHHmmss";
    /**
     * 年月日时分秒毫秒(无下划线) yyyyMMddHHmmssSSS
     */
    public static final String dateandtime = "yyyyMMddHHmmssSSS";

    /**
     * 完整时间 yyyy-MM-dd HH:mm:ss
     */
    public static final String simple = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日(无下划线) yyyyMMdd
     */
    public static final String dtShort = "yyyyMMdd";

    /**
     * 月日(无下划线) MMdd
     */
    public static final String monthDay = "MMdd";


    /**
     * 时间    HH:mm:ss
     */
    public static final String dtTime = "HH:mm:ss";
    /**
     * 时间    HHmmss
     */
    public static final String dateTime = "HHmmss";

    /**
     * 年月日 yyyy-MM-dd
     */
    public static final String dtDate = "yyyy-MM-dd";


    /**
     * 当前时间加减天数    加传正数减传负数
     *
     * @return 以yyyy-MM-dd为格式的时间
     */
    public static String getNewDate(int count) {
        Date date = new Date();
        date = new Date(date.getTime() + count * 24 * 60 * 60 * 1000);
        DateFormat df = new SimpleDateFormat(dtDate);
        return df.format(date);
    }


    /**
     * 返回系统当前时间(精确到毫秒)
     *
     * @return 以yyyyMMddHHmmssSSS为格式的当前系统时间
     */
    public static String getDateAndTimes() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dateandtime);
        return df.format(date);
    }


    /**
     * 返回系统当前时间,作为一个唯一的订单编号
     *
     * @return 以yyyyMMddHHmmss为格式的当前系统时间
     */
    public static String getTimeDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        return df.format(date);
    }

    /**
     * 获取系统当前日期(精确到毫秒)，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDateFormatter() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(simple);
        return df.format(date);
    }

    /**
     * 获取系统当期年月日(精确到天)，格式：yyyyMMdd
     *
     * @return
     */
    public static String getDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtShort);
        return df.format(date);
    }


    /**
     * 获取系统当期月日(精确到天)，格式：MMdd
     *
     * @return
     */
    public static String getMonthDay() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(monthDay);
        return df.format(date);
    }

    /**
     * 获取系统当期年月日(精确到天带下划线-)，格式：yyyy-MM-dd
     *
     * @return
     */
    public static String getDayDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtDate);
        return df.format(date);
    }


    /**
     * 获取系统时间，格式：HH:mm:ss
     *
     * @return
     */
    public static String getTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtTime);
        return df.format(date);
    }


    /**
     * 获取系统时间，格式：HHmmss
     *
     * @return
     */
    public static String getDateTime() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dateTime);
        return df.format(date);
    }


    /**
     * 产生随机的三位数
     *
     * @return
     */
    public static String getThree() {
        Random rad = new Random();
        return rad.nextInt(1000) + "";
    }

    /**
     * @param time
     * @return 将yyyy-MM-dd HH:mm:ss 转换为  yyyyMMddHHmmss
     */
    public static String transDate(String time) {
        String result = "";
        if (StringUtils.isNotBlank(time)) {
            result = time.replace("-", "").replace(":", "").replace(" ", "");
        }
        return result;
    }

    /**
     * 取得日期date以后某日的日期，如果要的得到以前的日期，参数传负值
     *
     * @param date 基准日期   days 要加的天数
     * @return
     */
    public static String addDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date).toString();
    }

    /**
     * 将日期字符串yyyyMMdd转换为格式 yyyy-MM-dd
     *
     * @param str
     * @return
     */
    public static String stringFormat(String str) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        return df.format(date);
    }


    /**
     * 将日期字符串转换日期为格式 yyyyMMdd
     *
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取开始时间和结束时间中间的时间字符串
     *
     * @return List<String>
     */
    public static List<String> getBetweenTwoDateAllDateString(String startdate, String enddate) {
        List<String> str = new ArrayList<String>();

        Date date1 = stringToDate(startdate);
        Date date2 = stringToDate(enddate);
        str.add(stringFormat(startdate));
        if (date2.getTime() == date1.getTime()) {

        } else {
            while (date2.getTime() > date1.getTime()) {
                date1 = stringToDate(startdate);
                startdate = addDay(date1, 1);
                str.add(stringFormat(startdate));
            }
            str.remove(str.size() - 1);
        }

        return str;
    }

    public static void main(String[] arg) {

        System.out.print(getBetweenTwoDateAllDateString("20141230", "20150102"));
    }


    /**
     * 是否在给定的分钟内
     *
     * @return
     * @defineTime 给定的时间
     */
    public static boolean isInDefiMinit(String defineTime, int minit) {
        if (minit < 0 || StringUtils.isBlank(defineTime)) {
            return false;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            try {
                Date d = sdf.parse(defineTime);

                if (System.currentTimeMillis() - d.getTime() > minit * 1000 * 60) {
                    return false;
                } else {
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }

        }
    }
}

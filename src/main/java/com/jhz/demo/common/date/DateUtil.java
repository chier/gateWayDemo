package com.jhz.demo.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lsw
 * @date 2016年1月3日
 * @version 1.0
 * @desc 日期工具类
 */
public class DateUtil {
	/**
	 * 将时间格式化成指定的字符串
	 * 
	 * @param date
	 * @param ftm
	 * @return
	 */
	public static String format2str(Date date, String ftm) {
		return new SimpleDateFormat(ftm).format(date);
	}

	/**
	 * 装字符串格式化成指定日期时间
	 * @param value
	 * @param fmt
     * @return
     */
	public static Date string2Date(String value,String fmt){
		try {
			return new SimpleDateFormat(fmt).parse(value);
		} catch (ParseException e) {
		}
		return new Date();
	}

}
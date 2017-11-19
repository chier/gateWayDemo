package com.jhz.demo.common.string;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * @author lsw
 * @version 1.0
 * @date 2015-3-14
 * @desr 字符串工具类
 */
public class StringUtil {
	/**
	 * 判断字符串为空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isBlank(String value) {
		return value == null || "".equals(value);
	}

	/**
	 * 判断字符串不为空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNotBlank(String value) {
		return !isBlank(value);
	}

	/**
	 * @param str
	 * @param split
	 * @return 去掉指定的字符
	 */
	public static String removeStr(String str, String split) {
		StringBuffer stringBuffer = new StringBuffer();
		String[] strs = str.split(split);
		for (int i = 0; i < strs.length; i++) {
			stringBuffer.append(strs[i]);
		}
		return stringBuffer.toString();
	}

	/**
	 * 截取字符串指定的串开始
	 * 
	 * @param str
	 * @param substr
	 * @return
	 */
	public static String getSubString(String str, String substr) {
		return str.substring(str.indexOf(substr), str.length());
	}

	/**
	 * 获取字符串编码
	 * 
	 * @param str
	 * @return
	 */
	public static String translate(String str) {
		String temp = "";
		try {
			temp = new String(str.getBytes("ISO-8859-1"), "GBK");
			temp = temp.trim();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return temp;
	}

	/**
	 * 拆分字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String stringBreak(String str) {
		String[] temp = str.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < temp.length; i++) {
			if (i != temp.length - 1) {
				sb.append("'" + temp[i] + "',");
			}else{
				sb.append("'" + temp[i] + "'");
			}
		}
		System.out.println(sb);
		return sb.toString();
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("isBlank:" + StringUtil.isBlank(""));
		System.out.println("isNotBlank:" + StringUtil.isNotBlank(""));
		System.out.println("isBlank:" + StringUtil.isBlank(null));
		System.out.println("isNotBlank:" + StringUtil.isNotBlank(null));
		System.out.println(StringUtil.removeStr(UUID.randomUUID().toString(),
				"-"));

		String str1 = ",ada,dasd,dad,1d,3d,";
		System.out.println(StringUtil.stringBreak(str1));
		String str = new String("zhangsan".getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(translate(str));
	}
}

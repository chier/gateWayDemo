package com.jhz.demo.common.string;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字 与 拼音的工具类
 * 
 * @author LiShiWen
 *         Id: PinYin4JUtil.java,v 1.2 2015年9月9日 cvsroot Exp
 */
public class PinYin4JUtil {

	private HanyuPinyinOutputFormat format = null;

	private String[] pinyin;

	public PinYin4JUtil() {
		format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		pinyin = null;
	}

	/**
	 * 将字符串转换成拼音
	 * 
	 * @param str
	 * @return
	 */
	public String string2Pinyin(String str) {
		StringBuilder sb = new StringBuilder();
		String tempPinyin = null;
		for (int i = 0; i < str.length(); ++i) {
			tempPinyin = char2Pinyin(str.charAt(i));
			if (tempPinyin == null) {
				// 如果str.charAt(i)非汉字，则保持原样
				sb.append(str.charAt(i));
			} else {
				sb.append(tempPinyin);
			}
		}
		return sb.toString();
	}

	/**
	 * 将单个文字转换成拼音
	 * 
	 * @param c
	 * @return
	 */
	public String char2Pinyin(char c) {
		try {
			pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		// 如果c不是汉字，toHanyuPinyinStringArray会返回null
		if (pinyin == null)
			return null;
		// 只取一个发音，如果是多音字，仅取第一个发音
		return pinyin[0];
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		PinYin4JUtil pin = new PinYin4JUtil();

		System.out.println("\"张三\"的拼音为:" + pin.string2Pinyin("张三"));

		System.out.println("\"长\"的拼音为：" + pin.char2Pinyin('长'));

		// String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray('单');
		//
		// for (int i = 0; i < pinyinArray.length; ++i) {
		// System.out.println(pinyinArray[i]);
		// }
	}
}

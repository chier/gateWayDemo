package com.jhz.demo.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fly on 2016/8/8.
 */
public class RegexUtil {


    /**
     * 邮箱格式验证
     * @param email
     * @return
     */
    public static boolean regEmail(String email){
        if(null==email || "".equals(email)){
            return false;
        }
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    /**
     * 手机格式验证
     * @param mobilePhone
     * @return
     */
    public static boolean regMobilePhone(String mobilePhone){
        if(null==mobilePhone || "".equals(mobilePhone)){
            return false;
        }
        //^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$
        Pattern p = Pattern.compile("^((?:13|15|18|14|17)\\d{9}|0(?:10|2\\d|[3-9]\\d{2})[1-9]\\d{6,7})$");
        Matcher m = p.matcher(mobilePhone);
        return m.matches();
    }

    /**
     * 6-18位字母数字密码
     * @param password
     * @return
     */
    public static boolean regPassword(String password){
        if(null==password || "".equals(password)){
            return false;
        }
        Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$");
        Matcher m = p.matcher(password);
        return m.matches();
    }
    
    /**
     * 数字类型
     * @param digital
     * @return
     */
    public static boolean regDigital(String digital){
        if(null==digital || "".equals(digital)){
            return false;
        }
        Pattern p = Pattern.compile("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+|\\+{0,1}[1-9]\\d*");
        Matcher m = p.matcher(digital);
        return m.matches();
    }

    /**
     * 身份证
     * @param id
     * @return
     */
	public static boolean regID(String id) {
		if (null == id || "".equals(id)) {
			return false;
		}
		Pattern p = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|x|X)$");
		Matcher m = p.matcher(id);
		return m.matches();
	}

}

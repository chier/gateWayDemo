package com.jhz.demo.common.util;


import com.jhz.demo.common.string.StringUtil;

import java.util.UUID;

/**
 * @author lsw
 * @data 2015-10-17
 * @version 1.0
 * @desc id 生成器
 */
public abstract class IdGenerate {
	/**
	 * 32位uuid
	 * 
	 * @return
	 */
	public static String random() {
		String id = StringUtil.removeStr(UUID.randomUUID().toString(), "-");
		return id;
	}
}

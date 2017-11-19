package com.jhz.demo.common.util;

import java.util.Random;

public class ProduceCodeUtil {

	/**
	 * 生成num位随机数
	 * @param num 
	 * @return
	 */
	public static String produceCode(int num) {
		Random random = new Random(System.currentTimeMillis());
		String result = "";
		for (int i = 0; i < num; i++) {
			result += random.nextInt(10);
		}
		return result;
	}

	public static void main(String[] args) {
		Random random = new Random(System.currentTimeMillis());
		System.out.print(random);
	}
	
}

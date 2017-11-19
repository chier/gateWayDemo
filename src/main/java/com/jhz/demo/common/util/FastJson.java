package com.jhz.demo.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


/*
 * @desc 测试类
 */
class Person {
	private String name;
	private String phone;

	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + "]";
	}

	public Person(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Person() {
		super();
	}
}

/**
 * @author lsw
 * @date 2015-3-20
 * @vesion 1.0
 * @desc 对象与json之间的转换
 * 
 */

public class FastJson {

	/**
	 * 对象转换成json串
	 * 
	 * @param objc
	 * @return
	 */
	public static String ojbToJSON(Object objc) {
		return JSON.toJSONString(objc);
	}

	/**
	 * json串转换成对象
	 * 
	 * @param val
	 * @return
	 */
	public static Object jsonStrToObj(String val, Class<?> clazz) {
		return JSON.parseObject(val, clazz);
	}

	/**
	 * 将集合转换成jsonStr
	 * 
	 * @return
	 */
	public static String listTOJsonStr(ArrayList<?> list) {
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			jsonArray.add(list.get(i));
		}
		return jsonArray.toString();
	}

	/**
	 * 将map转换成jsonStr
	 * 
	 * @return
	 */
	public static String mapTOJsonStr(Map<?, ?> map) {
		// jsonSerializerMap = new JSONSerializerMap();

		return null;
	}

	/**
	 * 将set转换成jsonStr
	 * 
	 * @return
	 */
	public static String setTOJsonStr(Set<?> set) {
		return null;
	}

	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// obj to str
		String jsonStr = ojbToJSON(new Person("", "110"));
		System.out.println(jsonStr);
		// str to ojb
		Person person = (Person) jsonStrToObj(jsonStr, Person.class);
		System.out.println(person);
		// list to jsonStr
		ArrayList<Person> arrayList = new ArrayList<Person>();
		arrayList.add(person);
		arrayList.add(person);
		System.out.println(listTOJsonStr(arrayList));
	}

	public static String ojb2JSON(boolean result) {
		return ""+result;
	}
}

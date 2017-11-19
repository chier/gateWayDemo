package com.jhz.demo.common.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description 将Map转换为Obj的工具类
 * @author Shiwen .Li
 * @date 2016年6月19日 下午6:54:09
 * @version V1.3.1
 */

public class Bean2Map {

	public static void Map2Entity(Map map, Object thisObj) {
		Set set = map.keySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			Object val = map.get(obj);
			setObjMethod(obj, val, thisObj);
		}
	}

	public static Map Entity2Map(Object thisObj) {
		Map map = new HashMap();
		Class c;
		try {
			c = Class.forName(thisObj.getClass().getName());
			Method[] m = c.getMethods();
			for (int i = 0; i < m.length; i++) {
				String method = m[i].getName();
				if (method.startsWith("get")) {
					try {
						Object value = m[i].invoke(thisObj);
						if (value != null) {
							String key = method.substring(3);
							if(key.toLowerCase().equals("class".toLowerCase())){
								continue;
							}
							key = key.substring(0, 1).toLowerCase()
									+ key.substring(1);
							map.put(key, value);
						}
					} catch (Exception e) {
						System.out.println("error:" + method);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	private static void setObjMethod(Object method, Object value, Object thisObj) {
		Class c;
		try {
			c = Class.forName(thisObj.getClass().getName());
			String met = (String) method;
			met = met.trim();
			if (!met.substring(0, 1).equals(met.substring(0, 1).toUpperCase())) {
				met = met.substring(0, 1).toUpperCase() + met.substring(1);
			}
			if (!String.valueOf(method).startsWith("set")) {
				met = "set" + met;
			}
			Class types[] = new Class[1];
			types[0] = Class.forName("java.lang.String");
			Method m = c.getMethod(met, types);
			m.invoke(thisObj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

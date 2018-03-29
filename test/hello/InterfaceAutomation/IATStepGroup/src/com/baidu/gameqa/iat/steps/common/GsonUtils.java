package com.baidu.gameqa.iat.steps.common;

import java.lang.reflect.Type;

import com.google.gson.Gson;

public class GsonUtils {
	private final static Gson gson = new Gson();

	/**
	 * @todo 将JSON字符串反序列化为JAVA对象
	 * @param json
	 *            String JSON字符串
	 * @param clazz
	 *            Class 类型
	 * @return Object 解组对象
	 * @throws Exception
	 *             异常
	 */
	public static Object deserialize(String json, Class<?> clazz) {
		return gson.fromJson(json, clazz);
	}

	/**
	 * 解析泛型
	 * 
	 * @param json
	 * @param type
	 * @return
	 */
	public static Object deserialize(String json, Type type) {
		return gson.fromJson(json, type);
	}

	/**
	 * @todo 将JAVA对象序列化为JSON字符串
	 * @param obj
	 *            JAVA对象
	 * @return String JSON字符串
	 * @throws Exception
	 *             异常
	 */
	public static String serialize(Object obj) {
		return gson.toJson(obj);
	}
}

package com.fei.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {
	public static Map<String, String> propertiesMap = new HashMap<>();

	static {
		Properties prop = new Properties();
		 ClassLoader classLoader = PropertiesUtils.class.getClassLoader();// 读取属性文件xxxxx.properties
         InputStream in = classLoader.getResourceAsStream("config.properties");
		try {
			prop.load(in);
			for (Entry<Object, Object> entry : prop.entrySet()) {
				propertiesMap.put(entry.getKey().toString(), entry.getValue().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

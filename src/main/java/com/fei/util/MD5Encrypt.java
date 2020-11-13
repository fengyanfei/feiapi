package com.fei.util;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5Encrypt {
	
	private static Logger logger = LoggerFactory.getLogger(MD5Encrypt.class);
	
	public MD5Encrypt() {
	}

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 *方法名:byteArrayToString()<br>
	 *描述:转换字节数组为16进制字符串<br>
	 *输入:BYTE[] 字节数组<br>
	 *返回值:STRING 16进制字符串<br>
	 *异常说明:NULL<br>
	 **/
	public static String byteArrayToString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			//若使用本函数转换则可得到加密结果的16进制表示，即数字字母混合的形式
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 *方法名:byteArrayToString()<br>
	 *描述:转换字节为正数字符串<br>
	 *输入:BYTE 字节<br>
	 *返回值:STRING 正数字符串<br>
	 *异常说明:NULL<br>
	 **/
	@SuppressWarnings("unused")
	private static String byteToNumString(byte b) {
		int _b = b;
		if (_b < 0) {
			_b = 256 + _b;
		}
		return String.valueOf(_b);
	}

	/**
	 *方法名:byteToHexString()<br>
	 *描述:转换字节为正数字符串<br>
	 *输入:BYTE 字节<br>
	 *返回值:STRING 16进制字符串<br>
	 *异常说明:NULL<br>
	 **/
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 *方法名:MD5Encode()<br>
	 *描述:取得MD5加密字符串（小写字符）<br>
	 *输入:STRING 需加密的字符串<br>
	 *返回值:STRING 加密后的字符串<br>
	 *异常说明:java.lang.Exception<br>
	 **/
	public static String MD5Encode(String origin) {
		String resultString = "";
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToString(md.digest(resultString.getBytes()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return resultString;
	}
	
	/**
	 *方法名:MD5Encode()<br>
	 *描述:取得MD5加密字符串（大写字符）<br>
	 *输入:STRING 需加密的字符串<br>
	 *输入:BOOLEAN 是否需要转换成大写，TRUE:是,FALSE:否<br>
	 *返回值:STRING 加密后的字符串<br>
	 *异常说明:java.lang.Exception<br>
	 **/
	public static String MD5Encode(String origin,boolean upCase ) {
		String resultString = "";
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToString(md.digest(resultString.getBytes()));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		if(upCase){
			return resultString.toUpperCase();
		}
		return resultString;
	}
}

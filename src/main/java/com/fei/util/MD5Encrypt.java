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
	 *������:byteArrayToString()<br>
	 *����:ת���ֽ�����Ϊ16�����ַ���<br>
	 *����:BYTE[] �ֽ�����<br>
	 *����ֵ:STRING 16�����ַ���<br>
	 *�쳣˵��:NULL<br>
	 **/
	public static String byteArrayToString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			//��ʹ�ñ�����ת����ɵõ����ܽ����16���Ʊ�ʾ����������ĸ��ϵ���ʽ
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 *������:byteArrayToString()<br>
	 *����:ת���ֽ�Ϊ�����ַ���<br>
	 *����:BYTE �ֽ�<br>
	 *����ֵ:STRING �����ַ���<br>
	 *�쳣˵��:NULL<br>
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
	 *������:byteToHexString()<br>
	 *����:ת���ֽ�Ϊ�����ַ���<br>
	 *����:BYTE �ֽ�<br>
	 *����ֵ:STRING 16�����ַ���<br>
	 *�쳣˵��:NULL<br>
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
	 *������:MD5Encode()<br>
	 *����:ȡ��MD5�����ַ�����Сд�ַ���<br>
	 *����:STRING ����ܵ��ַ���<br>
	 *����ֵ:STRING ���ܺ���ַ���<br>
	 *�쳣˵��:java.lang.Exception<br>
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
	 *������:MD5Encode()<br>
	 *����:ȡ��MD5�����ַ�������д�ַ���<br>
	 *����:STRING ����ܵ��ַ���<br>
	 *����:BOOLEAN �Ƿ���Ҫת���ɴ�д��TRUE:��,FALSE:��<br>
	 *����ֵ:STRING ���ܺ���ַ���<br>
	 *�쳣˵��:java.lang.Exception<br>
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

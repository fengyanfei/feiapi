package com.fei.util;

public class StringUtils {

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}
	
	public static boolean isEmpty(Object str) {
		return str == null ;
	}

	public static String numberToBig(int number) {
		String str[] = { "��", "һ", "��", "��", "��", "��", "��", "��", "��", "��", "ʮ" };
		return str[number];
	}

}

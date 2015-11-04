package com.android.base.utils;

/**
 * 字符串工具集
 * 
 * @author krubo
 *
 */
public class StringUtils {
	/**
	 * 字符串是否为空
	 * 
	 * @param str
	 * @return true 空
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 字符串trim后是否为空
	 * 
	 * @param str
	 * @return true 空
	 */
	public static boolean isEmptyByTrim(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}
}

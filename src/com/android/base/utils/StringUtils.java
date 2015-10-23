package com.android.base.utils;

/**
 * ×Ö·û´®¹¤¾ß¼¯
 * 
 * @author krubo
 *
 */
public class StringUtils {
	/**
	 * ×Ö·û´®ÊÇ·ñÎª¿Õ
	 * 
	 * @param str
	 * @return true ¿Õ
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * ×Ö·û´®trimºóÊÇ·ñÎª¿Õ
	 * 
	 * @param str
	 * @return true ¿Õ
	 */
	public static boolean isEmptyByTrim(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}
}

package com.android.base.utils;

/**
 * �ַ������߼�
 * 
 * @author krubo
 *
 */
public class StringUtils {
	/**
	 * �ַ����Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return true ��
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * �ַ���trim���Ƿ�Ϊ��
	 * 
	 * @param str
	 * @return true ��
	 */
	public static boolean isEmptyByTrim(String str) {
		if (str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}
}

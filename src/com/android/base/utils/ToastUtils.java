package com.android.base.utils;

import com.android.base.ConstantBase;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtils
 * 
 * @author krubo
 *
 */
public class ToastUtils {

	private static void show(Context context, CharSequence text, int duration, boolean showMust) {
		if (showMust || ConstantBase.DEBUG_TOAST) {
			Toast.makeText(context, text, duration).show();
		}
	}

	private static void show(Context context, int resId, int duration, boolean showMust) {
		if (showMust || ConstantBase.DEBUG_TOAST) {
			Toast.makeText(context, resId, duration).show();
		}
	}

	/**
	 * 必须显示，时间短
	 * 
	 * @param context
	 * @param resId
	 */
	public static void showMustShort(Context context, int resId) {
		show(context, resId, Toast.LENGTH_SHORT, true);
	}

	/**
	 * 必须显示，时间短
	 * 
	 * @param context
	 * @param text
	 */
	public static void showMustShort(Context context, CharSequence text) {
		show(context, text, Toast.LENGTH_SHORT, true);
	}

	/**
	 * 必须显示，时间长
	 * 
	 * @param context
	 * @param resId
	 */
	public static void showMustLong(Context context, int resId) {
		show(context, resId, Toast.LENGTH_LONG, true);
	}

	/**
	 * 必须显示，时间长
	 * 
	 * @param context
	 * @param text
	 */
	public static void showMustLong(Context context, CharSequence text) {
		show(context, text, Toast.LENGTH_LONG, true);
	}

	/**
	 * 非必须显示，时间短
	 * 
	 * @param context
	 * @param resId
	 */
	public static void showShort(Context context, int resId) {
		show(context, resId, Toast.LENGTH_SHORT, false);
	}

	/**
	 * 非必须显示，时间短
	 * 
	 * @param context
	 * @param text
	 */
	public static void showShort(Context context, CharSequence text) {
		show(context, text, Toast.LENGTH_SHORT, false);
	}

	/**
	 * 非必须显示，时间长
	 * 
	 * @param context
	 * @param resId
	 */
	public static void showLong(Context context, int resId) {
		show(context, resId, Toast.LENGTH_LONG, false);
	}

	/**
	 * 非必须显示，时间长
	 * 
	 * @param context
	 * @param text
	 */
	public static void showLong(Context context, CharSequence text) {
		show(context, text, Toast.LENGTH_LONG, false);
	}
}

package com.android.base.utils;

import com.android.base.ConstantBase;

import android.content.Context;
import android.util.Log;

/**
 * LogUtils
 * 
 * @author krubo
 *
 */
public class LogUtils {

	public static void v(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.v(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void v(Context context, int resId) {
		v(context.getString(resId));
	}

	public static void d(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.d(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void d(Context context, int resId) {
		d(context.getString(resId));
	}

	public static void i(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.i(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void i(Context context, int resId) {
		i(context.getString(resId));
	}

	public static void w(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.w(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void w(Context context, int resId) {
		w(context.getString(resId));
	}

	public static void e(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.e(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void e(Context context, int resId) {
		e(context.getString(resId));
	}
}

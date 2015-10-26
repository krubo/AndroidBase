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
		if (ConstantBase.DEBUG_LOG) {
			v(context.getString(resId));
		}
	}

	public static void d(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.d(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void d(Context context, int resId) {
		if (ConstantBase.DEBUG_LOG) {
			d(context.getString(resId));
		}
	}

	public static void i(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.i(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void i(Context context, int resId) {
		if (ConstantBase.DEBUG_LOG) {
			i(context.getString(resId));
		}
	}

	public static void w(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.w(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void w(Context context, int resId) {
		if (ConstantBase.DEBUG_LOG) {
			w(context.getString(resId));
		}
	}

	public static void e(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			Log.e(ConstantBase.LOG_TAG, msg);
		}
	}

	public static void e(Context context, int resId) {
		if (ConstantBase.DEBUG_LOG) {
			e(context.getString(resId));
		}
	}
}

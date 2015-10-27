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

	private static String className;
	private static String methodName;
	private static int lineNumber;

	private static String createLog(String log) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(methodName);
		buffer.append("(").append(className).append(":").append(lineNumber).append(")");
		buffer.append(log);
		return buffer.toString();
	}

	private static void getMethodNames(StackTraceElement[] sElements) {
		className = sElements[1].getFileName();
		methodName = sElements[1].getMethodName();
		lineNumber = sElements[1].getLineNumber();
	}

	public static void v(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			getMethodNames(new Throwable().getStackTrace());
			Log.v(className, createLog(msg));
		}
	}

	public static void v(Context context, int resId) {
		v(context.getString(resId));
	}

	public static void d(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			getMethodNames(new Throwable().getStackTrace());
			Log.d(className, createLog(msg));
		}
	}

	public static void d(Context context, int resId) {
		d(context.getString(resId));
	}

	public static void i(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			getMethodNames(new Throwable().getStackTrace());
			Log.i(className, createLog(msg));
		}
	}

	public static void i(Context context, int resId) {
		i(context.getString(resId));
	}

	public static void w(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			getMethodNames(new Throwable().getStackTrace());
			Log.w(className, createLog(msg));
		}
	}

	public static void w(Context context, int resId) {
		w(context.getString(resId));
	}

	public static void e(String msg) {
		if (ConstantBase.DEBUG_LOG) {
			getMethodNames(new Throwable().getStackTrace());
			Log.e(className, createLog(msg));
		}
	}

	public static void e(Context context, int resId) {
		e(context.getString(resId));
	}

	public static void wtf(String message) {
		if (ConstantBase.DEBUG_LOG) {
			getMethodNames(new Throwable().getStackTrace());
			Log.wtf(className, createLog(message));
		}
	}

	public static void wtf(Context context, int resId) {
		wtf(context.getString(resId));
	}

}

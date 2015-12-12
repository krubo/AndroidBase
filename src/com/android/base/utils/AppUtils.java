package com.android.base.utils;

import com.android.base.AppData;
import com.android.base.R;
import com.android.base.dialog.ExitAppDialog;
import com.android.base.dialog.ExitAppDialogV4;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;

public class AppUtils {

	private static String EXIT_APP_DIALOG_TAG = "exit_app_dialog_tag";
	private static long LAST_CLICK_TIME = 0;
	private static long CLICK_SPACE_TIME = 1000;

	/**
	 * 退出程序
	 */
	public static void exitApp() {
		AppData.getInstance().finishAllActivity();
		System.exit(0);
	}

	/**
	 * 退出程序
	 * 
	 * @param activity
	 */
	public static void exitAppWithDialog(Activity activity) {
		android.app.FragmentManager manager = activity.getFragmentManager();
		ExitAppDialog dialog = (ExitAppDialog) manager.findFragmentByTag(EXIT_APP_DIALOG_TAG);
		if (dialog == null) {
			dialog = new ExitAppDialog();
		}
		if (!dialog.isAdded()) {
			dialog.show(manager, EXIT_APP_DIALOG_TAG);
		}
	}

	/**
	 * 退出程序
	 * 
	 * @param activity
	 */
	public static void exitAppWithDialogV4(FragmentActivity activity) {
		android.support.v4.app.FragmentManager manager = activity.getSupportFragmentManager();
		ExitAppDialogV4 dialog = (ExitAppDialogV4) manager.findFragmentByTag(EXIT_APP_DIALOG_TAG);
		if (dialog == null) {
			dialog = new ExitAppDialogV4();
		}
		if (!dialog.isAdded()) {
			dialog.show(manager, EXIT_APP_DIALOG_TAG);
		}
	}

	/**
	 * 退出程序
	 * 
	 * @param context
	 */
	public static void exitAppWithToast(Context context) {
		context = context.getApplicationContext();
		long currentTime = System.currentTimeMillis();
		if (currentTime - LAST_CLICK_TIME <= CLICK_SPACE_TIME) {
			exitApp();
		} else {
			ToastUtils.showMustShort(context,
					context.getString(R.string.exit_app_click_again) + context.getString(R.string.app_name));
		}
		LAST_CLICK_TIME = currentTime;
	}

	/**
	 * 退出程序
	 * 
	 * @param context
	 */
	public static void exitAppWithToastV4(Context context) {
		context = context.getApplicationContext();
		long currentTime = System.currentTimeMillis();
		if (currentTime - LAST_CLICK_TIME <= CLICK_SPACE_TIME) {
			exitApp();
		} else {
			ToastUtils.showMustShort(context,
					context.getString(R.string.exit_app_click_again) + context.getString(R.string.app_name));
		}
		LAST_CLICK_TIME = currentTime;
	}
}

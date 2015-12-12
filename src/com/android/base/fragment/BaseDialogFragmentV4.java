package com.android.base.fragment;

import com.android.base.listener.OnSingleClickListener;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * support v4 DialogFragment 基类
 * 
 * @author krubo
 *
 */
public abstract class BaseDialogFragmentV4 extends DialogFragment {
	protected FragmentActivity activity;
	protected Context context;
	protected View contentView;

	protected OnSingleClickListener OnSingleClickListener = new OnSingleClickListener() {

		@Override
		public void onSingleClickListener(View v) {
			onSingleClick(v);
		}
	};

	@Override
	public void onStart() {
		super.onStart();
		WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
		layoutParams = setLayoutParams(layoutParams);
		if (layoutParams != null) {
			getDialog().getWindow().setAttributes(layoutParams);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.activity = getActivity();
		this.context = getActivity().getApplicationContext();
		beforeInitView(savedInstanceState);
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		contentView = inflater.inflate(setLayout(), null);
		initView();
		afterInitView();
		return contentView;
	}

	/**
	 * onConfigurationChanged the package:android.content.res.Configuration.
	 * 
	 * @param newConfig,
	 *            The new device configuration.
	 *            当设备配置信息有改动（比如屏幕方向的改变，实体键盘的推开或合上等）时，
	 *            并且如果此时有activity正在运行，系统会调用这个函数。
	 *            注意：onConfigurationChanged只会监测应用程序在AnroidMainifest.xml中通过
	 *            android:configChanges="xxxx"指定的配置类型的改动；
	 *            而对于其他配置的更改，则系统会onDestroy()当前Activity，然后重启一个新的Activity实例。
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			// 当前为横屏， 在此处添加额外的处理代码
			if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
				// 实体键盘处于推出状态，在此处添加额外的处理代码
				landscape(false);
			} else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
				// 实体键盘处于合上状态，在此处添加额外的处理代码
				landscape(true);
			}
		} else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			// 当前为竖屏，在此处添加额外的处理代码
			if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
				// 实体键盘处于推出状态，在此处添加额外的处理代码
				portrait(false);
			} else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
				// 实体键盘处于合上状态，在此处添加额外的处理代码
				portrait(true);
			}
		}
	}

	/**
	 * 设置弹窗相关属性，如位置，动画等
	 * 
	 * @param layoutParams
	 * @return
	 */
	protected WindowManager.LayoutParams setLayoutParams(WindowManager.LayoutParams layoutParams) {
		return layoutParams;
	}

	/**
	 * 横屏
	 * 
	 * @param keyboard
	 *            true软键盘合上状态
	 */
	public abstract void landscape(boolean keyboard);

	/**
	 * 竖屏
	 * 
	 * @param keyboard
	 *            true软键盘合上状态
	 */
	public abstract void portrait(boolean keyboard);

	/**
	 * 短时间内只有一个控件被点击有效
	 * 
	 * @param v
	 */
	public abstract void onSingleClick(View v);

	/**
	 * 初始化控件
	 * 
	 * @param view
	 *            布局
	 * @param id
	 *            控件Id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends View> T findView(int id) {
		return (T) contentView.findViewById(id);
	}

	/**
	 * 设置布局id
	 * 
	 * @return
	 */
	public abstract int setLayout();

	/**
	 * 设置布局前操作
	 * 
	 * @param savedInstanceState
	 */
	public abstract void beforeInitView(Bundle savedInstanceState);

	/**
	 * 初始化控件
	 */
	public abstract void initView();

	/**
	 * 初始化控件后操作
	 */
	public abstract void afterInitView();
}

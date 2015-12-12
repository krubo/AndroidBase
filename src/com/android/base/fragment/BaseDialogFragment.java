package com.android.base.fragment;

import com.android.base.listener.OnSingleClickListener;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * DialogFragment 基类
 * 
 * @author krubo
 *
 */
public abstract class BaseDialogFragment extends DialogFragment {
	protected Activity activity;
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
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		beforeInitView(savedInstanceState);
		contentView = inflater.inflate(setLayout(), null);
		initView();
		afterInitView();
		return contentView;
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

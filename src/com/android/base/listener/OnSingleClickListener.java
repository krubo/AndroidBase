package com.android.base.listener;

import com.android.base.R;
import com.android.base.utils.ToastUtils;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 规定时间内只能有一个控件被点击
 * 
 * @author krubo
 *
 */
public abstract class OnSingleClickListener implements OnClickListener {

	private long lastTime;
	private static long SPACE_TIME = 1500;

	@Override
	public void onClick(View v) {
		long currentTime = System.currentTimeMillis();
		if (currentTime - lastTime < SPACE_TIME) {
			ToastUtils.showMustShort(v.getContext(), R.string.single_click);
		} else {
			onSingleClickListener(v);
		}
		lastTime = currentTime;
	}

	public abstract void onSingleClickListener(View v);

}

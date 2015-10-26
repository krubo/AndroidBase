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
	private static long SPACE_TIME = 5 * 1000;

	@Override
	public void onClick(View v) {
		long currentTime = System.currentTimeMillis();
		if (lastTime == 0 || currentTime - lastTime < SPACE_TIME) {
			ToastUtils.showMustShort(v.getContext(), R.string.single_click);
		} else {
			onSingleClick(v);
		}
		lastTime = currentTime;
	}

	public abstract void onSingleClick(View v);

}

package com.android.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

public abstract class UIButton extends Button {
	public UIButton(Context context) {
		super(context);
	}

	public UIButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UIButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@SuppressLint("NewApi")
	public UIButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}
}

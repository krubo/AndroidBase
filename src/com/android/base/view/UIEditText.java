package com.android.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public abstract class UIEditText extends EditText {
	public UIEditText(Context context) {
		super(context);
	}

	public UIEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UIEditText(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@SuppressLint("NewApi")
	public UIEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}
}

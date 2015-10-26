package com.android.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class UITextView extends TextView {

	public UITextView(Context context) {
		super(context);
	}

	public UITextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UITextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@SuppressLint("NewApi")
	public UITextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

}

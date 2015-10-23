package com.android.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public abstract class BaseActivity extends Activity implements OnSingleClickLinstener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		beforeInitView(savedInstanceState);
		setContentView(setLayout());
		initView();
		afterInitView();
	}

	@Override
	public void onSingleClick(View v) {
		// TODO Auto-generated method stub

	}

	public abstract int setLayout();

	public abstract void beforeInitView(Bundle savedInstanceState);

	public abstract void initView();

	public abstract void afterInitView();
}

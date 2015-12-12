package com.android.base.dialog;

import com.android.base.R;
import com.android.base.fragment.BaseDialogFragmentV4;
import com.android.base.utils.AppUtils;

import android.os.Bundle;
import android.view.View;

/**
 * 退出程序弹窗 support v4
 * 
 * @author krubo
 *
 */
public class ExitAppDialogV4 extends BaseDialogFragmentV4 {

	@Override
	public void onSingleClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.dialog_exitapp_cancel:
			dismiss();
			break;
		case R.id.dialog_exitapp_certain:
			dismiss();
			AppUtils.exitApp();
			break;
		default:
			break;
		}
	}

	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.dialog_exitapp;
	}

	@Override
	public void beforeInitView(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getDialog().setTitle(R.string.reminder);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		findView(R.id.dialog_exitapp_cancel).setOnClickListener(OnSingleClickListener);
		findView(R.id.dialog_exitapp_certain).setOnClickListener(OnSingleClickListener);
	}

	@Override
	public void afterInitView() {
		// TODO Auto-generated method stub

	}

}

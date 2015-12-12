package com.android.test;

import com.android.base.R;
import com.android.base.fragment.BaseDialogFragment;
import com.android.base.utils.ToastUtils;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;

public class TestDialog extends BaseDialogFragment {

	private EditText et_content;

	@Override
	protected LayoutParams setLayoutParams(LayoutParams layoutParams) {
		// TODO Auto-generated method stub
		layoutParams.gravity = Gravity.BOTTOM;
		layoutParams.windowAnimations = R.style.style_dialog_test_anim;
		return super.setLayoutParams(layoutParams);
	}

	@Override
	public void onSingleClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.dialog_cancel:
			dismiss();
			break;
		case R.id.dialog_certain:
			ToastUtils.showMustShort(context, "内容:" + et_content.getText().toString());
			dismiss();
			break;
		default:
			break;
		}
	}

	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.dialog_test;
	}

	@Override
	public void beforeInitView(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getDialog().setTitle("弹窗");
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		et_content = findView(R.id.dialog_edit);
		findView(R.id.dialog_cancel).setOnClickListener(OnSingleClickListener);
		findView(R.id.dialog_certain).setOnClickListener(OnSingleClickListener);
	}

	@Override
	public void afterInitView() {
		// TODO Auto-generated method stub

	}

}

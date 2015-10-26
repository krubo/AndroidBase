package com.android.base.activity;

import com.android.base.listener.OnSingleClickListener;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * FragmentActivity ���࣬����OnTouchLinstener�����һ��˳�
 * 
 * @author krubo
 *
 */
public abstract class BaseFragmentActivity extends FragmentActivity implements OnTouchListener, OnGestureListener {

	protected Activity activity;
	protected Context context;
	private GestureDetector gestureDetector;

	protected OnSingleClickListener OnSingleClickListener = new OnSingleClickListener() {

		@Override
		public void onSingleClick(View v) {
			// TODO Auto-generated method stub
			onSingleClick(v);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.activity = this;
		this.context = getApplicationContext();
		this.gestureDetector = new GestureDetector(this.context, this);
		beforeInitView(savedInstanceState);
		setContentView(setLayout());
		initView();
		afterInitView();
	}

	/**
	 * onConfigurationChanged the package:android.content.res.Configuration.
	 * 
	 * @param newConfig,
	 *            The new device configuration.
	 *            ���豸������Ϣ�иĶ���������Ļ����ĸı䣬ʵ����̵��ƿ�����ϵȣ�ʱ��
	 *            ���������ʱ��activity�������У�ϵͳ��������������
	 *            ע�⣺onConfigurationChangedֻ����Ӧ�ó�����AnroidMainifest.xml��ͨ��
	 *            android:configChanges="xxxx"ָ�����������͵ĸĶ���
	 *            �������������õĸ��ģ���ϵͳ��onDestroy()��ǰActivity��Ȼ������һ���µ�Activityʵ����
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			// ��ǰΪ������ �ڴ˴���Ӷ���Ĵ������
			if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
				// ʵ����̴����Ƴ�״̬���ڴ˴���Ӷ���Ĵ������
				landscape(false);
			} else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
				// ʵ����̴��ں���״̬���ڴ˴���Ӷ���Ĵ������
				landscape(true);
			}
		} else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			// ��ǰΪ�������ڴ˴���Ӷ���Ĵ������
			if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
				// ʵ����̴����Ƴ�״̬���ڴ˴���Ӷ���Ĵ������
				portrait(false);
			} else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
				// ʵ����̴��ں���״̬���ڴ˴���Ӷ���Ĵ������
				portrait(true);
			}
		}
	}

	/**
	 * ����
	 * 
	 * @param keyboard
	 *            true����̺���״̬
	 */
	public abstract void landscape(boolean keyboard);

	/**
	 * ����
	 * 
	 * @param keyboard
	 *            true����̺���״̬
	 */
	public abstract void portrait(boolean keyboard);

	/**
	 * ��ʱ����ֻ��һ���ؼ��������Ч
	 * 
	 * @param v
	 */
	public abstract void onSingleClick(View v);

	/**
	 * ��ʼ���ؼ�
	 * 
	 * @param id
	 *            �ؼ�Id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends View> T findView(int id) {
		return (T) findViewById(id);
	}

	/**
	 * ���ò���id
	 * 
	 * @return
	 */
	public abstract int setLayout();

	/**
	 * ���ò���ǰ����
	 * 
	 * @param savedInstanceState
	 */
	public abstract void beforeInitView(Bundle savedInstanceState);

	/**
	 * ��ʼ���ؼ�
	 */
	public abstract void initView();

	/**
	 * ��ʼ���ؼ������
	 */
	public abstract void afterInitView();

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		// TODO Auto-generated method stub
		if (Math.abs(velocityX) > Math.abs(velocityY) && e2.getX() - e1.getX() > 200 && Math.abs(velocityX) > 0) {
			finish();
		}
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}

}

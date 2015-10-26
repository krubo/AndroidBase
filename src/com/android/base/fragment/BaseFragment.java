package com.android.base.fragment;

import com.android.base.listener.OnSingleClickListener;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

/**
 * Fragment ���࣬����OnTouchLinstener�����һ��˳�
 * 
 * @author krubo
 *
 */
public abstract class BaseFragment extends Fragment implements OnTouchListener, OnGestureListener {

	protected Activity activity;
	protected Context context;
	protected View contentView;
	private GestureDetector gestureDetector;

	protected OnSingleClickListener OnSingleClickListener = new OnSingleClickListener() {

		@Override
		public void onSingleClick(View v) {
			onSingleClick(v);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.activity = getActivity();
		this.context = getActivity().getApplicationContext();
		this.gestureDetector = new GestureDetector(this.context, this);
		beforeInitView(savedInstanceState);
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		contentView = inflater.inflate(setLayout(), null);
		initView();
		afterInitView();
		return contentView;
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
	 * @param view
	 *            ����
	 * @param id
	 *            �ؼ�Id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends View> T findView(View view, int id) {
		return (T) view.findViewById(id);
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
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		if (Math.abs(velocityX) > Math.abs(velocityY) && e2.getX() - e1.getX() > 200 && Math.abs(velocityX) > 0) {
			activity.finish();
		}
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}

}

package com.android.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.base.R;
import com.android.base.db.DBManager;
import com.android.base.db.DBManagerInterface;
import com.android.base.http.HttpService;
import com.android.base.utils.AppUtils;
import com.android.base.utils.LogUtils;
import com.android.base.utils.ToastUtils;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends Activity {
	private TextView content;
	private PersonDao personDao;
	private Person xiaoming;
	private Person xiaohong;
	private TestDialog dialog;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AppUtils.exitAppWithDialog(this);
			// AppUtils.exitAppWithToast(this);
		}
		return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		content = (TextView) findViewById(R.id.content);
		findViewById(R.id.insert).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				personDao.insert(xiaoming);
				personDao.insert(xiaohong);
			}
		});
		findViewById(R.id.delete).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				personDao.delete(xiaoming);
				showToast("delete");
			}
		});
		findViewById(R.id.query).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				content.setText("");
				List<Person> list = personDao.query();
				for (Person person : list) {
					content.setText(content.getText().toString() + "\n\t" + person.toString());
				}
			}
		});
		DBManager.getInstance().init(this, "test_db", 1, new DBManagerInterface() {

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onCreate(SQLiteDatabase db) {
				// TODO Auto-generated method stub
				DBManager.createTable(Person.class, db);
			}
		});
		personDao = new PersonDao(Person.class);
		xiaoming = new Person();
		xiaoming.setName("小明");
		xiaoming.setSex(true);
		xiaoming.setAddr("海淀区");
		xiaoming.setAge(22);
		xiaoming.setGroup(1);
		xiaoming.setHeight(171.3f);
		xiaoming.setId((short) 1);
		xiaoming.setTime(System.currentTimeMillis());
		xiaoming.setWeight(68.123d);

		xiaohong = new Person();
		xiaohong.setName("小红");
		xiaohong.setSex(false);
		xiaohong.setAddr("朝阳区");
		xiaohong.setAge(24);
		xiaohong.setGroup(3);
		xiaohong.setHeight(161.9f);
		xiaohong.setId((short) 2);
		xiaohong.setTime(System.currentTimeMillis());
		xiaohong.setWeight(60.665d);
		findViewById(R.id.dialog).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (dialog == null) {
					dialog = (TestDialog) getFragmentManager().findFragmentByTag("testDialog");
					if (dialog == null) {
						dialog = new TestDialog();
					}
				}
				if (!dialog.isAdded()) {
					dialog.show(getFragmentManager(), "testDialog");
				}
			}
		});

		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", "ZhangSan");
		map.put("sex", "男");
		HttpService.getInstance().setBaseUrl("http://10.2.19.210:8080").getInterface(TestInterface.class).getData(map)
				.enqueue(new Callback<ResponeData<UserBean>>() {

					@Override
					public void onResponse(Response<ResponeData<UserBean>> response, Retrofit retrofit) {
						// TODO Auto-generated method stub
						if (response != null && response.body() != null) {
							LogUtils.i(response.body().toString());
						} else {
							LogUtils.i("request data null");
						}
					}

					@Override
					public void onFailure(Throwable t) {
						// TODO Auto-generated method stub
						LogUtils.i("request failure");
					}
				});
	}

	public void showToast(String text) {
		Toast result = new Toast(getApplicationContext());
		LayoutInflater inflate = (LayoutInflater) getApplicationContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflate.inflate(R.layout.toast_test, null);
		TextView tv = (TextView) v.findViewById(R.id.toast_msg);
		tv.setText(text);
		result.setView(v);
		result.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 20);
		result.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

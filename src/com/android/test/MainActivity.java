package com.android.test;

import java.util.List;

import com.android.base.R;
import com.android.base.db.DBManager;
import com.android.base.db.DBManagerInterface;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView content;
	private PersonDao personDao;
	private Person xiaoming;
	private Person xiaohong;

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
		xiaoming.setName("小明?,@#$%^&^*!");
		xiaoming.setSex(true);
		xiaoming.setAddr("海淀上地");
		xiaoming.setAge(22);
		xiaoming.setGroup(1);
		xiaoming.setHeight(171.3f);
		xiaoming.setId((short) 1);
		xiaoming.setTime(System.currentTimeMillis());
		xiaoming.setWeight(68.123d);

		xiaohong = new Person();
		xiaohong.setName("小红");
		xiaohong.setSex(false);
		xiaohong.setAddr("朝阳");
		xiaohong.setAge(24);
		xiaohong.setGroup(3);
		xiaohong.setHeight(161.9f);
		xiaohong.setId((short) 2);
		xiaohong.setTime(System.currentTimeMillis());
		xiaohong.setWeight(60.665d);

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

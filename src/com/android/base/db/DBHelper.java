package com.android.base.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库帮助类
 * 
 * @author krubo
 *
 */
public class DBHelper extends SQLiteOpenHelper {

	private DBManagerInterface dbManagerInterface;

	public void setDbManagerInterface(DBManagerInterface dbManagerInterface) {
		this.dbManagerInterface = dbManagerInterface;
	}

	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		if (dbManagerInterface != null) {
			dbManagerInterface.onCreate(db);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (dbManagerInterface != null) {
			dbManagerInterface.onUpgrade(db, oldVersion, newVersion);
		}
	}

}

package com.android.base.db;

import java.lang.reflect.Field;

import com.android.base.db.annotation.DBField;
import com.android.base.db.annotation.DBTableName;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 数据库操作类
 * 
 * @author krubo
 *
 */
public class DBManager {
	private static DBManager dbManager;
	private DBHelper dbHelper;
	private SQLiteDatabase db;

	private DBManager() {

	}

	public static DBManager getInstance() {
		if (dbManager == null) {
			dbManager = new DBManager();
		}
		return dbManager;
	}

	public void init(Context context, String name, int version, DBManagerInterface dbManagerInterface) {
		if (dbHelper == null) {
			dbHelper = new DBHelper(context, name, null, version);
			dbHelper.setDbManagerInterface(dbManagerInterface);
			db = dbHelper.getWritableDatabase();
		}
	}

	public synchronized SQLiteDatabase getDb() {
		return db;
	}

	/**
	 * 创建表
	 * 
	 * @param cls
	 * @param db
	 */
	public static void createTable(Class<?> cls, SQLiteDatabase db) {
		if (db != null) {
			Field[] fields = cls.getDeclaredFields();
			Field.setAccessible(fields, true);
			String sql = "CREATE TABLE " + cls.getAnnotation(DBTableName.class).tableName() + " (";
			boolean isFirst = true;
			for (Field field : fields) {
				if (field.getAnnotation(DBField.class) != null) {
					if (isFirst) {
						sql = sql + field.getName() + " varchar(100)";
						isFirst = false;
					} else {
						sql = sql + "," + field.getName() + " varchar(100)";
					}
				}
			}
			if (isFirst) {
				return;
			}
			sql = sql + ");";
			db.execSQL(sql);
		}
	}

}

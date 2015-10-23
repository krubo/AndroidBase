package com.android.base.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * 数据库操作类接口
 * 
 * @author krubo
 *
 */
public interface DBManagerInterface {

	/**
	 * 版本升级
	 * 
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

	/**
	 * 创建数据库，创建表
	 * 
	 * @param db
	 */
	public void onCreate(SQLiteDatabase db);
}

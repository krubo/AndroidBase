package com.android.base.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * ���ݿ������ӿ�
 * 
 * @author krubo
 *
 */
public interface DBManagerInterface {

	/**
	 * �汾����
	 * 
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

	/**
	 * �������ݿ⣬������
	 * 
	 * @param db
	 */
	public void onCreate(SQLiteDatabase db);
}

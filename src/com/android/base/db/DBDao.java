package com.android.base.db;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.android.base.db.annotation.DBField;
import com.android.base.db.annotation.DBTableName;
import com.android.base.utils.StringUtils;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * ���ݿ��������DAO
 * 
 * @author krubo
 *
 */
public class DBDao<T> {

	protected SQLiteDatabase db;
	protected String table;
	protected Class<T> cls;

	public DBDao(Class<T> cls) {
		super();
		this.db = DBManager.getInstance().getDb();
		this.cls = cls;
		this.table = this.cls.getAnnotation(DBTableName.class).tableName();
	}

	/**
	 * ��ȡContentVlues
	 * 
	 * @param t
	 * @return
	 */
	protected ContentValues getContentVlues(T t) {
		Field[] fields = t.getClass().getDeclaredFields();
		Field.setAccessible(fields, true);
		ContentValues values = new ContentValues();
		for (Field field : fields) {
			if (field.getAnnotation(DBField.class) != null) {
				try {
					Object value = field.get(t);
					values.put(field.getName(), value == null ? "" : value + "");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return values;
	}

	/**
	 * ���뵥������
	 * 
	 * @param t
	 */
	public void insert(T t) {
		if (db != null && t != null) {
			ContentValues values = getContentVlues(t);
			db.insert(table, null, values);
		}
	}

	/**
	 * �����������
	 * 
	 * @param list
	 */
	public void insert(List<T> list) {
		if (list == null) {
			return;
		}
		for (T t : list) {
			insert(t);
		}
	}

	/**
	 * �޸ĵ�������
	 * 
	 * @param t
	 * @param whereClause
	 * @param whereArgs
	 */
	public void update(T t, String whereClause, String[] whereArgs) {
		if (db != null && t != null) {
			ContentValues values = getContentVlues(t);
			db.update(table, values, whereClause, whereArgs);
		}
	}

	/**
	 * ��������ȡ������
	 * 
	 * @param selection
	 * @param selectionArgs
	 * @param groupBy
	 * @param having
	 * @param orderBy
	 * @return
	 */
	public List<T> query(String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		List<T> list = new ArrayList<>();
		if (db != null) {
			Cursor cursor = null;
			try {
				cursor = db.query(table, null, selection, selectionArgs, groupBy, having, orderBy);
				while (cursor.moveToNext()) {
					T t = cls.newInstance();
					if (t == null) {
						continue;
					}
					Field[] fields = t.getClass().getDeclaredFields();
					Field.setAccessible(fields, true);
					for (Field field : fields) {
						if (field.getAnnotation(DBField.class) != null) {
							String type = field.getType().toString();
							String value = cursor.getString(cursor.getColumnIndex(field.getName()));
							if (type.endsWith("String")) {
								field.set(t, value + "");
							} else if (type.endsWith("boolean") || type.endsWith("Boolean")) {
								field.setBoolean(t, (value == null || value.equals("false") ? false : true));
							} else if (type.endsWith("int") || type.endsWith("Integer")) {
								field.setInt(t, StringUtils.isEmptyByTrim(value) ? 0 : Integer.valueOf(value));
							} else if (type.endsWith("float") || type.endsWith("Float")) {
								field.setFloat(t, StringUtils.isEmptyByTrim(value) ? 0 : Float.valueOf(value));
							} else if (type.endsWith("double") || type.endsWith("Double")) {
								field.setDouble(t, StringUtils.isEmptyByTrim(value) ? 0 : Double.valueOf(value));
							} else if (type.endsWith("long") || type.endsWith("Long")) {
								field.setLong(t, StringUtils.isEmptyByTrim(value) ? 0 : Long.valueOf(value));
							} else if (type.endsWith("short") || type.equals("Short")) {
								field.setShort(t, StringUtils.isEmptyByTrim(value) ? 0 : Short.valueOf(value));
							}
						}
					}
					list.add(t);
				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (cursor != null) {
				cursor.close();
			}
		}
		return list;
	}

	/**
	 * ȡ����������
	 * 
	 * @return
	 */
	public List<T> query() {
		return query(null, null, null, null, null);
	}

	/**
	 * ɾ����������
	 */
	public void deleteAll() {
		if (db != null) {
			db.delete(table, null, null);
		}
	}

	/**
	 * ��������ɾ������
	 * 
	 * @param whereClause
	 * @param whereArgs
	 */
	public void delete(String whereClause, String[] whereArgs) {
		if (db != null) {
			db.delete(table, whereClause, whereArgs);
		}
	}

	/**
	 * ����ʵ����ɾ������
	 * 
	 * @param t
	 */
	public void delete(T t) {
		if (t == null) {
			return;
		}
		Field[] fields = t.getClass().getDeclaredFields();
		Field.setAccessible(fields, true);
		String whereClause = "";
		List<String> whereArgs = new ArrayList<String>();
		boolean isFirst = true;
		for (Field field : fields) {
			if (field.getAnnotation(DBField.class) != null) {
				try {
					Object value = field.get(t);
					if (isFirst) {
						whereClause = field.getName() + "=?";
						isFirst = false;
					} else {
						whereClause = whereClause + " and " + field.getName() + "=?";
					}
					whereArgs.add(value == null ? "" : value + "");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (whereArgs.isEmpty()) {
			return;
		}
		delete(whereClause, (String[]) whereArgs.toArray(new String[0]));
	}

	/**
	 * ɾ����ǰ��
	 */
	public void dropTable() {
		if (db != null) {
			String sql = "DROP TABLE " + table;
			db.execSQL(sql);
		}
	}

	/**
	 * �����Ƿ�Ϊ��
	 * 
	 * @return true Ϊ��
	 */
	public boolean isEmptyTable() {
		// ����trueΪ�գ�
		boolean flag = true;
		if (db != null) {
			Cursor cursor = db.query(table, null, null, null, null, null, null);
			int x = cursor.getCount();
			cursor.close();
			if (x == 0) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

}

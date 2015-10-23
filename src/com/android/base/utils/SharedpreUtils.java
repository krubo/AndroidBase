package com.android.base.utils;

import java.util.Map;
import java.util.Set;

import com.android.base.ConstantBase;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * sharepreference
 * 
 * @author krubo
 *
 */
public class SharedpreUtils {
	public static SharedpreUtils sharedpreUtils;
	public static String sharedpreName = ConstantBase.SHAREDPRE_BASE_NAME;
	private SharedPreferences preferences;
	private Editor editor;

	private SharedpreUtils() {

	}

	private void createSharedPre(Context context, String name) {
		preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE); // 私有数据
		editor = preferences.edit();
		sharedpreName = name;
	}

	/**
	 * 得到默认名称的sharepreferencce
	 * 
	 * @param context
	 * @return
	 */
	public static SharedpreUtils getInstance(Context context) {
		return getInstance(context, ConstantBase.SHAREDPRE_BASE_NAME);
	}

	/**
	 * 得到指定名称的sharepreferencce
	 * 
	 * @param context
	 * @param name
	 *            不能为空，为空是默认名称的sharepreferencce
	 * @return
	 */
	public static SharedpreUtils getInstance(Context context, String name) {
		if (StringUtils.isEmptyByTrim(name)) {
			name = ConstantBase.SHAREDPRE_BASE_NAME;
		}
		if (sharedpreUtils == null) {
			sharedpreUtils = new SharedpreUtils();
			sharedpreUtils.createSharedPre(context, name);
		}
		if (!sharedpreName.equals(name)) {
			sharedpreUtils.createSharedPre(context, name);
		}
		return sharedpreUtils;
	}

	public void save(String key, String value) {
		if (StringUtils.isEmptyByTrim(key)) {
			return;
		}
		if (StringUtils.isEmpty(value)) {
			value = "";
		}
		editor.putString(key, value);
		editor.commit();
	}

	public void save(String key, boolean value) {
		if (StringUtils.isEmptyByTrim(key)) {
			return;
		}
		editor.putBoolean(key, value);
		editor.commit();
	}

	public void save(String key, float value) {
		if (StringUtils.isEmptyByTrim(key)) {
			return;
		}
		editor.putFloat(key, value);
		editor.commit();
	}

	public void save(String key, int value) {
		if (StringUtils.isEmptyByTrim(key)) {
			return;
		}
		editor.putInt(key, value);
		editor.commit();
	}

	public void save(String key, long value) {
		if (StringUtils.isEmptyByTrim(key)) {
			return;
		}
		editor.putLong(key, value);
		editor.commit();
	}

	public void save(String key, Set<String> values) {
		if (StringUtils.isEmptyByTrim(key) || values == null || values.isEmpty()) {
			return;
		}
		editor.putStringSet(key, values);
		editor.commit();
	}

	public String getString(String key, String defValue) {
		if (StringUtils.isEmptyByTrim(key)) {
			return defValue;
		}
		return preferences.getString(key, defValue);
	}

	public boolean getBoolean(String key, boolean defValue) {
		if (StringUtils.isEmptyByTrim(key)) {
			return defValue;
		}
		return preferences.getBoolean(key, defValue);
	}

	public float getFloat(String key, float defValue) {
		if (StringUtils.isEmptyByTrim(key)) {
			return defValue;
		}
		return preferences.getFloat(key, defValue);
	}

	public int getInt(String key, int defValue) {
		if (StringUtils.isEmptyByTrim(key)) {
			return defValue;
		}
		return preferences.getInt(key, defValue);
	}

	public long getLong(String key, long defValue) {
		if (StringUtils.isEmptyByTrim(key)) {
			return defValue;
		}
		return preferences.getLong(key, defValue);
	}

	public Set<String> getStringSet(String key, Set<String> defValue) {
		if (StringUtils.isEmptyByTrim(key)) {
			return defValue;
		}
		return preferences.getStringSet(key, defValue);
	}

	public Map<String, ?> getAll() {
		return preferences.getAll();
	}

	public void clear() {
		editor.clear().commit();
	}

	public void remove(String key) {
		if (StringUtils.isEmptyByTrim(key)) {
			return;
		}
		editor.remove(key).commit();
	}
}

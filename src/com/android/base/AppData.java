package com.android.base;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class AppData {
	private static AppData appData;
	private List<Activity> activityList;

	private AppData() {
		activityList = new ArrayList<Activity>();
	}

	public static AppData getInstance() {
		if (appData == null) {
			appData = new AppData();
		}
		return appData;
	}

	public void addActivity(Activity activity) {
		this.activityList.add(activity);
	}

	public void removeActivity(Activity activity) {
		if (this.activityList.contains(activity)) {
			this.activityList.remove(activity);
		}
	}

	public void finishAllActivity() {
		for (Activity activity : this.activityList) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
		this.activityList.clear();
	}
}

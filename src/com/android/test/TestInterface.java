package com.android.test;

import java.util.Map;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.QueryMap;

public interface TestInterface {

	@GET("/ApkPatchServer/rest/test")
	Call<ResponeData<UserBean>> getData(@QueryMap Map<String, String> userName);
}

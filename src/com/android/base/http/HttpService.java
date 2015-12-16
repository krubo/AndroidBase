package com.android.base.http;

import java.util.concurrent.TimeUnit;

import com.android.base.ConstantBase;
import com.android.base.utils.StringUtils;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * 网络请求服务，单例模式
 * 
 * @author krubo
 *
 */
public class HttpService {

	private static HttpService httpService;
	private Retrofit retrofit;
	private OkHttpClient httpClient;

	private HttpService() {
		// TODO Auto-generated constructor stub
		httpClient = new OkHttpClient();
		httpClient.setRetryOnConnectionFailure(true);
		setTimeOut(ConstantBase.HTTP_TIME_OUT);
		// httpInterface = retrofit.create(HttpInterface.class);
	}

	public static HttpService getInstance() {
		if (httpService == null) {
			httpService = new HttpService();
		}
		return httpService;
	}

	/**
	 * 设置超时时间,单位秒
	 * 
	 * @param timeOut
	 */
	public HttpService setTimeOut(long timeOut) {
		ConstantBase.HTTP_TIME_OUT = timeOut < ConstantBase.HTTP_TIME_OUT ? ConstantBase.HTTP_TIME_OUT : timeOut;
		if (httpClient != null) {
			httpClient.setConnectTimeout(ConstantBase.HTTP_TIME_OUT, TimeUnit.SECONDS);
			httpClient.setReadTimeout(ConstantBase.HTTP_TIME_OUT, TimeUnit.SECONDS);
			httpClient.setWriteTimeout(ConstantBase.HTTP_TIME_OUT, TimeUnit.SECONDS);
		}
		return httpService;
	}

	/**
	 * 设置基地址
	 * 
	 * @param baseUrl
	 */
	public HttpService setBaseUrl(String baseUrl) {
		ConstantBase.HTTP_BASE_URL = baseUrl;
		if (StringUtils.isEmptyByTrim(ConstantBase.HTTP_BASE_URL)) {
			retrofit = null;
		} else {
			retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
					.client(httpClient).build();
		}
		return httpService;
	}

	public Retrofit getRetrofit() {
		return retrofit;
	}

	public <T> T getInterface(Class<T> cls) {
		return retrofit.create(cls);
	}
}

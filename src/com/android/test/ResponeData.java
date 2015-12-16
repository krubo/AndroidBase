package com.android.test;

public class ResponeData<T> {

	private int code;
	private String msg;
	private boolean state;
	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponeData [code=" + code + ", msg=" + msg + ", state=" + state + ", data=" + data.toString() + "]";
	}
}

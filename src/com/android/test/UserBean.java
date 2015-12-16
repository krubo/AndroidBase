package com.android.test;

/**
 * Created by krubo on 2015/10/28.
 */
public class UserBean {
	private String name;
	private String sex;
	private int age;
	private String addr;
	private boolean isMarry;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public boolean isMarry() {
		return isMarry;
	}

	public void setIsMarry(boolean isMarry) {
		this.isMarry = isMarry;
	}

	@Override
	public String toString() {
		return "UserBean{" + "name='" + name + '\'' + ", sex='" + sex + '\'' + ", age=" + age + ", addr='" + addr + '\''
				+ ", isMarry=" + isMarry + '}';
	}
}

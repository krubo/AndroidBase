package com.android.test;

import com.android.base.db.annotation.DBField;
import com.android.base.db.annotation.DBTableName;

@DBTableName(tableName = "persion")
public class Person {
	@DBField
	private String name;
	@DBField
	private boolean sex;
	@DBField
	private long time;
	@DBField
	private int age;
	@DBField
	private double weight;
	@DBField
	private float height;
	@DBField
	private short id;
	private String addr;
	private int group;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", time=" + time + ", age=" + age + ", weight=" + weight
				+ ", height=" + height + ", id=" + id + ", addr=" + addr + ", group=" + group + "]";
	}

}

package com.joyce.java8;

public class User {

	String id;
	Integer age;
	String name;
	String remark;
	
	public User() {
		
	}
	
	public User(String id,Integer age) {
		this.id = id;
		this.age = age;
	}

	public User(String id,String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public User setId(String id) {
		this.id = id;
		return this;
	}
	public Integer getAge() {
		return age;
	}
	public User setAge(Integer age) {
		this.age = age;
		return this;
	}
	public String getRemark() {
		return remark;
	}
	public User setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int nameCompare(User u1, User u2) {
		return u1.name.compareTo(u2.name);
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", remark='" + remark + '\'' +
				'}';
	}
}

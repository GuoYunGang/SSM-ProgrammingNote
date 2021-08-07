package com.gyg.beans;

public class Cat {

	private Integer id;
	private String name;
	private String age;
	private Integer gender;
	
	public Cat() {
		super();
	}
	public Cat(Integer id, String name, String age, Integer gender) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
}

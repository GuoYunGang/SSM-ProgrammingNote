package com.spring.beans;

import java.util.List;
import java.util.Map;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class Person {

	private String name;
	private int age;
	private String sex;
	private String email;
	private Double salary;
	
	
	


	private Car car;
	private List<Book> books;
	private Map<String, Object> maps;
	private Properties properties;
	
	
//	单属性构造器
	public Person(Car car) {
		super();
		this.car = car;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Person() {
		super();
	}

	public Person(String name, int age, String sex, String email) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.email = email;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex
				+ ", email=" + email + ", salary=" + salary + ", car=" + car
				+ ", books=" + books + ", maps=" + maps + ", properties="
				+ properties + "]";
	}

	

	
	
}

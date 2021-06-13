package com.spring.junit;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.AirPlane;
import com.spring.beans.Book;
import com.spring.beans.Car;
import com.spring.beans.Person;
import com.sun.xml.internal.fastinfoset.sax.Properties;

public class IocTest {

//****************进行简单值赋值，获取bean对象*************
	ApplicationContext iocContext = new ClassPathXmlApplicationContext("ioc.xml");
	
	/**
	 * 普通方法获取参数
	 * */
//	@Test
	public void test01() {
//		fail("Not yet implemented");
		Person person01 = (Person)iocContext.getBean("person01");
		System.out.println(person01);
	}
	
	/**
	 * 通过类和属性名获取参数
	 * */
//	@Test
	public void test02() {
		Person person02 = (Person)iocContext.getBean("person01",Person.class);
		System.out.println(person02);
	}
	
	
	/**
	 * 通过有参构造器来获取参数
	 * */
//	@Test
	public void test03() {
//		指定属性的有参构造
//		Person person03 = (Person)iocContext.getBean("person03");
		Person person04 = (Person)iocContext.getBean("person04");
		System.out.println(person04);
	}
	
	/**
	 * 通过p标签对bean进行赋值
	 * */
//	@Test
	public void text04() {
		Person person05 = (Person)iocContext.getBean("person05");
		System.out.println(person05);
	}
	
	
//****************进行多值赋值，获取bean对象*************
	
	ApplicationContext iocContext2 = new ClassPathXmlApplicationContext("ioc2.xml");
	
	/**
	 * 为类属性进行赋值并获取
	 * */
//	@Test
	public void test05() {
		Person person = (Person)iocContext2.getBean("person01");
		Car car = person.getCar();
		System.out.println(car);
	}
	
	
	/**
	 * 为复杂属性赋值并获取
	 * */
//	@Test
	public void test06() {
		Person person = (Person)iocContext2.getBean("person02");
//		List<Book> books =  person.getBooks();
//		Map<String, Object> maps = person.getMaps();
//		Properties properties = person.getProperties();
		System.out.println(person);
		
	}
	
	/**
	 * 采用级联属性对属性的属性进行赋值
	 * */
//	@Test
	public void test07() {
		Person person = (Person)iocContext2.getBean("person03");
//		采用级联属性进行赋值的时候，由于采用的是引用赋值，所以原来的值也会改变
		System.out.println(person.getCar());
	}
	
	/**
	 * 利用继承对属性进行重新赋值
	 * */
//	@Test
	public void test08() {
		Person person = (Person)iocContext2.getBean("person05");
		System.out.println(person);
	}
	
	
	//****************改变bean对象的创建顺序*************	
	ApplicationContext iocContext3 = new ClassPathXmlApplicationContext("ioc3.xml");
	
	/**
	 * 改变bean的创建顺序
	 * 单实例和多实例baen测试
	 * java.lang.ClassCastException: com.spring.beans.Book cannot be cast to com.spring.beans.Person
	at com.spring.junit.IocTest.test09(IocTest.java:120)

	 * 
	 * */
//	@Test
	public void test09() {
//		多实例创建时，创建的两个bean对象不相等
		Book book01 = (Book)iocContext3.getBean("book01");
		Book book02 = (Book)iocContext3.getBean("book01");
		System.out.println(book01==book02);
		
//		单实例创建时创建的两个bean相等
		Book book03 = (Book)iocContext3.getBean("book02");
		Book book04 = (Book)iocContext3.getBean("book02");
		System.out.println(book03==book04);
	}
	
	//****************利用工厂方法来创建bean*************	
	ApplicationContext iocContext4 = new ClassPathXmlApplicationContext("ioc4.xml");
			
	/**
	 * 利用工厂方法创建实例
	 * */
	@Test
	public void test10() {
//		利用静态工厂创建实例
		AirPlane airPlane01 = (AirPlane)iocContext4.getBean("airplane01");
		System.out.println(airPlane01);
		
//		利用实例工厂创建实例
		AirPlane airPlane02 = (AirPlane)iocContext4.getBean("airplane02");
		System.out.println(airPlane02);
		
//		利用自定义工厂创建实例
		Book book = (Book)iocContext4.getBean("myFactoryBean");
		System.out.println(book);
	}

	
}

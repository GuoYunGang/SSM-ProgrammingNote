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

//****************���м�ֵ��ֵ����ȡbean����*************
	ApplicationContext iocContext = new ClassPathXmlApplicationContext("ioc.xml");
	
	/**
	 * ��ͨ������ȡ����
	 * */
//	@Test
	public void test01() {
//		fail("Not yet implemented");
		Person person01 = (Person)iocContext.getBean("person01");
		System.out.println(person01);
	}
	
	/**
	 * ͨ�������������ȡ����
	 * */
//	@Test
	public void test02() {
		Person person02 = (Person)iocContext.getBean("person01",Person.class);
		System.out.println(person02);
	}
	
	
	/**
	 * ͨ���вι���������ȡ����
	 * */
//	@Test
	public void test03() {
//		ָ�����Ե��вι���
//		Person person03 = (Person)iocContext.getBean("person03");
		Person person04 = (Person)iocContext.getBean("person04");
		System.out.println(person04);
	}
	
	/**
	 * ͨ��p��ǩ��bean���и�ֵ
	 * */
//	@Test
	public void text04() {
		Person person05 = (Person)iocContext.getBean("person05");
		System.out.println(person05);
	}
	
	
//****************���ж�ֵ��ֵ����ȡbean����*************
	
	ApplicationContext iocContext2 = new ClassPathXmlApplicationContext("ioc2.xml");
	
	/**
	 * Ϊ�����Խ��и�ֵ����ȡ
	 * */
//	@Test
	public void test05() {
		Person person = (Person)iocContext2.getBean("person01");
		Car car = person.getCar();
		System.out.println(car);
	}
	
	
	/**
	 * Ϊ�������Ը�ֵ����ȡ
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
	 * ���ü������Զ����Ե����Խ��и�ֵ
	 * */
//	@Test
	public void test07() {
		Person person = (Person)iocContext2.getBean("person03");
//		���ü������Խ��и�ֵ��ʱ�����ڲ��õ������ø�ֵ������ԭ����ֵҲ��ı�
		System.out.println(person.getCar());
	}
	
	/**
	 * ���ü̳ж����Խ������¸�ֵ
	 * */
//	@Test
	public void test08() {
		Person person = (Person)iocContext2.getBean("person05");
		System.out.println(person);
	}
	
	
	//****************�ı�bean����Ĵ���˳��*************	
	ApplicationContext iocContext3 = new ClassPathXmlApplicationContext("ioc3.xml");
	
	/**
	 * �ı�bean�Ĵ���˳��
	 * ��ʵ���Ͷ�ʵ��baen����
	 * java.lang.ClassCastException: com.spring.beans.Book cannot be cast to com.spring.beans.Person
	at com.spring.junit.IocTest.test09(IocTest.java:120)

	 * 
	 * */
//	@Test
	public void test09() {
//		��ʵ������ʱ������������bean�������
		Book book01 = (Book)iocContext3.getBean("book01");
		Book book02 = (Book)iocContext3.getBean("book01");
		System.out.println(book01==book02);
		
//		��ʵ������ʱ����������bean���
		Book book03 = (Book)iocContext3.getBean("book02");
		Book book04 = (Book)iocContext3.getBean("book02");
		System.out.println(book03==book04);
	}
	
	//****************���ù�������������bean*************	
	ApplicationContext iocContext4 = new ClassPathXmlApplicationContext("ioc4.xml");
			
	/**
	 * ���ù�����������ʵ��
	 * */
	@Test
	public void test10() {
//		���þ�̬��������ʵ��
		AirPlane airPlane01 = (AirPlane)iocContext4.getBean("airplane01");
		System.out.println(airPlane01);
		
//		����ʵ����������ʵ��
		AirPlane airPlane02 = (AirPlane)iocContext4.getBean("airplane02");
		System.out.println(airPlane02);
		
//		�����Զ��幤������ʵ��
		Book book = (Book)iocContext4.getBean("myFactoryBean");
		System.out.println(book);
	}

	
}

package com.spring.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Person;

public class TestJunit {
	
	
//*************************bean��������*****************
//	����ApplicationContext��һ������ӿڣ�����û�����ٷ���close��������Ҫʹ�������ӽӿڽ��н���
	ConfigurableApplicationContext iocContext01 = new ClassPathXmlApplicationContext("ioc1.xml");
	
	/**
	 * bean��������
	 * �����ĳ�ʼ������
	 * ��ʵ���� bean����������
	 * 		����������������>��ʼ������������������>�������رգ����ٷ���
	 * 
	 * ��ʵ���� bean����������
	 * 		����������������>����bean������������>��ʼ������������������>�����رգ����ٷ�����ִ�У�
	 * 
	 * ���ô���������������
	 * 		���������������ô�������before...����>��ʼ���������������������ô�������after...��������>�������رգ����ٷ���
	 * */
//	@Test
	public void test01() {
//		iocContext01.getBean("book01");
//		iocContext01.close();
	}
	
	
	//*************************���ݿ����ӳ�*****************
	ApplicationContext iocContext02 = new ClassPathXmlApplicationContext("ioc2.xml");
	/**
	 * ���ݿ����ӳ�
	 * @throws SQLException 
	 * */
	@Test
	public void test02() throws SQLException {
		DataSource dataSource = (DataSource)iocContext02.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
	
	//*************************����xml���Զ�װ��*****************
	
	ApplicationContext iocContext03 = new ClassPathXmlApplicationContext("ioc3.xml");
	/**
	 * autowire 
	 * */
//	@Test
	public void test03() {
		
		Person person03 = (Person)iocContext03.getBean("person01");
		System.out.println(person03);
		
	}
	
	
	//*************************spEL����*****************
	
		ApplicationContext iocContext04 = new ClassPathXmlApplicationContext("ioc4.xml");
		/**
		 * spEL����
		 * */
//		@Test
		public void test04() {
			System.out.println("test04");
			Person person04 = (Person)iocContext04.getBean("person01");
			System.out.println(person04);
			
		}
	
	

}

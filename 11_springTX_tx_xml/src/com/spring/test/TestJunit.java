package com.spring.test;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import com.spring.service.BookService;
import com.spring.service.MulService;
/**
 * �������
 * */
public class TestJunit {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");
	BookService bookService = ioc.getBean(BookService.class);
	
	/**
	 * �������ݿ�����
	 * */
//	@Test
	public void test() throws SQLException {
		System.out.println("���ݿ�����ִ��_10");
		DataSource bean = ioc.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
	}
	
	@Test
	public void test1() throws FileNotFoundException {
		System.err.println("����ִ�п�ʼ_11");
		bookService.buyBook("Jerry", "ISBN-002");
		System.err.println("����ִ�����_11");
		}
	

}

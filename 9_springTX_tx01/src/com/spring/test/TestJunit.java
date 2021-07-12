package com.spring.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.service.BookService;
/**
 * �������
 * */
public class TestJunit {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");
	BookService bookService = ioc.getBean(BookService.class);
	
	/**
	 * �������ݿ�����
	 * */
	@Test
	public void test() throws SQLException {
		System.out.println("���ݿ�����ִ��");
		DataSource bean = ioc.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
	}
	
	/**
	 * �����������ʵ���û�����
	 * */
//	@Test
	public void test01() {
		System.out.println("��ʼ����");
		bookService.buyBook("Tom", "ISBN-004");
	}
	

}

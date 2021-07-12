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
 * 事务控制
 * */
public class TestJunit {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");
	BookService bookService = ioc.getBean(BookService.class);
	
	/**
	 * 测试数据库链接
	 * */
	@Test
	public void test() throws SQLException {
		System.out.println("数据库连接执行");
		DataSource bean = ioc.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
	}
	
	/**
	 * 无事物情况下实现用户买书
	 * */
//	@Test
	public void test01() {
		System.out.println("开始买书");
		bookService.buyBook("Tom", "ISBN-004");
	}
	

}

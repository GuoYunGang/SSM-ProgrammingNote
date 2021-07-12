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
 * 事务控制
 * */
public class TestJunit {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");
	BookService bookService = ioc.getBean(BookService.class);
	
	/**
	 * 测试数据库链接
	 * */
//	@Test
	public void test() throws SQLException {
		System.out.println("数据库连接执行_10");
		DataSource bean = ioc.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
	}
	
	@Test
	public void test1() throws FileNotFoundException {
		System.err.println("事务执行开始_10");
		MulService mulService = ioc.getBean(MulService.class);
//		执行大事务
		mulService.mulTX_01();
		System.err.println("事务执行完成_10");
		}
	

}

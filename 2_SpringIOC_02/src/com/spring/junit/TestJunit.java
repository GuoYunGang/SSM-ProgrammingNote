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
	
	
//*************************bean生命周期*****************
//	由于ApplicationContext是一个顶层接口，里面没有销毁方法close，所以需要使用它的子接口进行接收
	ConfigurableApplicationContext iocContext01 = new ClassPathXmlApplicationContext("ioc1.xml");
	
	/**
	 * bean生命周期
	 * 容器的初始和销毁
	 * 单实例下 bean的生命周期
	 * 		容器启动————>初始化方法——————>（容器关闭）销毁方法
	 * 
	 * 多实例下 bean的生命周期
	 * 		容器启动————>调用bean——————>初始化方法——————>容器关闭（销毁方法不执行）
	 * 
	 * 后置处理器的生命周期
	 * 		容器启动——后置处理器的before...——>初始化方法——————后置处理器的after...————>（容器关闭）销毁方法
	 * */
//	@Test
	public void test01() {
//		iocContext01.getBean("book01");
//		iocContext01.close();
	}
	
	
	//*************************数据库连接池*****************
	ApplicationContext iocContext02 = new ClassPathXmlApplicationContext("ioc2.xml");
	/**
	 * 数据库连接池
	 * @throws SQLException 
	 * */
	@Test
	public void test02() throws SQLException {
		DataSource dataSource = (DataSource)iocContext02.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
	
	//*************************基于xml的自动装配*****************
	
	ApplicationContext iocContext03 = new ClassPathXmlApplicationContext("ioc3.xml");
	/**
	 * autowire 
	 * */
//	@Test
	public void test03() {
		
		Person person03 = (Person)iocContext03.getBean("person01");
		System.out.println(person03);
		
	}
	
	
	//*************************spEL测试*****************
	
		ApplicationContext iocContext04 = new ClassPathXmlApplicationContext("ioc4.xml");
		/**
		 * spEL测试
		 * */
//		@Test
		public void test04() {
			System.out.println("test04");
			Person person04 = (Person)iocContext04.getBean("person01");
			System.out.println(person04);
			
		}
	
	

}

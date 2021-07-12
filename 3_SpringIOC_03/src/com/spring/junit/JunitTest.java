package com.spring.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.Dao.BookDao;
import com.spring.servlet.BookServlet;

//基于spring的单元测试
//添加IOC容器的路径
@ContextConfiguration(locations="classpath:applicationContext.xml")
//添加相关的类属性方法
@RunWith(SpringJUnit4ClassRunner.class)
public class JunitTest {

	
//	ApplicationContext iocContext01 = new ClassPathXmlApplicationContext("applicationContext.xml");
	ApplicationContext iocContext01 = null;
	/**
	 * spring注解开发
	 * 在获取相应的组件时，使用的id就是类名的首字母小写
	 * 同时需要注意的是：使用注解获取到的bean默认是单实例的
	 * 	如果想要给bean修改调用的id，可以在相应的注解后面加上括号，写入调用时的id
	 * 		如：@Service("book01")
	 * 		那么调用就是：getbean("book01")
	 * 
	 * 如果想要bean成为多实例，则添加注解：@Scope(value="prototype")
	 * */
	
//	@Test
	public void test() {

		BookDao bookDao01 = (BookDao)iocContext01.getBean("bookDao");
		BookDao bookDao02 = (BookDao)iocContext01.getBean("bookDao");
		System.out.println(bookDao01 == bookDao02);
	}
	
	@Autowired
	BookServlet bookServlet;
	
	@Test
	public void test02() {
//		BookServlet bookServlet = (BookServlet)iocContext01.getBean(BookServlet.class);
//		bookServlet.doGet();
//		bookServlet.doMethod(bookService, bookDao2);
		System.out.println("test02");
		bookServlet.doGet();
	}

}

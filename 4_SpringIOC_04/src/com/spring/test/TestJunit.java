package com.spring.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.BookService;
import com.spring.service.UserService;

public class TestJunit {

//	进行泛型注解配置
	ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicetionContext.xml");
	@Test
	public void test() {
		UserService userService = iocContext.getBean(UserService.class);
		BookService bookService = iocContext.getBean(BookService.class);
		
		userService.save();
		bookService.save();
	}

}

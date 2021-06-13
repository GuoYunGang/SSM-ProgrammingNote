package com.spring.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.spring.Dao.BookDao;
import com.spring.service.BookService;

/**
 * 控制器层
 * */
@Controller
public class BookServlet {
	
//	添加注解实现自动装填
	@Qualifier("bookService")	//如果基于类型的查找不成功，就使用这个Qualifier("bookService")中的参数作为ID进行查找
	@Autowired(required=false)	//required=false表示如果实在找不到，就装配null
	private BookService bookService;
		
	public void doGet() {
		System.out.println("bookService = " + bookService);
		bookService.save();
	}
	
	/**
	 * 为方法进行装配实现自动填充
	 * 
	 * */
	@Autowired(required=false)
	public void doMethod(BookService bookService,@Qualifier("bookDao")BookDao bookDao2) {
		System.out.println(bookService + "   " + bookDao2);
	}
}

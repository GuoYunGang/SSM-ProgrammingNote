package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Dao.BookDao;

/**
 * 业务逻辑层注解
 * */

@Service
public class BookService {

//	添加注解表示自动装填
	@Autowired
	private BookDao bookDao;
	
	public void save() {
		System.out.println("bookService正在保存图书...");
		bookDao.saveBook();
	}
}

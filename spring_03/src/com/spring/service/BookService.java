package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Dao.BookDao;

/**
 * ҵ���߼���ע��
 * */

@Service
public class BookService {

//	���ע���ʾ�Զ�װ��
	@Autowired
	private BookDao bookDao;
	
	public void save() {
		System.out.println("bookService���ڱ���ͼ��...");
		bookDao.saveBook();
	}
}

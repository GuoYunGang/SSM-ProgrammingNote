package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BookDao;

@Service
public class BookService {

	@Autowired
	BookDao bookDao;
	/**
	 * �˿�����
	 * */
//	��������ע����������
	@Transactional
	public void buyBook(String username,String isbn) {
		bookDao.updateStockFromBookStock(isbn);
		int price = bookDao.getPriceFromBook(isbn);
		bookDao.updateBalanceFromAccount(username, price);
		System.out.println("��" +username +  "������ɹ���");
	}
	
	
}

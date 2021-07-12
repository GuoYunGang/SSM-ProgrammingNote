package com.spring.service;


import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BookDao;



public class BookService {

	@Autowired
	BookDao bookDao;
	/**
	 * 顾客买书
	 * */
	public void buyBook(String username,String isbn){
		bookDao.updateStockFromBookStock(isbn);
		
/*		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		int price = bookDao.getPriceFromBook(isbn);
		bookDao.updateBalanceFromAccount(username, price);
		System.out.println("【" +username +  "】买书成功！");
		
//		制造一个数学异常
//		int i = 10/0;
		
//		制造一个编译时异常
//		new FileInputStream("D://aaa.apn");
	}
	
	/**
	 * 获取到书的价格
	 * 根据业务特性，进行调整
	 * @param isbn
	 * @return price
	 * */
	public int getPrice(String isbn) {
		return bookDao.getPriceFromBook(isbn);
	}
	
	/**
	 * 修改图书价格
	 * */
	public void updatePrice(String isbn,int price) {
		bookDao.updatePrice(isbn, price);
		
//		在REQUIRED下添加的属性不会生效，只会实现大事务的属性
/*		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
//		制造一个运行时错误
//		int i = 10/0;
	}
	
	
	
	
	
}

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
	 * �˿�����
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
		System.out.println("��" +username +  "������ɹ���");
		
//		����һ����ѧ�쳣
//		int i = 10/0;
		
//		����һ������ʱ�쳣
//		new FileInputStream("D://aaa.apn");
	}
	
	/**
	 * ��ȡ����ļ۸�
	 * ����ҵ�����ԣ����е���
	 * @param isbn
	 * @return price
	 * */
	public int getPrice(String isbn) {
		return bookDao.getPriceFromBook(isbn);
	}
	
	/**
	 * �޸�ͼ��۸�
	 * */
	public void updatePrice(String isbn,int price) {
		bookDao.updatePrice(isbn, price);
		
//		��REQUIRED����ӵ����Բ�����Ч��ֻ��ʵ�ִ����������
/*		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
//		����һ������ʱ����
//		int i = 10/0;
	}
	
	
	
	
	
}

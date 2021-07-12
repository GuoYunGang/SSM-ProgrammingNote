package com.spring.service;


import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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
	/**
	 * ����ע��Ĳ���
	 * isolation
	 * 
	 * 
	 * noRollbackFor-Class[] ��Щ������Ҫ���ع����Ⱥź�����{}
	 * 		�磺noRollbackFor={ArithmeticException.class}��ʾ��ѧ�쳣���ع�
	 * noRollbackForClassName-String[] ��Щ������Ҫ���ع�
	 * 		�÷�����Ҫ��дȫ�������Ƚ��鷳
	 * 
	 * rollbackFor-Class[] ��Щ�쳣������Ҫ���ع�
	 * 		�磺rollbackFor={FileNotFoundException.class} �ļ��Ҳ����쳣
	 * 			���ڸñ���ʱ�쳣�����������ʱ�ǲ����лع��ģ����������ñ���ʱ�쳣�ع�
	 * rollbackForClassName-String[] ��Stringȫ������
	 * 
	 * �쳣���ࣺ
	 * 		����ʱ�쳣���Ǽ���쳣�������Բ��ô���Ĭ�϶���ع�
	 * 		����ʱ�쳣������쳣����Ҫô��try-catch��Ҫô�ڷ���������throws
	 * 				����ʱ�쳣Ĭ�ϲ��ᴥ���ع�
	 * ����Ļع���Ĭ������ʱ�쳣����ع�����������ʱ�쳣ʱ����ع�
	 * 		
	 * 
	 * readOnly-boolean ֻ���ģ���������Ϊֻ������ֻ���Խ��в�ѯ�����������ݿ����޸ĵĲ������ᱻִ�У� 
	 * 		����������Ż�
	 * 		readOnly=true ���Ӳ�ѯ�ٶȣ�����������ز���
	 * 
	 * timeout-int ������Ϊ��λ����ʱ�����񳬳�ָ��ִ��ʱ�����Զ���ֹ���ع�
	 * 		��ʱʱ����TransactionTimedOutException: Transaction timed out: 
	 * 
	 * 
	 * propagation-Propagation ��������������У������¿�����������������һ������
	 * 		REQUIRED ��ǰ�����֮ǰ�Ĵ�������һ������
	 * 			������ʹ��REQUIRED��ʱ����������Զ��Ǽ����ڴ�����ģ����ԶԷ���ʩ�ӵ����Բ��ᵥ����Ч��
	 * 				timeout=3
	 * 			������ʹ��REQUIRES_NEW��ʱ������������ǿ��Ե����ģ�
	 * 		REQUIRES_NEW ��ǰ��������ʹ��һ���µ���������Ѿ����������񽫻ᱻ����
	 * 			��ǰ�����ύ������֮���������б����������
	 * 
	 * 		ԭ��REQUIRED���ǽ�֮ǰ�����connection���ݸ��������ʹ��
	 * 			REQUIRES_NEW�����������ֱ��ʹ���µ�connection
	 * 		
	 * 
	 * @throws FileNotFoundException 
	 * 
	 * 
	 * */
	
	@Transactional(timeout=3,readOnly=false,propagation=Propagation.REQUIRES_NEW)
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
	@Transactional(readOnly=true,isolation=Isolation.READ_UNCOMMITTED)
	public int getPrice(String isbn) {
		return bookDao.getPriceFromBook(isbn);
	}
	
	/**
	 * �޸�ͼ��۸�
	 * */
	@Transactional(propagation=Propagation.REQUIRED)
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

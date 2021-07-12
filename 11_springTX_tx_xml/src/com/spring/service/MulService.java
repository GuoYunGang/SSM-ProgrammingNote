package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ��������ҵ���߼�
 * */
public class MulService {
	
 	private BookService bookService;
	
	/**
	 * ����һ��������
	 * */
	public void mulTX_01() {
//		��������
		bookService.buyBook("Tom", "ISBN-001");
		
/*		�޸ļ۸�����  
 * 		�������������REQUIRES_NEW�����������һ���������������У�
 * 			�������г���ʱ�����׳��쳣��ͬʱ�������������񣬵���ͬ�ڴ������е���������Ҳ��ع�
 * 
 * 		�������������REQUIRED������������������һ������
 * 			ͬʱ��һ��������������ʱ��REQUIRED�������쳣ʱ��������Ӱ��REQUIES_NEW������ִ�У�
 * 		
 * */
		bookService.updatePrice("ISBN-001", 998);
		
		
	}
}

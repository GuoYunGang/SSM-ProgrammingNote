package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设置总体业务逻辑
 * */
public class MulService {
	
 	private BookService bookService;
	
	/**
	 * 开启一个多事务
	 * */
	public void mulTX_01() {
//		买书事务
		bookService.buyBook("Tom", "ISBN-001");
		
/*		修改价格事务  
 * 		当下面的事务开启REQUIRES_NEW，该事务会以一个新事物的身份运行，
 * 			但是运行出错时还会抛出异常，同时被大事务所捕获，导致同在大事务中的其他事务也会回滚
 * 
 * 		当下面的事务开启REQUIRED，该事务会与大事务公用一个事务，
 * 			同时上一个事务开启新事务时，REQUIRED事务抛异常时，并不会影响REQUIES_NEW的事务执行，
 * 		
 * */
		bookService.updatePrice("ISBN-001", 998);
		
		
	}
}

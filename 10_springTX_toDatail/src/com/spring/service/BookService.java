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
	 * 顾客买书
	 * */
//	开启基于注解的事务控制
	/**
	 * 事务注解的参数
	 * isolation
	 * 
	 * 
	 * noRollbackFor-Class[] 哪些事务不需要被回滚，等号后面用{}
	 * 		如：noRollbackFor={ArithmeticException.class}表示数学异常不回滚
	 * noRollbackForClassName-String[] 哪些事务不需要被回滚
	 * 		该方法需要书写全类名，比较麻烦
	 * 
	 * rollbackFor-Class[] 哪些异常事务需要被回滚
	 * 		如：rollbackFor={FileNotFoundException.class} 文件找不到异常
	 * 			对于该编译时异常，不添加声明时是不进行回滚的，添加声明后该编译时异常回滚
	 * rollbackForClassName-String[] （String全类名）
	 * 
	 * 异常分类：
	 * 		运行时异常（非检查异常）：可以不用处理，默认都会回滚
	 * 		编译时异常（检查异常）：要么用try-catch，要么在方法上声明throws
	 * 				编译时异常默认不会触发回滚
	 * 事务的回滚：默认运行时异常都会回滚，发生编译时异常时不会回滚
	 * 		
	 * 
	 * readOnly-boolean 只读的，设置事务为只读事务（只可以进行查询操作，对数据库有修改的操作不会被执行） 
	 * 		对事务进行优化
	 * 		readOnly=true 增加查询速度，忽略事务相关操作
	 * 
	 * timeout-int （以秒为单位）超时，事务超出指定执行时长后自动终止并回滚
	 * 		超时时报错：TransactionTimedOutException: Transaction timed out: 
	 * 
	 * 
	 * propagation-Propagation 设置事务如何运行，（如新开启事务或与大事务公用一个事务）
	 * 		REQUIRED 当前事务和之前的大事务公用一个事务
	 * 			当事务使用REQUIRED的时候，事务的属性都是集成于大事务的，所以对方法施加的属性不会单独生效，
	 * 				timeout=3
	 * 			当事务使用REQUIRES_NEW的时候，事务的属性是可以调整的，
	 * 		REQUIRES_NEW 当前事务总是使用一个新的事务，如果已经有事务，事务将会被挂起
	 * 			当前事务提交运行完之后会继续运行被挂起的事务
	 * 
	 * 		原理：REQUIRED，是将之前事务的connection传递给这个方法使用
	 * 			REQUIRES_NEW，是这个方法直接使用新的connection
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
	@Transactional(readOnly=true,isolation=Isolation.READ_UNCOMMITTED)
	public int getPrice(String isbn) {
		return bookDao.getPriceFromBook(isbn);
	}
	
	/**
	 * 修改图书价格
	 * */
	@Transactional(propagation=Propagation.REQUIRED)
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

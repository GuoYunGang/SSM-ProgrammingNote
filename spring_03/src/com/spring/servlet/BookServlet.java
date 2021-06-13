package com.spring.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.spring.Dao.BookDao;
import com.spring.service.BookService;

/**
 * ��������
 * */
@Controller
public class BookServlet {
	
//	���ע��ʵ���Զ�װ��
	@Qualifier("bookService")	//����������͵Ĳ��Ҳ��ɹ�����ʹ�����Qualifier("bookService")�еĲ�����ΪID���в���
	@Autowired(required=false)	//required=false��ʾ���ʵ���Ҳ�������װ��null
	private BookService bookService;
		
	public void doGet() {
		System.out.println("bookService = " + bookService);
		bookService.save();
	}
	
	/**
	 * Ϊ��������װ��ʵ���Զ����
	 * 
	 * */
	@Autowired(required=false)
	public void doMethod(BookService bookService,@Qualifier("bookDao")BookDao bookDao2) {
		System.out.println(bookService + "   " + bookDao2);
	}
}

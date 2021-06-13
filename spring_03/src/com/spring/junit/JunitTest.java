package com.spring.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.Dao.BookDao;
import com.spring.servlet.BookServlet;

//����spring�ĵ�Ԫ����
//���IOC������·��
@ContextConfiguration(locations="classpath:applicationContext.xml")
//�����ص������Է���
@RunWith(SpringJUnit4ClassRunner.class)
public class JunitTest {

	
//	ApplicationContext iocContext01 = new ClassPathXmlApplicationContext("applicationContext.xml");
	ApplicationContext iocContext01 = null;
	/**
	 * springע�⿪��
	 * �ڻ�ȡ��Ӧ�����ʱ��ʹ�õ�id��������������ĸСд
	 * ͬʱ��Ҫע����ǣ�ʹ��ע���ȡ����beanĬ���ǵ�ʵ����
	 * 	�����Ҫ��bean�޸ĵ��õ�id����������Ӧ��ע�����������ţ�д�����ʱ��id
	 * 		�磺@Service("book01")
	 * 		��ô���þ��ǣ�getbean("book01")
	 * 
	 * �����Ҫbean��Ϊ��ʵ���������ע�⣺@Scope(value="prototype")
	 * */
	
//	@Test
	public void test() {

		BookDao bookDao01 = (BookDao)iocContext01.getBean("bookDao");
		BookDao bookDao02 = (BookDao)iocContext01.getBean("bookDao");
		System.out.println(bookDao01 == bookDao02);
	}
	
	@Autowired
	BookServlet bookServlet;
	
	@Test
	public void test02() {
//		BookServlet bookServlet = (BookServlet)iocContext01.getBean(BookServlet.class);
//		bookServlet.doGet();
//		bookServlet.doMethod(bookService, bookDao2);
		System.out.println("test02");
		bookServlet.doGet();
	}

}

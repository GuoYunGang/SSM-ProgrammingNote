package com.spring.Dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * ���ݿ��ע��
 * */
@Repository
//��ʾʹ�ö�ʵ��
//@Scope(value="prototype")
public class BookDao {

	public void saveBook() {
		System.out.println("bookDao�е�ͼ���ѱ���...");
	}
}

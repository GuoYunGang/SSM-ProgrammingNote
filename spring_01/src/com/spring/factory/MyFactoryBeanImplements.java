package com.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.spring.beans.Book;

/**
 * ����һ��ʵ�������Ľӿ�
 * ����һ�������ܹ���ʶ��factoryBean�࣬
 * ֻҪ������ӿ�ʵ�ֵ��࣬spring������Ϊ�ǹ���
 * */
public class MyFactoryBeanImplements implements FactoryBean<Book>{

	/**
	 * �������������ش����Ķ���
	 * */
	@Override
	public Book getObject() throws Exception {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setBookName("�Զ�������01");
		return book;
	}

	/**
	 * ���ض��������
	 * */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Book.class;
	}

	
	/**
	 * isSingleton �ǵ�����
	 * false ���ǵ���
	 * true �ǵ���
	 * false��true�ǿ����л���
	 * */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}

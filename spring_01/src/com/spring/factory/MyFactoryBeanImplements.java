package com.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.spring.beans.Book;

/**
 * 创建一个实例工厂的接口
 * 创建一个容器能够认识的factoryBean类，
 * 只要是这个接口实现的类，spring都会认为是工厂
 * */
public class MyFactoryBeanImplements implements FactoryBean<Book>{

	/**
	 * 工厂方法，返回创建的对象
	 * */
	@Override
	public Book getObject() throws Exception {
		// TODO Auto-generated method stub
		Book book = new Book();
		book.setBookName("自定义作者01");
		return book;
	}

	/**
	 * 返回对象的类型
	 * */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Book.class;
	}

	
	/**
	 * isSingleton 是单例吗？
	 * false 不是单例
	 * true 是单例
	 * false和true是可以切换的
	 * */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}

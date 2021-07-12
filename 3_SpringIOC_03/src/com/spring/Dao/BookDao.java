package com.spring.Dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 数据库层注解
 * */
@Repository
//表示使用多实例
//@Scope(value="prototype")
public class BookDao {

	public void saveBook() {
		System.out.println("bookDao中的图书已保存...");
	}
}

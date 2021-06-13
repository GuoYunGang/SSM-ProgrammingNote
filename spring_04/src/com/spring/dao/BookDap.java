package com.spring.dao;

import org.springframework.stereotype.Repository;

import com.spring.beans.Book;

@Repository
public class BookDap extends BaseDao<Book>{

	@Override
	public void Save() {
		// TODO Auto-generated method stub
		System.out.println("bookdao±£´æ...");
	}

}

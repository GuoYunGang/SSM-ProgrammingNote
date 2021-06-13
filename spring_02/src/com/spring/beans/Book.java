package com.spring.beans;

public class Book {
	private String bookName;
	private String author;
	
	public void myInit() {
		System.out.println("book bean被创建");
	}
	
	public void myDestory() {
		System.out.println("book bean被销毁");
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + "]";
	}
	
	
}

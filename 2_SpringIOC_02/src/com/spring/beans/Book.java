package com.spring.beans;

public class Book {
	private String bookName;
	private String author;
	
	public void myInit() {
		System.out.println("book bean������");
	}
	
	public void myDestory() {
		System.out.println("book bean������");
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

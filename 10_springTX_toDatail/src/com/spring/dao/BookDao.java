package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//数据库层包扫描
@Repository
public class BookDao {

//	自动装配
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 1、减余额
	 * 根据用户名和购买书的价格来计算该用户剩余的余额
	 * */
	public void updateBalanceFromAccount(String username,int price) {
		String sql = "UPDATE account SET balance=balance-? WHERE username=?";
		jdbcTemplate.update(sql, price, username);
	}
	
	/**
	 * 查询单价
	 * */
	public int getPriceFromBook(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn=?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

	/**
	 * 减库存
	 * */
	public void updateStockFromBookStock(String isbn) {
		String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
		jdbcTemplate.update(sql, isbn);
	}
	
	/**
	 * 修改价格
	 * 给修改价格添加事务控制
	 * */
	public void updatePrice(String isbn,int price) {
		String sql = "UPDATE book SET price=? WHERE isbn=?";
		jdbcTemplate.update(sql, price, isbn);
	}
	
	
}

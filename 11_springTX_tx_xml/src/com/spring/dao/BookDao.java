package com.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//���ݿ���ɨ��
@Repository
public class BookDao {

//	�Զ�װ��
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 1�������
	 * �����û����͹�����ļ۸���������û�ʣ������
	 * */
	public void updateBalanceFromAccount(String username,int price) {
		String sql = "UPDATE account SET balance=balance-? WHERE username=?";
		jdbcTemplate.update(sql, price, username);
	}
	
	/**
	 * ��ѯ����
	 * */
	public int getPriceFromBook(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn=?";
		int price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		return price;
	}

	/**
	 * �����
	 * */
	public void updateStockFromBookStock(String isbn) {
		String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
		jdbcTemplate.update(sql, isbn);
	}
	
	/**
	 * �޸ļ۸�
	 * ���޸ļ۸�����������
	 * */
	public void updatePrice(String isbn,int price) {
		String sql = "UPDATE book SET price=? WHERE isbn=?";
		jdbcTemplate.update(sql, price, isbn);
	}
	
	
}

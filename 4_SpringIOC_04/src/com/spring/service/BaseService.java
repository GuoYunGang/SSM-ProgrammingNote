package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dao.BaseDao;

public class BaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;
	
	public void save() {
		baseDao.Save();
	}
}

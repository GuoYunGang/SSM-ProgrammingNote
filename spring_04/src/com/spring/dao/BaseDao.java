package com.spring.dao;

import java.sql.Savepoint;

import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDao<T> {
	public abstract void Save();
}

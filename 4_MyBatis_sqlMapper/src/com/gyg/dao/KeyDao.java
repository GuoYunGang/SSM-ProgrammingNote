package com.gyg.dao;

import com.gyg.beans.Key;

public interface KeyDao {

	// 根据id查询key
	public Key getKeyByID(Integer id);
	
	// 根据id查询key的简单方法
	public Key getKeyByIDSimple(Integer id);
}

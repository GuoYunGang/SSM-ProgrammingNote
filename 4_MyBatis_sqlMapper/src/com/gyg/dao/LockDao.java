package com.gyg.dao;

import com.gyg.beans.Lock;

public interface LockDao {

	// 查询锁，同时查出该锁对应的钥匙
	public Lock getLockByID(Integer id);

	// 按照id找锁的简单方法
	public Lock getLockByIDSimple(Integer id);

	// 简单查询锁🔒，利用分布式
	public Lock getLockByStep(Integer id);
}

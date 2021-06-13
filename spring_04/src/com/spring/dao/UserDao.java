package com.spring.dao;

import org.springframework.stereotype.Repository;

import com.spring.beans.User;

@Repository
public class UserDao extends BaseDao<User>{

	@Override
	public void Save() {
		// TODO Auto-generated method stub
		System.out.println("userdao±£´æ..");
	}

	
}

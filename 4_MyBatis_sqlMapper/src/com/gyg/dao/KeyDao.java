package com.gyg.dao;

import com.gyg.beans.Key;

public interface KeyDao {

	// ����id��ѯkey
	public Key getKeyByID(Integer id);
	
	// ����id��ѯkey�ļ򵥷���
	public Key getKeyByIDSimple(Integer id);
}

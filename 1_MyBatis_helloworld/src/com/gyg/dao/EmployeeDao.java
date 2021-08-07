package com.gyg.dao;

import com.gyg.beans.Employee;

/**
 * 员工操作接口
 */
public interface EmployeeDao {
	// 按照id查找员工
	public Employee getEmployeeByID(Integer id);
	
}

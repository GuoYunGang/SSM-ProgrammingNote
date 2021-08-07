package com.gyg.dao;

import com.gyg.beans.Employee;

/**
 * 员工操作接口
 */
public interface EmployeeDao {
	// 按照id查找员工
	public Employee getEmployeeByID(Integer id);

	// 增加员工
	public int insertEmployee(Employee employee);

	// 按照ID删除员工
	public boolean deleteEmployee(Integer id);

	// 修改员工信息
	public int updateEmployee(Employee employee);

}

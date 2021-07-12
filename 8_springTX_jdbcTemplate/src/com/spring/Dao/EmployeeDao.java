package com.spring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.beans.Employee;

@Repository
public class EmployeeDao {
	
//	��jdbcTemplate�Զ�ע��
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * �������ݵ����ݱ�
	 * */
	public int saveEmployee(Employee employee) {
		String sql = "insert into employee(emp_name,salary) values(?,?)";
		return jdbcTemplate.update(sql, employee.getEmp_name(),employee.getSalary());
	}
	
}

package com.spring.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.beans.Employee;

@Repository
public class EmployeeDao {
	
//	将jdbcTemplate自动注入
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 保存数据到数据表
	 * */
	public int saveEmployee(Employee employee) {
		String sql = "insert into employee(emp_name,salary) values(?,?)";
		return jdbcTemplate.update(sql, employee.getEmp_name(),employee.getSalary());
	}
	
}

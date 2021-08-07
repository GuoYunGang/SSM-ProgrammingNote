package com.gyg.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gyg.beans.Employee;

public interface EmployeeDaoAnnotation {
		// 按照id查找员工
		@Select("SELECT * FROM t_employee WHERE id=#{id}")
		public Employee getEmployeeByID(Integer id);

		// 增加员工
		@Insert("INSERT INTO t_employee(empName,email,gender) VALUES(#{empName}, #{email}, #{gender})")
		public int insertEmployee(Employee employee);

		// 按照ID删除员工
		@Delete("DELETE FROM t_employee WHERE id=#{id}")
		public boolean deleteEmployee(Integer id);

		// 修改员工信息
		@Update("UPDATE t_employee SET empName=#{empName},gender=#{gender},email=#{email} WHERE id=#{id}")
		public int updateEmployee(Employee employee);

}

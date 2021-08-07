package com.gyg.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gyg.beans.Employee;

public interface EmployeeDaoAnnotation {
		// ����id����Ա��
		@Select("SELECT * FROM t_employee WHERE id=#{id}")
		public Employee getEmployeeByID(Integer id);

		// ����Ա��
		@Insert("INSERT INTO t_employee(empName,email,gender) VALUES(#{empName}, #{email}, #{gender})")
		public int insertEmployee(Employee employee);

		// ����IDɾ��Ա��
		@Delete("DELETE FROM t_employee WHERE id=#{id}")
		public boolean deleteEmployee(Integer id);

		// �޸�Ա����Ϣ
		@Update("UPDATE t_employee SET empName=#{empName},gender=#{gender},email=#{email} WHERE id=#{id}")
		public int updateEmployee(Employee employee);

}

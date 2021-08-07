package com.gyg.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.gyg.beans.Employee;

/**
 * 员工操作接口
 */
public interface EmployeeDao {
	// 按照id查找员工
	public Employee getEmployeeByID(Integer id);

	// 按照id和empName查找用户，但是向mybatis指定传入的参数对应的key
	public Employee getEmployeeByIDAndName(@Param("id") Integer id,
			@Param("empName") String empName);

	// 按照id和empName查找用户，但是向mybatis中传入的对象是封装好的map
	public Employee getEmployeeByIDAndNameOnMap(Map<String, Object> map);

	// 查询所有的员工信息封装list
	public List<Employee> getAllEmps();

	// 查询单条记录封装map
	public Map<String, Object> getEmployeeByIDReturnMap(Integer id);

	// 查询所有记录封装成map，key是主键，value是返回的对象
	@MapKey("id")
	public Map<Integer, Employee> getAllEmployeeReturnMap();

	// 增加员工
	public int insertEmployee(Employee employee);

	// 输入全部数据，ID不自增
	public int insertEmployee2(Employee employee);

	// 按照ID删除员工
	public boolean deleteEmployee(Integer id);

	// 修改员工信息
	public int updateEmployee(Employee employee);

}

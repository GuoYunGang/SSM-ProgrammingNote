package com.gyg.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.gyg.beans.Employee;

/**
 * Ա�������ӿ�
 */
public interface EmployeeDao {
	// ����id����Ա��
	public Employee getEmployeeByID(Integer id);

	// ����id��empName�����û���������mybatisָ������Ĳ�����Ӧ��key
	public Employee getEmployeeByIDAndName(@Param("id") Integer id,
			@Param("empName") String empName);

	// ����id��empName�����û���������mybatis�д���Ķ����Ƿ�װ�õ�map
	public Employee getEmployeeByIDAndNameOnMap(Map<String, Object> map);

	// ��ѯ���е�Ա����Ϣ��װlist
	public List<Employee> getAllEmps();

	// ��ѯ������¼��װmap
	public Map<String, Object> getEmployeeByIDReturnMap(Integer id);

	// ��ѯ���м�¼��װ��map��key��������value�Ƿ��صĶ���
	@MapKey("id")
	public Map<Integer, Employee> getAllEmployeeReturnMap();

	// ����Ա��
	public int insertEmployee(Employee employee);

	// ����ȫ�����ݣ�ID������
	public int insertEmployee2(Employee employee);

	// ����IDɾ��Ա��
	public boolean deleteEmployee(Integer id);

	// �޸�Ա����Ϣ
	public int updateEmployee(Employee employee);

}

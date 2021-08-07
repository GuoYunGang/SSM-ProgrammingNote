package com.gyg.dao;

import com.gyg.beans.Employee;

/**
 * Ա�������ӿ�
 */
public interface EmployeeDao {
	// ����id����Ա��
	public Employee getEmployeeByID(Integer id);

	// ����Ա��
	public int insertEmployee(Employee employee);

	// ����IDɾ��Ա��
	public boolean deleteEmployee(Integer id);

	// �޸�Ա����Ϣ
	public int updateEmployee(Employee employee);

}

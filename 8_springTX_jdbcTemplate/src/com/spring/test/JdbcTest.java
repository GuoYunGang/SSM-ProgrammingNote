package com.spring.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.spring.Dao.EmployeeDao;

import com.spring.beans.Employee;

public class JdbcTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
	NamedParameterJdbcTemplate jdbcTemplate2 = context.getBean(NamedParameterJdbcTemplate.class);
	EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
		
//	ͨ����ͨ��������ȡ���ݿ�����
//	@Test
	public void test() throws SQLException {
		System.out.println("jdbc_templateִ��");
		DataSource bean = context.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
		
	}
	         
	/**
	 * ͨ��jdbcTemplate����ȡ���ݿ�����
	 * ʵ��1����������Դ
	 * */
	@Test
	public void test01() {
		System.out.println(jdbcTemplate);
	}
	
/**	�޸����ݿ�����ݱ��е�����
 * ʵ��2����emp_id=5�ļ�¼��salary�ֶθ���Ϊ1300.00*/
//	@Test
	public void test02() {
		String sql = "UPDATE employee SET salary=? WHERE emp_id=?";
		int update = jdbcTemplate.update(sql, 1300.00, 5);
		System.out.println("���³ɹ���" + update);
	}
	
	
	/**
	 * ������������
	 * */
//	@Test
	public void test03() {
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{"����","999"});
		batchArgs.add(new Object[]{"����","1999"});
		batchArgs.add(new Object[]{"����","2999"});		
		int[] batchUpdate = jdbcTemplate.batchUpdate(sql, batchArgs);
		for (int i : batchUpdate) {
			System.out.println(i);
		}
	}
	
	/**
	 * ��ѯ���ݿ��еĵ�������
	 * ʵ��4����ѯemp_id=5�����ݿ��¼����װΪһ��Java���󷵻�
	 * ������javabean�е��ֶ�Ҫ�����ݱ��е��ֶ���һ�����������Ҫ����ӳ��
	 * ��ѯ��������ʹ�� queryForObject,�����м���Ҫʹ��BeanPropertyRowMapperӳ����Ҫ���ɵ�bean����
	 * 		�ڲ��Ҳ�����ʱ��ᱨ��
	 * 
	 * */
	@Test
	public void test04() {
		String sql = "SELECT * FROM employee WHERE emp_id=?";
		Employee employee = null;
		try {
			employee = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class),5);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(employee);
		
	}
	
	/**
	 * ��ѯ���ݿ��еĶ�������
	 * ʵ��5����ѯsalary>4000�����ݿ��¼����װΪList���Ϸ���
	 * */
//	@Test
	public void test05() {
		String sql  = "SELECT * FROM employee WHERE salary>?";
		List<Employee> employees = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class),4000);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	/**
	 * ��ѯ���ݱ��е����ݣ�����ֻ����һ����ֵ
	 * ʵ��6����ѯ���salary
	 * */
//	@Test
	public void test06() {
		String sql = "SELECT MAX(salary) FROM employee";
		Double quDouble = jdbcTemplate.queryForObject(sql, Double.class);
		System.out.println(quDouble);
	}
	
	/**
	 * ʵ��7��ʹ�ô��о���������SQL������һ��Ա����¼������Map��ʽ�������ֵ
	 * �������������������ֵĲ���������������ռλ��������һ����������
	 * 		�﷨��ʽ��     :������
	 * Spring��һ��֧�־����������ܵ�jdbcTemplate
	 * 
	 * ռλ���������?��˳��ǧ���ܴ����ε�ʱ��һ��Ҫע��
	 * 
	 * */
//	@Test
	public void test07() {
		String sql = "INSERT INTO employee(emp_name,salary) values(:emp_name,:salary)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("emp_name", "����");
		paramMap.put("salary", 998.12);
		int updateNum = jdbcTemplate2.update(sql, paramMap);
		System.out.println(updateNum);
	}

	/**
	 * ʵ��8���ظ�ʵ��7����SqlParameterSource��ʽ�������ֵ
	 * Ҳ����˵��Ҫ��������javabean����ʽ����
	 * ��ʹ��sqlParmeterSource�������ݿ�������װ���ʱ��һ��Ҫע��values����Ĳ������ƺ�bean�еĲ������ƶ�Ӧ
	 * ����ͻᱨ���´���
	 * 		No value supplied for the SQL parameter 'emp_Name': Invalid property 'emp_Name' of bean class [com.spring.beans.Employee]: Bean property 'emp_Name' is not readable or has an invalid getter method: 
	 * 
	 * */
//	@Test
	public void test08() {
		String sql = "INSERT INTO employee(emp_name,salary) values(:emp_name,:salary)";
		Employee employee = new Employee();
		employee.setEmp_name("���");
		employee.setSalary(997.7);
		int updateNum = jdbcTemplate2.update(sql, new BeanPropertySqlParameterSource(employee));
		System.out.println(updateNum);
	}
	
	/**
	 * ʵ��9������BookDao���Զ�װ��JdbcTemplate����
	 * �Զ�װ���jdbcTemplate������Dao�м��ٴ���Ĳ�����
	 * �������ɵ�ʵ����ɾ�Ĳ����
	 * 	1������dao��
	 * 	2����д���еķ���
	 * 	3�����ð�ɨ�轫���Զ�װ��
	 * 	4����IOC�����л�ȡdao��
	 * 	5��ʵ��������Ӧ�����ݿ�����ķ���
	 * */
	@Test
	public void test09() {
		Employee employee = new Employee();
		employee.setEmp_name("����");
		employee.setSalary(888.7);
		int saveEmployeeNum = employeeDao.saveEmployee(employee);
		System.out.println(saveEmployeeNum);
	}
	
	
	
}

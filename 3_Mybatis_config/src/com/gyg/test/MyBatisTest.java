package com.gyg.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.gyg.beans.Employee;
import com.gyg.dao.EmployeeDao;

public class MyBatisTest {
	SqlSessionFactory sqlSessionFactory;

	/**
	 * ÿ���Ȼ�ȡ�����ļ��е�������Ϣ
	 * 
	 * @throws IOException
	 */
	@Before
	public void initSqlSessionFactory() throws IOException {
		// 1�����ӵ������ļ�����ȡ��������Ϣ
		String resource = "Mybatits-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * ��ѯԱ����Ϣ
	 * 
	 * @throws IOException
	 */
	@Test
	public void testSelect() throws IOException {

		// 2����ȡ�������ݿ��һ�λỰ
		Employee employee = null;
		SqlSession openSession = null;
		try {
			openSession = sqlSessionFactory.openSession();
			// ʹ��sqlsession�������ݿ⣬��ȡ��dao�ӿڵ�ʵ��
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmployeeByID(3);
		} finally {
			openSession.close();
		}
		System.out.println(employee);

	}

	/**
	 * ����Ա����Ϣ
	 * 
	 * @throws IOException
	 */
	// @Test
	public void testInsert() throws IOException {

		SqlSession openSession = null;
		try {
			// 1������һ�λỰ
			openSession = sqlSessionFactory.openSession();
			// 2��ʹ��sqlsession�������ݿ��ȡ��dao�ӿڵ�ʵ��
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			int i = employeeDao.insertEmployee(new Employee(null, "С��",
					"xiaogang@qq.com", 1));
			System.out.println(i);
		} finally {
			// �ύ����
			openSession.commit();
			openSession.close();
		}

	}

	/**
	 * ɾ��Ա����Ϣ
	 * 
	 * @throws IOException
	 */
	// @Test
	public void testDelete() throws IOException {

		SqlSession openSession = null;
		try {
			// 1������һ�λỰ
			openSession = sqlSessionFactory.openSession();
			// 2��ʹ��sqlsession�������ݿ��ȡ��dao�ӿڵ�ʵ��
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			boolean b = employeeDao.deleteEmployee(4);
			System.out.println(b);
		} finally {
			// �ύ����
			openSession.commit();
			openSession.close();
		}

	}

	/**
	 * �޸�Ա����Ϣ
	 * 
	 * @throws IOException
	 */
	// @Test
	public void testUpdate() throws IOException {

		SqlSession openSession = null;
		try {
			// 1������һ�λỰ
			openSession = sqlSessionFactory.openSession();
			// 2��ʹ��sqlsession�������ݿ��ȡ��dao�ӿڵ�ʵ��
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			int i = employeeDao.updateEmployee(new Employee(1, "admin",
					"admin666@163.com", 1));
			System.out.println(i);
		} finally {
			// �ύ����
			openSession.commit();
			openSession.close();
		}

	}

}

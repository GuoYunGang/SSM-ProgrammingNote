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
	 * 每次先获取配置文件中的配置信息
	 * 
	 * @throws IOException
	 */
	@Before
	public void initSqlSessionFactory() throws IOException {
		// 1、连接到配置文件并获取到配置信息
		String resource = "Mybatits-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 查询员工信息
	 * 
	 * @throws IOException
	 */
	@Test
	public void testSelect() throws IOException {

		// 2、获取到和数据库的一次会话
		Employee employee = null;
		SqlSession openSession = null;
		try {
			openSession = sqlSessionFactory.openSession();
			// 使用sqlsession操作数据库，获取到dao接口的实现
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmployeeByID(3);
		} finally {
			openSession.close();
		}
		System.out.println(employee);

	}

	/**
	 * 增加员工信息
	 * 
	 * @throws IOException
	 */
	// @Test
	public void testInsert() throws IOException {

		SqlSession openSession = null;
		try {
			// 1、开启一次会话
			openSession = sqlSessionFactory.openSession();
			// 2、使用sqlsession操作数据库获取到dao接口的实现
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			int i = employeeDao.insertEmployee(new Employee(null, "小刚",
					"xiaogang@qq.com", 1));
			System.out.println(i);
		} finally {
			// 提交事务
			openSession.commit();
			openSession.close();
		}

	}

	/**
	 * 删除员工信息
	 * 
	 * @throws IOException
	 */
	// @Test
	public void testDelete() throws IOException {

		SqlSession openSession = null;
		try {
			// 1、开启一次会话
			openSession = sqlSessionFactory.openSession();
			// 2、使用sqlsession操作数据库获取到dao接口的实现
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			boolean b = employeeDao.deleteEmployee(4);
			System.out.println(b);
		} finally {
			// 提交事务
			openSession.commit();
			openSession.close();
		}

	}

	/**
	 * 修改员工信息
	 * 
	 * @throws IOException
	 */
	// @Test
	public void testUpdate() throws IOException {

		SqlSession openSession = null;
		try {
			// 1、开启一次会话
			openSession = sqlSessionFactory.openSession();
			// 2、使用sqlsession操作数据库获取到dao接口的实现
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			int i = employeeDao.updateEmployee(new Employee(1, "admin",
					"admin666@163.com", 1));
			System.out.println(i);
		} finally {
			// 提交事务
			openSession.commit();
			openSession.close();
		}

	}

}

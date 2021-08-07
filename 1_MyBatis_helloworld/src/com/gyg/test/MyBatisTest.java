package com.gyg.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.gyg.beans.Employee;
import com.gyg.dao.EmployeeDao;

public class MyBatisTest {

	/**
	 * 从数据库中拿数据
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		// 1、连接到配置文件并获取到配置信息
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2、获取到和数据库的一次会话
		Employee employee = null;
		SqlSession openSession = null;
		try {
			openSession = sqlSessionFactory.openSession();
			// 使用sqlsession操作数据库，获取到dao接口的实现
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmployeeByID(1);
		} finally{
			openSession.close();
		}
		System.out.println(employee);

	}

}

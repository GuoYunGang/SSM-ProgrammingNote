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
	 * �����ݿ���������
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		// 1�����ӵ������ļ�����ȡ��������Ϣ
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2����ȡ�������ݿ��һ�λỰ
		Employee employee = null;
		SqlSession openSession = null;
		try {
			openSession = sqlSessionFactory.openSession();
			// ʹ��sqlsession�������ݿ⣬��ȡ��dao�ӿڵ�ʵ��
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmployeeByID(1);
		} finally{
			openSession.close();
		}
		System.out.println(employee);

	}

}

package com.gyg.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.gyg.beans.Teacher;
import com.gyg.dao.TeacherDao;

public class MyBatisTest {

	SqlSessionFactory sqlSessionFactory;

	/**
	 * ÿ������ǰ�ȳ�ʼ��sqlsessionfactory
	 * 
	 * @throws IOException
	 */
	@Before
	public void initDatabase() throws IOException {
		String resource = "Mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println("4_MyBatis_sqlMapper-->MyBatisTest");
	}

	/**
	 * һ��������� һ��������mybatis�Դ���,�Զ���ִ�н����ŵ�һ��������
	 */
	// @Test
	public void test01() {
		try {
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher1 = teacherDao.getTeacherByID(1);
			System.out.println(teacher1);
			System.out.println("====================================");
			Teacher teacher2 = teacherDao.getTeacherByID(1);
			System.out.println(teacher2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ͬsqlsession���� 1��ÿһ��sqlsession����һ���Լ��Ļ��棬��ѯ��������ֻ�������Լ��Ļ����У�
	 * 2��ͬһ����������ͬ�Ĳ��������ڿ���֮ǰû��������Ի��ᷢ�µ�sql
	 * 3�������sqlsession�ڼ�ִ�����κ�һ����ɾ�Ĳ�������ɾ�Ĳ�����ѻ������
	 */
//	@Test
	public void test02() {
		try {
			// ������һ���Ự
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher1 = teacherDao.getTeacherByID(1);
			System.out.println(teacher1);
			System.out.println("====================================");

			// �����ڶ����Ự
			SqlSession openSession2 = sqlSessionFactory.openSession();
			TeacherDao teacherDao2 = openSession2.getMapper(TeacherDao.class);
			Teacher teacher2 = teacherDao2.getTeacherByID(1);
			System.out.println(teacher2);

			System.out.println(teacher1 == teacher2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * �ֶ��������
	 * openSession.clearCache();
	 * */
//	@Test
	public void test03() {
		try {
			// ����һ���Ự
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher1 = teacherDao.getTeacherByID(1);
			System.out.println(teacher1);
			System.out.println("====================================");
			
//			�����ǰsqlsession��һ������
			openSession.clearCache();
			System.out.println("�ֶ��������...");
			System.out.println("====================================");
			
			
			Teacher teacher2 = teacherDao.getTeacherByID(1);
			System.out.println(teacher2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��������
	 * ��������ֻ����һ���Ự���������ʱ���Ὣ��һ�������е���Ϣ�ύ����������
	 * 1�����������ļ��п���ȫ�ֻ��棬
	 * 		<setting name="cacheEnabled" value="true"/>
	 * 2������Ӧ��dao.xml�п�����������
	 * 		<cache></cache>
	 * 3.��javabean��ʵ�����л��ӿ� serializable
	 */
	@Test
	public void test04() {
		try {
			// ����һ���Ự
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher1 = teacherDao.getTeacherByID(1);
			System.out.println(teacher1);
			System.out.println("====================================");
			
//			����һ���Ự�ر�
			openSession.close();
			
			SqlSession openSession2 = sqlSessionFactory.openSession();
			TeacherDao teacherDao2 = openSession2.getMapper(TeacherDao.class);
			Teacher teacher2 = teacherDao2.getTeacherByID(1);
			System.out.println(teacher2);
			
			System.out.println(teacher1 == teacher2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

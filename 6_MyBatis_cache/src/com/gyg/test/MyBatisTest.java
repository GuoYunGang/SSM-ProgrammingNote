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
	 * 每次启动前先初始化sqlsessionfactory
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
	 * 一级缓存测试 一级缓存是mybatis自带的,自动将执行结果存放到一级缓存中
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
	 * 不同sqlsession测试 1、每一个sqlsession都有一个自己的缓存，查询到的数据只会存放在自己的缓存中，
	 * 2、同一个方法，不同的参数，由于可能之前没查过，所以还会发新的sql
	 * 3、在这个sqlsession期间执行上任何一次增删改操作，增删改操作会把缓存清空
	 */
//	@Test
	public void test02() {
		try {
			// 开启第一个会话
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher1 = teacherDao.getTeacherByID(1);
			System.out.println(teacher1);
			System.out.println("====================================");

			// 开启第二个会话
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
	 * 手动清除缓存
	 * openSession.clearCache();
	 * */
//	@Test
	public void test03() {
		try {
			// 开启一个会话
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher1 = teacherDao.getTeacherByID(1);
			System.out.println(teacher1);
			System.out.println("====================================");
			
//			清除当前sqlsession的一级缓存
			openSession.clearCache();
			System.out.println("手动清除缓存...");
			System.out.println("====================================");
			
			
			Teacher teacher2 = teacherDao.getTeacherByID(1);
			System.out.println(teacher2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 二级缓存
	 * 二级缓存只有在一个会话开启或结束时，会将该一级缓存中的信息提交到二级缓存
	 * 1、先在配置文件中开启全局缓存，
	 * 		<setting name="cacheEnabled" value="true"/>
	 * 2、在相应的dao.xml中开启二级缓存
	 * 		<cache></cache>
	 * 3.在javabean上实现序列化接口 serializable
	 */
	@Test
	public void test04() {
		try {
			// 开启一个会话
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher1 = teacherDao.getTeacherByID(1);
			System.out.println(teacher1);
			System.out.println("====================================");
			
//			将第一个会话关闭
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

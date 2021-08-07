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
	 * 测试查询
	 */
	// @Test
	public void test() {
		try {
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher = teacherDao.getTeacherByID(1);
			System.out.println(teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 动态sql
	 */
	// @Test
	public void test01() {
		try {
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher = new Teacher();
			teacher.setId(1);
			teacher.setName("%t%");
			// teacher.setBirth(new Date());
			List<Teacher> list = teacherDao.getTeacherByCondition(teacher);

			for (Teacher teacher2 : list) {
				System.out.println(teacher2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 动态sql 传入一个list集合，其中放入要查询的id进行查询 public List<Teacher>
	 * getTeacherByIdIn(List<Integer> list);
	 */
//	@Test
	public void test02() {
		try {
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			List<Teacher> list = teacherDao.getTeacherByIdIn(Arrays.asList(1,
					2, 3, 4, 5));
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 动态sql 选择查询 
	 * public List<Teacher> getTeacherByConditionChoose(Teacher teacher);
	 */
//	@Test
	public void test03() {
		try {
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher = new Teacher();
			teacher.setId(2);
//			teacher.setName("t2");
			
			List<Teacher> list = teacherDao.getTeacherByConditionChoose(teacher);
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 动态sql 更新操作
	 * public int updateTeacher(Teacher teacher);
	 */
	@Test
	public void test04() {
		try {
			SqlSession openSession = sqlSessionFactory.openSession();
			TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
			Teacher teacher = new Teacher();
			teacher.setId(2);
			teacher.setName("t22");
			teacherDao.updateTeacher(teacher);
			openSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

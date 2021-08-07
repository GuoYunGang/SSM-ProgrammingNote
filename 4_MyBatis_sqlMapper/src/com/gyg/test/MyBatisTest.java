package com.gyg.test;



import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.gyg.beans.Cat;
import com.gyg.beans.Employee;
import com.gyg.beans.Key;
import com.gyg.beans.Lock;
import com.gyg.dao.CatDao;
import com.gyg.dao.EmployeeDao;
import com.gyg.dao.KeyDao;
import com.gyg.dao.LockDao;

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

	// @Test
	public void test() {
		Employee employee = null;
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmployeeByID(1);
		} finally {
			// �رջỰ
			openSession.close();
		}
		System.out.println(employee);
	}

	/**
	 * useGeneratedKeys="true" keyProperty="id"
	 * */
	// @Test
	public void test01() {
		Employee employee = null;
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = new Employee(null, "С��", "xiaohui@qq.com", 0);
			int i = employeeDao.insertEmployee(employee);
			System.out.println("��ӣ�--->" + i);
			System.out.println(employee.getId());

			openSession.commit();
		} finally {
			// �رջỰ
			openSession.close();
		}
	}

	/**
	 * useGeneratedKeys="true" keyProperty="id"
	 * */
	// @Test
	public void test02() {
		Employee employee = null;
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = new Employee(null, "СС", "xiaoxiao@qq.com", 0);
			int i = employeeDao.insertEmployee2(employee);
			System.out.println("��ӣ�--->" + i);
			System.out.println(employee.getId());

			openSession.commit();
		} finally {
			// �رջỰ
			openSession.close();
		}
	}

	/**
	 * �ж���޶������Ĳ�ѯ ����ʹ���������� public Employee getEmployeeByIDAndName(@Param("id")
	 * Integer id,@Param("empName") String empName);
	 * */
	// @Test
	public void test03() {
		Employee employee = null;
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmployeeByIDAndName(4, "С��");

		} finally {
			// �رջỰ
			openSession.close();
		}

		System.out.println(employee);
	}

	/**
	 * ����id��empName�����û���������mybatis�д���Ķ����Ƿ�װ�õ�map public Employee
	 * getEmployeeByIDAndNameOnMap(Map<String, Object> map);
	 * */
	// @Test
	public void test04() {
		Employee employee = null;
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", 1);
			map.put("empName", "admin");
			employee = employeeDao.getEmployeeByIDAndNameOnMap(map);

		} finally {
			// �رջỰ
			openSession.close();
		}

		System.out.println(employee);
	}

	/**
	 * ��ѯ���е�Ա����Ϣ public List<Employee> getAllEmps();
	 * */
	// @Test
	public void test05() {
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			List<Employee> allEmps = employeeDao.getAllEmps();
			for (Employee emp : allEmps) {
				System.out.println(emp);
			}
		} finally {
			// �رջỰ
			openSession.close();
		}
	}

	/**
	 * ��ѯ������¼��װmap public Map<String, Object> getEmployeeByIDReturnMap(Integer
	 * id);
	 */
//	@Test
	public void test06() {
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			Map<String, Object> returnMap = employeeDao
					.getEmployeeByIDReturnMap(2);
			System.out.println(returnMap);
		} finally {
			// �رջỰ
			openSession.close();
		}
	}

	/**
	 * ��ѯ���м�¼��װ��list public Map<String, Object> getEmployeeByIDReturnMap(Integer
	 * id);
	 */
	// @Test
	public void test07() {
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			Map<String, Object> returnMap = employeeDao
					.getEmployeeByIDReturnMap(2);
			System.out.println(returnMap);
		} finally {
			// �رջỰ
			openSession.close();
		}
	}

	/**
	 * ��ѯ���м�¼��װ��map��key��������value�Ƿ��صĶ��� public Map<Integer, Employee>
	 * getAllEmployeeReturnMap();
	 * �쳣��org.apache.ibatis.exceptions.TooManyResultsException: Expected one
	 * result (or null) to be returned by selectOne(), but found: 5
	 * ԭ����mybatis��֪����ʹ��ʲô��Ϊkey�� �����ʹ��ע�⣺@MapKeyָ��ʲô������Ϊkey
	 */
//	@Test
	public void test08() {
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			Map<Integer, Employee> allEmployee = employeeDao
					.getAllEmployeeReturnMap();
			System.out.println(allEmployee);
			Employee employee = allEmployee.get(1);
			System.out.println(employee);
		} finally {
			// �رջỰ
			openSession.close();
		}
	}
	
	/**
	 * �Զ�����������
	 */
//	@Test
	public void test09() {
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			CatDao catDao = openSession.getMapper(CatDao.class);
			Cat cat = catDao.getCatByID(1);
			System.out.println(cat);
		} finally {
			// �رջỰ
			openSession.close();
		}
	}
	
	/**
	 * ���ϲ�ѯ�����ʹ�ü������Բ�ѯ���
	 */
//	@Test
	public void test10() {
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			KeyDao keyDao = openSession.getMapper(KeyDao.class);
			Key key = keyDao.getKeyByID(1);
			System.out.println(key);
		} finally {
			// �رջỰ
			openSession.close();
		}
	}
	
	
	/**
	 * ���ϲ�ѯ�����ʹ�ü������Բ�ѯ���,1��n
	 */
//	@Test
	public void test11() {
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			LockDao lockDao = openSession.getMapper(LockDao.class);
			Lock lock = lockDao.getLockByID(3);
			System.out.println(lock);
			List<Key> keys = lock.getKeys();
			for (Key key : keys) {
				System.out.println(key);
			}
		} finally {
			// �رջỰ
			openSession.close();
		}
	}
	
	
	/**
	 * �ֲ���ѯ
	 * ������أ�
	 */
	@Test
	public void test12() {
		SqlSession openSession = null;
		try {
			// ��ȡ�����ݿ��һ�λỰ
			openSession = sqlSessionFactory.openSession();
			KeyDao keyDao = openSession.getMapper(KeyDao.class);
			Key key = keyDao.getKeyByIDSimple(1);
			System.out.println(key.getKeyName());
		} finally {
			// �رջỰ
			openSession.close();
		}
	}

}

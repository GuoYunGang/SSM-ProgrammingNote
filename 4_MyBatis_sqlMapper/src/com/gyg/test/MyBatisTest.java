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

	// @Test
	public void test() {
		Employee employee = null;
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmployeeByID(1);
		} finally {
			// 关闭会话
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
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = new Employee(null, "小灰", "xiaohui@qq.com", 0);
			int i = employeeDao.insertEmployee(employee);
			System.out.println("添加：--->" + i);
			System.out.println(employee.getId());

			openSession.commit();
		} finally {
			// 关闭会话
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
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = new Employee(null, "小小", "xiaoxiao@qq.com", 0);
			int i = employeeDao.insertEmployee2(employee);
			System.out.println("添加：--->" + i);
			System.out.println(employee.getId());

			openSession.commit();
		} finally {
			// 关闭会话
			openSession.close();
		}
	}

	/**
	 * 有多个限定条件的查询 建议使用命名参数 public Employee getEmployeeByIDAndName(@Param("id")
	 * Integer id,@Param("empName") String empName);
	 * */
	// @Test
	public void test03() {
		Employee employee = null;
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			employee = employeeDao.getEmployeeByIDAndName(4, "小灰");

		} finally {
			// 关闭会话
			openSession.close();
		}

		System.out.println(employee);
	}

	/**
	 * 按照id和empName查找用户，但是向mybatis中传入的对象是封装好的map public Employee
	 * getEmployeeByIDAndNameOnMap(Map<String, Object> map);
	 * */
	// @Test
	public void test04() {
		Employee employee = null;
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", 1);
			map.put("empName", "admin");
			employee = employeeDao.getEmployeeByIDAndNameOnMap(map);

		} finally {
			// 关闭会话
			openSession.close();
		}

		System.out.println(employee);
	}

	/**
	 * 查询所有的员工信息 public List<Employee> getAllEmps();
	 * */
	// @Test
	public void test05() {
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			List<Employee> allEmps = employeeDao.getAllEmps();
			for (Employee emp : allEmps) {
				System.out.println(emp);
			}
		} finally {
			// 关闭会话
			openSession.close();
		}
	}

	/**
	 * 查询单条记录封装map public Map<String, Object> getEmployeeByIDReturnMap(Integer
	 * id);
	 */
//	@Test
	public void test06() {
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			Map<String, Object> returnMap = employeeDao
					.getEmployeeByIDReturnMap(2);
			System.out.println(returnMap);
		} finally {
			// 关闭会话
			openSession.close();
		}
	}

	/**
	 * 查询所有记录封装成list public Map<String, Object> getEmployeeByIDReturnMap(Integer
	 * id);
	 */
	// @Test
	public void test07() {
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			Map<String, Object> returnMap = employeeDao
					.getEmployeeByIDReturnMap(2);
			System.out.println(returnMap);
		} finally {
			// 关闭会话
			openSession.close();
		}
	}

	/**
	 * 查询所有记录封装成map，key是主键，value是返回的对象 public Map<Integer, Employee>
	 * getAllEmployeeReturnMap();
	 * 异常：org.apache.ibatis.exceptions.TooManyResultsException: Expected one
	 * result (or null) to be returned by selectOne(), but found: 5
	 * 原因是mybatis不知道将使用什么作为key， 解决：使用注解：@MapKey指定什么属性作为key
	 */
//	@Test
	public void test08() {
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
			Map<Integer, Employee> allEmployee = employeeDao
					.getAllEmployeeReturnMap();
			System.out.println(allEmployee);
			Employee employee = allEmployee.get(1);
			System.out.println(employee);
		} finally {
			// 关闭会话
			openSession.close();
		}
	}
	
	/**
	 * 自定义结果集测试
	 */
//	@Test
	public void test09() {
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			CatDao catDao = openSession.getMapper(CatDao.class);
			Cat cat = catDao.getCatByID(1);
			System.out.println(cat);
		} finally {
			// 关闭会话
			openSession.close();
		}
	}
	
	/**
	 * 联合查询情况下使用级联属性查询结果
	 */
//	@Test
	public void test10() {
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			KeyDao keyDao = openSession.getMapper(KeyDao.class);
			Key key = keyDao.getKeyByID(1);
			System.out.println(key);
		} finally {
			// 关闭会话
			openSession.close();
		}
	}
	
	
	/**
	 * 联合查询情况下使用级联属性查询结果,1对n
	 */
//	@Test
	public void test11() {
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			LockDao lockDao = openSession.getMapper(LockDao.class);
			Lock lock = lockDao.getLockByID(3);
			System.out.println(lock);
			List<Key> keys = lock.getKeys();
			for (Key key : keys) {
				System.out.println(key);
			}
		} finally {
			// 关闭会话
			openSession.close();
		}
	}
	
	
	/**
	 * 分布查询
	 * 按需加载，
	 */
	@Test
	public void test12() {
		SqlSession openSession = null;
		try {
			// 获取和数据库的一次会话
			openSession = sqlSessionFactory.openSession();
			KeyDao keyDao = openSession.getMapper(KeyDao.class);
			Key key = keyDao.getKeyByIDSimple(1);
			System.out.println(key.getKeyName());
		} finally {
			// 关闭会话
			openSession.close();
		}
	}

}

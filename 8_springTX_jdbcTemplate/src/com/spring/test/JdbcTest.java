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
		
//	通过普通方法来获取数据库连接
//	@Test
	public void test() throws SQLException {
		System.out.println("jdbc_template执行");
		DataSource bean = context.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
		
	}
	         
	/**
	 * 通过jdbcTemplate来获取数据库连接
	 * 实验1：测试数据源
	 * */
	@Test
	public void test01() {
		System.out.println(jdbcTemplate);
	}
	
/**	修改数据库的数据表中的数据
 * 实验2：将emp_id=5的记录的salary字段更新为1300.00*/
//	@Test
	public void test02() {
		String sql = "UPDATE employee SET salary=? WHERE emp_id=?";
		int update = jdbcTemplate.update(sql, 1300.00, 5);
		System.out.println("更新成功！" + update);
	}
	
	
	/**
	 * 批量插入数据
	 * */
//	@Test
	public void test03() {
		String sql = "INSERT INTO employee(emp_name,salary) VALUES(?,?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[]{"张三","999"});
		batchArgs.add(new Object[]{"李四","1999"});
		batchArgs.add(new Object[]{"王五","2999"});		
		int[] batchUpdate = jdbcTemplate.batchUpdate(sql, batchArgs);
		for (int i : batchUpdate) {
			System.out.println(i);
		}
	}
	
	/**
	 * 查询数据库中的单条数据
	 * 实验4：查询emp_id=5的数据库记录，封装为一个Java对象返回
	 * 创建的javabean中的字段要和数据表中的字段名一样，否则就需要进行映射
	 * 查询单条数据使用 queryForObject,但是中间需要使用BeanPropertyRowMapper映射需要生成的bean对象
	 * 		在查找不到的时候会报错
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
	 * 查询数据库中的多条数据
	 * 实验5：查询salary>4000的数据库记录，封装为List集合返回
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
	 * 查询数据表中的数据，但是只返回一个数值
	 * 实验6：查询最大salary
	 * */
//	@Test
	public void test06() {
		String sql = "SELECT MAX(salary) FROM employee";
		Double quDouble = jdbcTemplate.queryForObject(sql, Double.class);
		System.out.println(quDouble);
	}
	
	/**
	 * 实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
	 * 具名参数：（具有名字的参数，参数不再是占位符，而是一个变量名）
	 * 		语法格式：     :参数名
	 * Spring有一个支持具名参数功能的jdbcTemplate
	 * 
	 * 占位符查参数：?的顺序千万不能错，传参的时候一定要注意
	 * 
	 * */
//	@Test
	public void test07() {
		String sql = "INSERT INTO employee(emp_name,salary) values(:emp_name,:salary)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("emp_name", "赵六");
		paramMap.put("salary", 998.12);
		int updateNum = jdbcTemplate2.update(sql, paramMap);
		System.out.println(updateNum);
	}

	/**
	 * 实验8：重复实验7，以SqlParameterSource形式传入参数值
	 * 也就是说需要将参数以javabean的形式传入
	 * 在使用sqlParmeterSource进行数据库中数据装填的时候，一定要注意values后面的参数名称和bean中的参数名称对应
	 * 否则就会报如下错误：
	 * 		No value supplied for the SQL parameter 'emp_Name': Invalid property 'emp_Name' of bean class [com.spring.beans.Employee]: Bean property 'emp_Name' is not readable or has an invalid getter method: 
	 * 
	 * */
//	@Test
	public void test08() {
		String sql = "INSERT INTO employee(emp_name,salary) values(:emp_name,:salary)";
		Employee employee = new Employee();
		employee.setEmp_name("吴九");
		employee.setSalary(997.7);
		int updateNum = jdbcTemplate2.update(sql, new BeanPropertySqlParameterSource(employee));
		System.out.println(updateNum);
	}
	
	/**
	 * 实验9：创建BookDao，自动装配JdbcTemplate对象
	 * 自动装配的jdbcTemplate可以在Dao中减少代码的操作，
	 * 更加轻松的实现增删改查操作
	 * 	1、建立dao类
	 * 	2、书写其中的方法
	 * 	3、利用包扫描将其自动装配
	 * 	4、从IOC容器中获取dao类
	 * 	5、实现其中响应的数据库操作的方法
	 * */
	@Test
	public void test09() {
		Employee employee = new Employee();
		employee.setEmp_name("王八");
		employee.setSalary(888.7);
		int saveEmployeeNum = employeeDao.saveEmployee(employee);
		System.out.println(saveEmployeeNum);
	}
	
	
	
}

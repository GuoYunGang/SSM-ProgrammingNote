package com.gyg.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.gyg.beans.Cat;
import com.gyg.dao.CatMapper;

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
	 * mybatis自动生成测试
	 * @throws Exception
	 */
//	@Test
	public void mbgTest01() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
//		代码生成
		myBatisGenerator.generate(null);
	}
	
	@Test
	public void mbgTest02() {
		SqlSession openSession = sqlSessionFactory.openSession();
		CatMapper catMapper = openSession.getMapper(CatMapper.class);
		Cat cat = catMapper.selectByPrimaryKey(1);
		System.out.println(cat.getCname());
	}
	
	
}

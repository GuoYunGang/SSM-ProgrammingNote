package com.spring.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.inpl.MyMathCalculator;
import com.spring.interfaces.Calculator;

/**
 * SpringAOP切面开发
 * */
public class AopTestJunit {

	ApplicationContext aopContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**
	 * ioc容器中生成的是代理对象
	 * */
	@Test
	public void test() {
		System.out.println("AOP_02：测试开始...");
		Calculator bean = aopContext.getBean(Calculator.class);
		int addNum = bean.div(1, 1);
		System.out.println(addNum);
//		System.out.println(bean);
		System.out.println("===========================");
//		bean.div(1, 1);
	}

}

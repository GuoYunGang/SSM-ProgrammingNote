package com.spring.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.spring.inpl.MyMathCalculator;
import com.spring.interfaces.Calculator;
import com.spring.proxy.CalculatorProxy;

public class AopTestJunit {

	@Test
	public void test() {
		System.out.println("测试开始...");
		Calculator calculator = new MyMathCalculator();
		System.out.println(calculator.add(1, 5));
		System.out.println("================");
		CalculatorProxy cProxy = new CalculatorProxy();
//		获取代理对象
		Calculator proxy = cProxy.getProxy(calculator);
//		执行代理对象的方法
		System.out.println(proxy.add(2, 3));
	}

}

package com.spring.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.spring.inpl.MyMathCalculator;
import com.spring.interfaces.Calculator;
import com.spring.proxy.CalculatorProxy;

public class AopTestJunit {

	@Test
	public void test() {
		System.out.println("���Կ�ʼ...");
		Calculator calculator = new MyMathCalculator();
		System.out.println(calculator.add(1, 5));
		System.out.println("================");
		CalculatorProxy cProxy = new CalculatorProxy();
//		��ȡ�������
		Calculator proxy = cProxy.getProxy(calculator);
//		ִ�д������ķ���
		System.out.println(proxy.add(2, 3));
	}

}

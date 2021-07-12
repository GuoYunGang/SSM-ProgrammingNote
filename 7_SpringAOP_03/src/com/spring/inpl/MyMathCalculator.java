package com.spring.inpl;

import org.springframework.stereotype.Service;

import com.spring.interfaces.Calculator;

/**
 * 业务逻辑层
 * */
@Service
public class MyMathCalculator implements Calculator{


	
	@Override
	public int add(int a, int b) {
		System.out.println("方法执行时...");
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("方法执行时...");
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		System.out.println("方法执行时...");
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		System.out.println("方法执行时...");
		return a/b;
	}

}

package com.spring.inpl;

import org.springframework.stereotype.Service;

import com.spring.interfaces.Calculator;

/**
 * ҵ���߼���
 * */
@Service
public class MyMathCalculator implements Calculator{


	
	@Override
	public int add(int a, int b) {
		System.out.println("����ִ��ʱ...");
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		System.out.println("����ִ��ʱ...");
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		System.out.println("����ִ��ʱ...");
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		System.out.println("����ִ��ʱ...");
		return a/b;
	}

}

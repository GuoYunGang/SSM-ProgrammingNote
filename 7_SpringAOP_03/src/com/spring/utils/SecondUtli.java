package com.spring.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
public class SecondUtli {

	/**
	 * ����ڶ��������࣬��һ��������������������������ʱ
	 * �������ִ��˳���ǣ������������ĸ�������У��ɻ���ִ��
	 * ����ĸС����ִ�У�����л��Ʒ�������ִ�л��Ʒ���
	 * 
	 * */
	public static void LogStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();	//��ȡ��������Ϣ
		Signature signature = joinPoint.getSignature(); //��ȡ������ǩ��
		String name = signature.getName();	//��ȡ��������
		System.out.println("SecondUtli��" + name + "����¼��ʼ...ִ�в�����" + Arrays.asList(args));
	}
	
	
//	��������ִ����֮��
	public static void LogReturn(JoinPoint joinPoint,Object result) {
		System.out.println("SecondUtli��" + joinPoint.getSignature().getName() + "�����򷽷�ִ�������...����ǣ�" + result);
	}
	
//	�쳣�׳�ʱ
	public static void LogThowing(JoinPoint joinPoint,Object e) {
		System.out.println("SecondUtli��" + joinPoint.getSignature().getName() +"�������쳣��Ϣ...,�쳣��Ϣ�ǣ�" + e);
	}
	
//	�����ó����
	public static void LogEnd(JoinPoint joinPoint) {
		System.out.println("SecondUtli��" + joinPoint.getSignature().getName() +"��ִ�н���");
	}
	
}

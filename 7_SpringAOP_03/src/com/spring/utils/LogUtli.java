package com.spring.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component	//����ҵ���
public class LogUtli {


	
//	����ִ�п�ʼ
	public static void LogStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();	//��ȡ��������Ϣ
		Signature signature = joinPoint.getSignature(); //��ȡ������ǩ��
		String name = signature.getName();	//��ȡ��������
		System.out.println("��" + name + "����¼��ʼ...ִ�в�����" + Arrays.asList(args));
	}
	
	
//	��������ִ����֮��
	public static void LogReturn(JoinPoint joinPoint,Object result) {
		System.out.println("��" + joinPoint.getSignature().getName() + "�����򷽷�ִ�������...����ǣ�" + result);
	}
	
//	�쳣�׳�ʱ
	public static void LogThowing(JoinPoint joinPoint,Object e) {
		System.out.println("��" + joinPoint.getSignature().getName() +"�������쳣��Ϣ...,�쳣��Ϣ�ǣ�" + e);
	}
	
//	�����ó����
	public static void LogEnd(JoinPoint joinPoint) {
		System.out.println("��" + joinPoint.getSignature().getName() +"��ִ�н���");
	}
	
	
//	���Ʒ���
	public Object MyAround(ProceedingJoinPoint pjp) throws Throwable {
		
//		��ȡ��Ŀ�귽���ڲ��Ĳ���
		Object[] args = pjp.getArgs();
		
		System.out.println("������ִ��ǰ��");
//		��ȡ��Ŀ�귽����ǩ��
		Signature signature = pjp.getSignature();
		String name = signature.getName();
		Object proceed = null;
		try {
//			���з�����ִ��
			proceed = pjp.proceed();
			System.out.println("��������ʱ");
		} catch (Exception e) {
			System.out.println("�����쳣ʱ" + e);
		}finally{
			System.out.println("���÷���");
		}
		
		//������ִ�еķ���ֵ����
		return proceed;
	}
}

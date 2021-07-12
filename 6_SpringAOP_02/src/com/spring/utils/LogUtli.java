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


@Aspect	//����ע��
@Component	//����ҵ���
public class LogUtli {

	/**
	 * ������Ҫ����֮ǰ��������ע��@Aspect
	 * ��������
	 * AOPע�⣺
	 * @Before ִ��֮ǰ
	 * @afterReturning ��������ִ����֮��
	 * @afterThrowing ���������쳣ʱִ��
	 * @after ��������ִ����֮��ִ��
	 * �������ʽ��
	 * 		execution(����Ȩ�޷� ����ֵ���� ������ȫ·��)
	 * 	*��:
	 * 		�Ǻš� * ���������з���
	 * 		�ǺŻ����Ա�ʾ�������ֵ����
	 * 
	 * .��:
	 * 		..��ʾ�������ͣ�������·���µ��ļ�
	 * 
	 * ��ģ���ģ�
	 *		�����������������ⷽ��  execution("* *(..)")	ǧ���д
	 *
	 *������ִ��˳��
	 *����ִ�У�@Before(ǰ��֪ͨ)--->@After(����֪ͨ)---->@AfterReturning(����ִ��)
	 *�쳣ִ�У�@Before(ǰ��֪ͨ)--->@After(����֪ͨ)---->@AfterThrowing(�쳣֪ͨ)
	 *
	 *��ȡ����ִ�еķ�������ϸ��Ϣ��
	 *	JoinPoint joinPoint ��װ�˵�ǰ����ִ�еķ�������ϸ��Ϣ
	 *
	 *��ȡ�����õ��������ʽ
	 *	1����㶨��һ��void����ʵ�ֵķ���
	 *	2��Ϊ�������ע��@Pointcut()
	 *	3����ע���м����ȡ�����Ŀ����õ��������ʽ
	 *	4�����������뵽��Ӧ�����溯����ע����
	 * */
	
	/**
	 * �����������ʽ�Ŀ����÷���
	 * */
	@Pointcut("execution(public int com.spring.inpl.MyMathCalculator.*(int, int))")
	public void MyCanChongYong() {}
	
//	����ִ�п�ʼ
	@Before("MyCanChongYong()")
	public static void LogStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();	//��ȡ��������Ϣ
		Signature signature = joinPoint.getSignature(); //��ȡ������ǩ��
		String name = signature.getName();	//��ȡ��������
		System.out.println("��" + name + "����¼��ʼ...ִ�в�����" + Arrays.asList(args));
	}
	
	
//	��������ִ����֮��
	/**
	 * �ڳ�������ִ����֮������з���ֵ�����ǿ��Զ��������ֵ���н���
	 * returning�������շ����ķ���ֵ
	 * */
	@AfterReturning(value="MyCanChongYong()",returning="result")
	public static void LogReturn(JoinPoint joinPoint,Object result) {
		System.out.println("��" + joinPoint.getSignature().getName() + "�����򷽷�ִ�������...����ǣ�" + result);
	}
	
//	�쳣�׳�ʱ
	/**
	 * ��ִ�з�����Ҫ�׳��쳣��ʱ�򣬿���ʹ��throwing��ע���н��н��գ�
	 * ����valueָ��ִ�е�ȫ������
	 * throwingָ�����صĴ�����Ϣ
	 * */
	@AfterThrowing(value="MyCanChongYong()",throwing="e")
	public static void LogThowing(JoinPoint joinPoint,Object e) {
		System.out.println("��" + joinPoint.getSignature().getName() +"�������쳣��Ϣ...,�쳣��Ϣ�ǣ�" + e);
	}
	
//	�����ó����
	@After(value = "execution(public int com.spring.inpl.MyMathCalculator.add(int, int))")
	public static void LogEnd(JoinPoint joinPoint) {
		System.out.println("��" + joinPoint.getSignature().getName() +"��ִ�н���");
	}
	
	/**
	 * ����֪ͨ����
	 * ʹ��ע��@Around()
	 * ��Ҫ�ڷ����д������proceedingJoinPoint �����շ����ĸ�����Ϣ
	 * ʹ�û���֪ͨʱ��Ҫʹ��proceed������ִ�з���
	 * ͬʱ��Ҫ��ֵ���з���,���Ʒ����Ὣ��Ҫִ�еķ������з���
	 * 
	 * *********************************************
	 * ������֪ͨ����֪ͨͨͬʱִ��ʱ��
	 * ִ��˳���ǣ�
	 * 		����ǰ��----��ͨǰ��----���Ʒ���/�쳣----���ƺ���----��ͨ����----��ͨ����/�쳣
	 * 
	 * @throws Throwable 
	 * */
	@Around("MyCanChongYong()")
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

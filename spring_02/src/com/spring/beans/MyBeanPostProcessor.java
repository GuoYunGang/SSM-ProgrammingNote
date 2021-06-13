package com.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * ����bean�ĺ��ô�����
 * ������Ҫע��һ����Ϊ�˳���bean��beanName��������arg0��arg1����Ҫ����Ӧ��Դ��jar��
 * */
public class MyBeanPostProcessor implements BeanPostProcessor{

	
	/**
	 * postProcessBeforeInitialization
	 * ��ʼ������ִ��ǰִ��
	 * Object bean
	 * String beanName xml�����ж����bean����
	 * */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("��"+ beanName+"����ʼ������ִ��ǰ...");
		return bean;
	}

	
	/**
	 * postProcessAfterInitialization
	 * ��ʼ������ִ�к�ִ��
	 * Object bean
	 * String beanName xml�����ж����bean����
	 * */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("��"+ beanName+"����ʼ������ִ�к�...");
		return bean;
	}

	

	

	

}

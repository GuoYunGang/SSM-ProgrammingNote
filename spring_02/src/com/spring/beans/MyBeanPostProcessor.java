package com.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 测试bean的后置处理器
 * 在这里要注意一点是为了出现bean和beanName，而不是arg0、arg1，需要绑定相应的源码jar包
 * */
public class MyBeanPostProcessor implements BeanPostProcessor{

	
	/**
	 * postProcessBeforeInitialization
	 * 初始化方法执行前执行
	 * Object bean
	 * String beanName xml容器中定义的bean名称
	 * */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("【"+ beanName+"】初始化方法执行前...");
		return bean;
	}

	
	/**
	 * postProcessAfterInitialization
	 * 初始化方法执行后执行
	 * Object bean
	 * String beanName xml容器中定义的bean名称
	 * */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("【"+ beanName+"】初始化方法执行后...");
		return bean;
	}

	

	

	

}

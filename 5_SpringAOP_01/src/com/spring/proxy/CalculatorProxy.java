package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.spring.interfaces.Calculator;
import com.spring.utils.LogUtli;

public class CalculatorProxy {

	/**
	 * ����һ����������һ������Ķ�̬����
	 * */
	public Calculator getProxy(final Calculator calculator) {
		
		ClassLoader loader = calculator.getClass().getClassLoader();
//		��ȡ������Ľӿ�
		Class<?>[] cls = calculator.getClass().getInterfaces();
		InvocationHandler inHandler = new InvocationHandler() {
			
			/**
			 * Object arg0 jdk�ײ�
			 * Method arg1 ִ�еķ���
			 * Object[] arg2 ��Ų���������
			 * */
			@Override
			public Object invoke(Object arg0, Method method, Object[] arg2)
					throws Throwable {
				LogUtli.LogStart(method.getName());
//				ִ�з���
				LogUtli.LogInfoIng(method.getName(), arg2);
				Object result = method.invoke(calculator, arg2);
				LogUtli.LogEnd(method.getName(), result);
				return result;
			}
		};
//		ΪĿ�괴���������
		Object proxy = Proxy.newProxyInstance(loader, cls, inHandler);
		return (Calculator) proxy;
	}
}

package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.spring.interfaces.Calculator;
import com.spring.utils.LogUtli;

public class CalculatorProxy {

	/**
	 * 建立一个方法返回一个对象的动态代理
	 * */
	public Calculator getProxy(final Calculator calculator) {
		
		ClassLoader loader = calculator.getClass().getClassLoader();
//		获取到该类的接口
		Class<?>[] cls = calculator.getClass().getInterfaces();
		InvocationHandler inHandler = new InvocationHandler() {
			
			/**
			 * Object arg0 jdk底层
			 * Method arg1 执行的方法
			 * Object[] arg2 存放参数的数组
			 * */
			@Override
			public Object invoke(Object arg0, Method method, Object[] arg2)
					throws Throwable {
				LogUtli.LogStart(method.getName());
//				执行方法
				LogUtli.LogInfoIng(method.getName(), arg2);
				Object result = method.invoke(calculator, arg2);
				LogUtli.LogEnd(method.getName(), result);
				return result;
			}
		};
//		为目标创建代理对象
		Object proxy = Proxy.newProxyInstance(loader, cls, inHandler);
		return (Calculator) proxy;
	}
}

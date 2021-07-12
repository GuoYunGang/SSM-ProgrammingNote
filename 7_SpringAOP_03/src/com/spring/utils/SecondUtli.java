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
	 * 引入第二个切面类，当一个方法被绑定上两个或多个切面类时
	 * 切面类的执行顺序是：按照类的首字母进行排列，成环形执行
	 * 首字母小的先执行，如果有环绕方法，先执行环绕方法
	 * 
	 * */
	public static void LogStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();	//获取到参数信息
		Signature signature = joinPoint.getSignature(); //获取到方法签名
		String name = signature.getName();	//获取到方法名
		System.out.println("SecondUtli【" + name + "】记录开始...执行参数：" + Arrays.asList(args));
	}
	
	
//	方法正常执行完之后
	public static void LogReturn(JoinPoint joinPoint,Object result) {
		System.out.println("SecondUtli【" + joinPoint.getSignature().getName() + "】程序方法执行完毕了...结果是：" + result);
	}
	
//	异常抛出时
	public static void LogThowing(JoinPoint joinPoint,Object e) {
		System.out.println("SecondUtli【" + joinPoint.getSignature().getName() +"】发现异常信息...,异常信息是：" + e);
	}
	
//	结束得出结果
	public static void LogEnd(JoinPoint joinPoint) {
		System.out.println("SecondUtli【" + joinPoint.getSignature().getName() +"】执行结束");
	}
	
}

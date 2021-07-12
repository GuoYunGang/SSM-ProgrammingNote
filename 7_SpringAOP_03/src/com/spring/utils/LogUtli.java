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

@Component	//其他业务层
public class LogUtli {


	
//	方法执行开始
	public static void LogStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();	//获取到参数信息
		Signature signature = joinPoint.getSignature(); //获取到方法签名
		String name = signature.getName();	//获取到方法名
		System.out.println("【" + name + "】记录开始...执行参数：" + Arrays.asList(args));
	}
	
	
//	方法正常执行完之后
	public static void LogReturn(JoinPoint joinPoint,Object result) {
		System.out.println("【" + joinPoint.getSignature().getName() + "】程序方法执行完毕了...结果是：" + result);
	}
	
//	异常抛出时
	public static void LogThowing(JoinPoint joinPoint,Object e) {
		System.out.println("【" + joinPoint.getSignature().getName() +"】发现异常信息...,异常信息是：" + e);
	}
	
//	结束得出结果
	public static void LogEnd(JoinPoint joinPoint) {
		System.out.println("【" + joinPoint.getSignature().getName() +"】执行结束");
	}
	
	
//	环绕方法
	public Object MyAround(ProceedingJoinPoint pjp) throws Throwable {
		
//		获取到目标方法内部的参数
		Object[] args = pjp.getArgs();
		
		System.out.println("【方法执行前】");
//		获取到目标方法的签名
		Signature signature = pjp.getSignature();
		String name = signature.getName();
		Object proceed = null;
		try {
//			进行方法的执行
			proceed = pjp.proceed();
			System.out.println("方法返回时");
		} catch (Exception e) {
			System.out.println("方法异常时" + e);
		}finally{
			System.out.println("后置方法");
		}
		
		//将方法执行的返回值返回
		return proceed;
	}
}

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

@Aspect
@Component
public class SecondUtli {

	/**
	 * 引入第二个切面类，当一个方法被绑定上两个或多个切面类时
	 * 切面类的执行顺序是：按照类的首字母进行排列，成环形执行
	 * 首字母小的先执行，如果有环绕方法，先执行环绕方法
	 * 
	 * */
//	定义切入点表达式的可重用方法
/*	@Pointcut("public int com.spring.inpl.MyMathCalculator.*(int, int)")
	public void MysCanCongYong() {}*/
	
//	方法执行开始
	@Before("com.spring.utils.LogUtli.MyCanChongYong()")
	public static void LogStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();	//获取到参数信息
		Signature signature = joinPoint.getSignature(); //获取到方法签名
		String name = signature.getName();	//获取到方法名
		System.out.println("SecondUtli【" + name + "】记录开始...执行参数：" + Arrays.asList(args));
	}
	
	
//	方法正常执行完之后
	/**
	 * 在程序正常执行完之后如果有返回值，我们可以对这个返回值进行接收
	 * returning用来接收方法的返回值
	 * */
	@AfterReturning(value="com.spring.utils.LogUtli.MyCanChongYong()",returning="result")
	public static void LogReturn(JoinPoint joinPoint,Object result) {
		System.out.println("SecondUtli【" + joinPoint.getSignature().getName() + "】程序方法执行完毕了...结果是：" + result);
	}
	
//	异常抛出时
	/**
	 * 在执行方法想要抛出异常的时候，可以使用throwing在注解中进行接收，
	 * 其中value指明执行的全方法名
	 * throwing指明返回的错误信息
	 * */
	@AfterThrowing(value="com.spring.utils.LogUtli.MyCanChongYong()",throwing="e")
	public static void LogThowing(JoinPoint joinPoint,Object e) {
		System.out.println("SecondUtli【" + joinPoint.getSignature().getName() +"】发现异常信息...,异常信息是：" + e);
	}
	
//	结束得出结果
	@After(value = "execution(public int com.spring.inpl.MyMathCalculator.add(int, int))")
	public static void LogEnd(JoinPoint joinPoint) {
		System.out.println("SecondUtli【" + joinPoint.getSignature().getName() +"】执行结束");
	}
	

}

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


@Aspect	//切面注解
@Component	//其他业务层
public class LogUtli {

	/**
	 * 首先需要在类之前加入切面注解@Aspect
	 * 设置切入
	 * AOP注解：
	 * @Before 执行之前
	 * @afterReturning 方法正常执行完之后
	 * @afterThrowing 方法发生异常时执行
	 * @after 方法最终执行完之后执行
	 * 切入点表达式：
	 * 		execution(访问权限符 返回值类型 方法的全路径)
	 * 	*号:
	 * 		星号“ * ”代表所有方法
	 * 		星号还可以表示任意的数值类型
	 * 
	 * .号:
	 * 		..表示任意类型，或任意路径下的文件
	 * 
	 * 最模糊的：
	 *		任意包下任意类的任意方法  execution("* *(..)")	千万别写
	 *
	 *方法的执行顺序：
	 *正常执行：@Before(前置通知)--->@After(后置通知)---->@AfterReturning(正常执行)
	 *异常执行：@Before(前置通知)--->@After(后置通知)---->@AfterThrowing(异常通知)
	 *
	 *获取正在执行的方法的详细信息：
	 *	JoinPoint joinPoint 封装了当前正在执行的方法的详细信息
	 *
	 *获取可重用的切入点表达式
	 *	1、随便定义一个void的无实现的方法
	 *	2、为方法添加注解@Pointcut()
	 *	3、在注解中加入抽取出来的可重用的切入点表达式
	 *	4、将方法加入到对应的切面函数的注解中
	 * */
	
	/**
	 * 定义切入点表达式的可重用方法
	 * */
	@Pointcut("execution(public int com.spring.inpl.MyMathCalculator.*(int, int))")
	public void MyCanChongYong() {}
	
//	方法执行开始
	@Before("MyCanChongYong()")
	public static void LogStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();	//获取到参数信息
		Signature signature = joinPoint.getSignature(); //获取到方法签名
		String name = signature.getName();	//获取到方法名
		System.out.println("【" + name + "】记录开始...执行参数：" + Arrays.asList(args));
	}
	
	
//	方法正常执行完之后
	/**
	 * 在程序正常执行完之后如果有返回值，我们可以对这个返回值进行接收
	 * returning用来接收方法的返回值
	 * */
	@AfterReturning(value="MyCanChongYong()",returning="result")
	public static void LogReturn(JoinPoint joinPoint,Object result) {
		System.out.println("【" + joinPoint.getSignature().getName() + "】程序方法执行完毕了...结果是：" + result);
	}
	
//	异常抛出时
	/**
	 * 在执行方法想要抛出异常的时候，可以使用throwing在注解中进行接收，
	 * 其中value指明执行的全方法名
	 * throwing指明返回的错误信息
	 * */
	@AfterThrowing(value="MyCanChongYong()",throwing="e")
	public static void LogThowing(JoinPoint joinPoint,Object e) {
		System.out.println("【" + joinPoint.getSignature().getName() +"】发现异常信息...,异常信息是：" + e);
	}
	
//	结束得出结果
	@After(value = "execution(public int com.spring.inpl.MyMathCalculator.add(int, int))")
	public static void LogEnd(JoinPoint joinPoint) {
		System.out.println("【" + joinPoint.getSignature().getName() +"】执行结束");
	}
	
	/**
	 * 环绕通知方法
	 * 使用注解@Around()
	 * 需要在方法中传入参数proceedingJoinPoint 来接收方法的各种信息
	 * 使用环绕通知时需要使用proceed方法来执行方法
	 * 同时需要将值进行返回,环绕方法会将需要执行的方法进行放行
	 * 
	 * *********************************************
	 * 当环绕通知和普通通知同时执行时，
	 * 执行顺序是：
	 * 		环绕前置----普通前置----环绕返回/异常----环绕后置----普通后置----普通返回/异常
	 * 
	 * @throws Throwable 
	 * */
	@Around("MyCanChongYong()")
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

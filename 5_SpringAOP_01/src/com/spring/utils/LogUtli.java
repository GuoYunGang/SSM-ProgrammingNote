package com.spring.utils;

import java.util.Arrays;

public class LogUtli {

//	日志开始
	public static void LogStart(String method) {
		System.out.println("【" + method + "】记录开始...");
	}
	
//	记录信息
	public static void LogInfoIng(String method,Object...arrays) {
		System.out.println("【" + method + "】记录开始..." + Arrays.asList(arrays));		
	}
	
//	结束得出结果
	public static void LogEnd(String method,Object...result) {
		System.out.println("【" + method + "】得出的结果是：" + Arrays.asList(result));
	}
}

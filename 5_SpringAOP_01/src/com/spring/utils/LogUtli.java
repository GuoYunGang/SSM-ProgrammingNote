package com.spring.utils;

import java.util.Arrays;

public class LogUtli {

//	��־��ʼ
	public static void LogStart(String method) {
		System.out.println("��" + method + "����¼��ʼ...");
	}
	
//	��¼��Ϣ
	public static void LogInfoIng(String method,Object...arrays) {
		System.out.println("��" + method + "����¼��ʼ..." + Arrays.asList(arrays));		
	}
	
//	�����ó����
	public static void LogEnd(String method,Object...result) {
		System.out.println("��" + method + "���ó��Ľ���ǣ�" + Arrays.asList(result));
	}
}

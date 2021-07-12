package com.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.spring.beans.AirPlane;
import com.spring.beans.Book;

/**
 * ����һ��ʵ�������Ľӿ�
 * ����һ�������ܹ���ʶ��factoryBean�࣬
 * ֻҪ������ӿ�ʵ�ֵ��࣬spring������Ϊ�ǹ���
 * */
public class MyFactoryBeanImplements implements FactoryBean<AirPlane>{

	/**
	 * �������������ش����Ķ���
	 * */
	@Override
	public AirPlane getObject() throws Exception {
		// TODO Auto-generated method stub
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("̫��-2");
		airPlane.setYc("290.2");
		airPlane.setJzName("�Զ������01");
		airPlane.setFjzName("С��");
		airPlane.setPersonNum(300);
		return airPlane;
	}

	/**
	 * ���ض��������
	 * */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return AirPlane.class;
	}

	
	/**
	 * isSingleton �ǵ�����
	 * false ���ǵ���
	 * true �ǵ���
	 * false��true�ǿ����л���
	 * */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}

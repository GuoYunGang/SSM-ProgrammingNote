package com.spring.factory;

import org.springframework.beans.factory.FactoryBean;

import com.spring.beans.AirPlane;
import com.spring.beans.Book;

/**
 * 创建一个实例工厂的接口
 * 创建一个容器能够认识的factoryBean类，
 * 只要是这个接口实现的类，spring都会认为是工厂
 * */
public class MyFactoryBeanImplements implements FactoryBean<AirPlane>{

	/**
	 * 工厂方法，返回创建的对象
	 * */
	@Override
	public AirPlane getObject() throws Exception {
		// TODO Auto-generated method stub
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("太行-2");
		airPlane.setYc("290.2");
		airPlane.setJzName("自定义机长01");
		airPlane.setFjzName("小刚");
		airPlane.setPersonNum(300);
		return airPlane;
	}

	/**
	 * 返回对象的类型
	 * */
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return AirPlane.class;
	}

	
	/**
	 * isSingleton 是单例吗？
	 * false 不是单例
	 * true 是单例
	 * false和true是可以切换的
	 * */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}

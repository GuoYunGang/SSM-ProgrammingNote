package com.spring.factory;

import com.spring.beans.AirPlane;

/**
 * 飞机实例工厂
 * */
public class AirplaneInstanceFactory {
	
	public AirPlane getAirPlane(String jzName) {
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("太行");
		airPlane.setYc("190.2");
		airPlane.setJzName(jzName);
		airPlane.setFjzName("小刚");
		airPlane.setPersonNum(300);
		return airPlane;
	}
}

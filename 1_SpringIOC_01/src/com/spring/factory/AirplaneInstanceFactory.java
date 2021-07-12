package com.spring.factory;

import com.spring.beans.AirPlane;

/**
 * �ɻ�ʵ������
 * */
public class AirplaneInstanceFactory {
	
	public AirPlane getAirPlane(String jzName) {
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("̫��");
		airPlane.setYc("190.2");
		airPlane.setJzName(jzName);
		airPlane.setFjzName("С��");
		airPlane.setPersonNum(300);
		return airPlane;
	}
}

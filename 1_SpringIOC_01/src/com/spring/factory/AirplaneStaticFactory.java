package com.spring.factory;

import com.spring.beans.AirPlane;

/**
 * 飞机静态工厂
 * */
public class AirplaneStaticFactory {

	/**
	 * 	private String fdj;//飞机发动机
	private String yc;//机翼长度
	private String jzName;//机长名
	private String fjzName;//副机长名
	private Integer personNum;//乘客数
	 * */
	public static AirPlane getAirPlane(String jzName) {
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("太行");
		airPlane.setYc("190.2");
		airPlane.setJzName(jzName);
		airPlane.setFjzName("小刚");
		airPlane.setPersonNum(300);
		return airPlane;
	}
}

package com.spring.factory;

import com.spring.beans.AirPlane;

/**
 * �ɻ���̬����
 * */
public class AirplaneStaticFactory {

	/**
	 * 	private String fdj;//�ɻ�������
	private String yc;//������
	private String jzName;//������
	private String fjzName;//��������
	private Integer personNum;//�˿���
	 * */
	public static AirPlane getAirPlane(String jzName) {
		AirPlane airPlane = new AirPlane();
		airPlane.setFdj("̫��");
		airPlane.setYc("190.2");
		airPlane.setJzName(jzName);
		airPlane.setFjzName("С��");
		airPlane.setPersonNum(300);
		return airPlane;
	}
}

package com.spring.beans;

/**
 * �ɻ���
 * */
public class AirPlane {

	private String fdj;//�ɻ�������
	private String yc;//������
	private String jzName;//������
	private String fjzName;//��������
	private Integer personNum;//�˿���
	
	
	public String getFdj() {
		return fdj;
	}
	public void setFdj(String fdj) {
		this.fdj = fdj;
	}
	public String getYc() {
		return yc;
	}
	public void setYc(String yc) {
		this.yc = yc;
	}
	public String getJzName() {
		return jzName;
	}
	public void setJzName(String jzName) {
		this.jzName = jzName;
	}
	public String getFjzName() {
		return fjzName;
	}
	public void setFjzName(String fjzName) {
		this.fjzName = fjzName;
	}
	public Integer getPersonNum() {
		return personNum;
	}
	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}
	
	@Override
	public String toString() {
		return "AirPlane [fdj=" + fdj + ", yc=" + yc + ", jzName=" + jzName
				+ ", fjzName=" + fjzName + ", personNum=" + personNum + "]";
	}
	
	
}

package com.spring.beans;

/**
 * 飞机类
 * */
public class AirPlane {

	private String fdj;//飞机发动机
	private String yc;//机翼长度
	private String jzName;//机长名
	private String fjzName;//副机长名
	private Integer personNum;//乘客数
	
	
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

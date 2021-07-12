package com.spring.beans;

public class Car {

	private String carName;
	private int price;
	private String color;
	
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", price=" + price + ", color="
				+ color + "]";
	}
	
	
}

package com.lec.java.oop02;

public class Car extends Vehicle{
	private int oil;
	
	// getter & setter
	public int getOil() {
		return this.oil;
	}
	
	public void setOil(int oil) {
		this.oil = oil;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("---- Car 정보 ----");
		System.out.println("speed : " + getSpeed());
		System.out.println("oil : " + oil);
	
	}
}

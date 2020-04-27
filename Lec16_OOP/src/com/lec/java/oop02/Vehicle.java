package com.lec.java.oop02;

public class Vehicle {
	private int speed;
	
	// getter & setter
	public int getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void displayInfo() {
		System.out.println("---- Vehicle 정보 ----");
		System.out.println("speed : " + speed);
	}
}

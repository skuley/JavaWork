package com.lec.java.inner02;

public class Car {
	// 멤버 변수( outer )
	private String color;
	
	// 생성자
	public Car(String color) {
		this.color = color;
	}
	
	// 메소드
	public void displayCarInfo() {
		System.out.println("color: " + color);
	}
	
	public class Tire{
		
		// 멤버변수
		private int radius; // 반지름
		
		
		// 생성자
		public Tire() {
			// TODO Auto-generated constructor stub
		}
		
		public Tire(int r) {
			this.radius = r;
		}
		
		//메소드
		public void displayInfo() {
			System.out.println("--- 자동차 정보 ---");
			System.out.println("color : " + color);
			System.out.println("tire : " + radius);
		}
		
		
	}
	
	
} // end class Car












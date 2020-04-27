package com.lec.java.class02;

public class Rectangle {
	
	// 속성 : member variable
	// 가로, 세로
	double width;
	double height;
	
	
	// 생성자 : constructor
	// 1. default constructor
		public Rectangle() {
			System.out.println("Rectangle() 생성");
			width = 100; // default 지정 가능
			height = 100; // default 지정 가능
			
			System.out.println("가로 : " + width);
			System.out.println("세로 : " + height);
		} // Rectangle()
	
	// 2. member variable constructor
		public Rectangle(double width, double height) {
			// 생성자는 멤버변수 초기화를 위해서 쓴다
			width = width;
			height = height;
			
			System.out.println("Rectangle(w,h) 생성");
			System.out.println("가로 : " + width);
			System.out.println("세로 : " + height);
		}
	
	// 동작 : member method
	// 1. calcPerimeter : 사각형의 둘레
		public double calcPerimeter() {
			return (width * 2) + height;
		}
		
		
	// 2. calcArea : 사각형의 넓이
		public double calcArea() {
			return (width * height) / 2;
		}
		
		
		
}

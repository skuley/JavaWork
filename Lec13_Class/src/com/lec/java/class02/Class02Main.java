package com.lec.java.class02;

 

public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");
		
		Circle c1 = new Circle();
		//멤버 변수를 사용하여 인스턴스를 초기화 할수있다.
		Circle c2 = new Circle(3);
		
		double perimeter = c1.calcPerimeter();
		System.out.println("c1의 둘레 : " + perimeter);
		perimeter = c2.calcPerimeter();
		System.out.println("c2의 둘레 : " + perimeter);
		
		System.out.println("c1의 넓이 : " + c1.calcArea());
		System.out.println("c2의 넓이 : " + c2.calcArea());
		
		System.out.println("------------------------------");
		
		// 삼각형 만들기
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(2, 3);
		
		double recPer = r1.calcPerimeter();
		System.out.println("r1의 둘레 : " + recPer);
		double recArea = r1.calcArea();
		System.out.println("r1의 넓이 : " + recArea);
		
		recPer = r2.calcPerimeter();
		recArea = r2.calcArea();
		System.out.println("r2의 둘레 : " + recPer);
		System.out.println("r2의 넓이 : " + recArea);
		
		
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main











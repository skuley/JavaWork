package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		
//		 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
		Operable opr = new Operator();
		
		double result = opr.operate(10, 20);
		System.out.println("result = " + result);
		
//		 방법 2) 익명클래스
		
		Operable opr2 = new Operable() {
			
			@Override
			public double operate(double x, double y) {
				return x - y;
			}
		};
		
		result = opr2.operate(20, 10);
		System.out.println("result = " + result);
		
		
//		 방법 3) 람다 표현식 lambda expression
		// 
		Operable opr3 = (x, y) -> Math.pow(x, y);
		System.out.println("power expression = " + opr3.operate(2, 3));
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class

// public은 항상 자기 파일  이름과 똑같아야한다?
interface Operable{
	public abstract double operate(double x, double y);
}

class Operator implements Operable{

	@Override
	public double operate(double x, double y) {
		return x + y;
	}
	
}
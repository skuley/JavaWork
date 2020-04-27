package com.lec.java.variables03;

// 실수형 자료 타입: float(4바이트), double(8바이트)
// 정수형 자료 타입의 기본형은 int
// 실수형 자료 타입의 기본형은 double

public class Variable03Main {

	public static void main(String[] args) {
		
		System.out.println("변수 - 실수 타입");
		
//		******* float 과 double *******
		double number1 = 3.141592;
//		float number2 = 3.14; double타입은 float 변수에 대입을 못한다. 왜냐하면 기본적으로 실수 리터럴은 double로 인식
		
//		float형 literal
		float number3 = 3.14f;
		
//		실수 타입 최소 최대값
		System.out.println("float의 최소 ~ 최대값 : " + Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println("double의 최소 ~ 최대값 : " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
//		float : 1.4 * 10^-45
//		double : 4.9 * 10^-324
		
		
//		!!!!!!! 실수 타입은 정확한 값을 기대하면 안됀다 !!!!!!
		
		
//		******* 정밀도의 차이 *******
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		
		System.out.println(number4);
		System.out.println(number5);
//		float 와 double은 저장할 수 있는 값의 크기만이 아니라 
//		소숫점 이하 정밀도(precision)의 차이가 있다.
//		float은 6자리까지 정밀하게 계산한다.
//		double은 13자리까지 정밀하게 계산한다.
		
		
//		******* 실수 표기법 *******
		double number6 = 123; // double 타입에 int 타입이 자동 형변환이 된다 123.0으로 변환된다.
		double number7 = 1.23e2; // 지수 표기법 (exponential notation)
		
		System.out.println(number6);
		System.out.println(number7);
		
		
		double number8 = 0.0001213;
		double number9 = 1.213e-4;
		
		System.out.println(number8);
		System.out.println(number9);
		
		
	} //main

} //class

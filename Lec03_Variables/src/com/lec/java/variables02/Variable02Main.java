package com.lec.java.variables02;

//*******************************
//자바의 기본 자료형(primitive data type) 8개
//정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
//실수 타입: float(4바이트), double(8바이트)
//문자 타입: char(2바이트)
//논리 타입: boolean(1바이트)
//*******************************

public class Variable02Main {

	public static void main(String[] args) {

		System.out.println("정수타입 변수들"); // 자바는 0 ~ 255까지 쓰지 않고 반으로 나눠서 -128 ~ 127까지 사용한다.
		
		System.out.println("byte : " + Byte.MIN_VALUE);
		System.out.println("byte : " +Byte.MAX_VALUE);
		
		byte num1 = -128;
		byte num2 = 0;
		byte num3 = 123;
		byte num4 = (byte) 1234;
		
		System.out.println("short: " + Short.MIN_VALUE + " + " + Short.MAX_VALUE);
		
		short num5 = -12345;
		short num6 = 12345;
		short num7 = 32767;
//		short num8 = 32768;
//		short num9 = -32769;
		
		System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		
//		int num10 = -2147483649; The literal 2147483649 of type int is out of range 
//		long num11 = 9876543210; The literal 9876543210 of type int is out of range 
//		리터럴 : literal
//		코드상에 직접 입력한 값들은 ***무조건*** 리터럴이라고 한다
//			정수리터럴 --> int로 형변환 하려 한다
//			실수리터럴 --> double로 형변환 하려 한다
//			"~" 리터럴 --> String으로 형변환 하려 한다
		
		
//		long 타입의 literal
		long num12 = 9876543210L;
		long num13 = 12; // convert(형변환)가 가능한지 확인부터한다
		long num14 = 12L;
		
		int num15 = 12;
//		int num16 = 12L; long 타입은 int에 대입 불가!!!!!!!!!
		
		
//		값의 경계선
//		정수타입 4가지에서만 나오는 증상이다.
//		******* 이것에 대해 더 알아보기 *******
		byte num16 = Byte.MAX_VALUE;
		byte num17 = (byte)(num16 + 1);
		
		System.out.println("num16 : " + num16);
		System.out.println("num17 : " + num17);
		
//		정수 타입의 대표는 int , 실수 타입의 대표는 double
		
//		03-07-2020
//		정수 표기법
//		진법별로 literal를 표기 할 수 있음
		int number1 = 11; // 10진수 Decimal
		int number2 = 0xB; // 16진수 Hexadecimal , 0x 로 시작
		int number3 = 013; // 8진수 Octal , 0 으로 시작
		int number4 = 0b1011; // 2진수 Binary , 0b 로 시작

		System.out.println("number1 = " + number1);
		System.out.println("number2 = " + number2);
		System.out.println("number3 = " + number3);
		System.out.println("number4 = " + number4);
		
//		******* 직법 변환 *******
//		String.format() 을 사용하여 원하는 포맷(진법)으로 출력 가능
		
//		%x : 16진수로 출력하는 방법
		System.out.println("number1 = " + String.format("%x", number1)); 
		
//		%o : 8진수로 출력하는 방법
		System.out.println("number1 = " + String.format("%o", number1));
		
//		Interger.toXxx(n) 를 사용하여 원하는 포맷의 문자열로 변환 가능
		System.out.println("number1 = " + Integer.toHexString(number1));
		System.out.println("number1 = " + Integer.toOctalString(number1));
		System.out.println("number1 = " + Integer.toBinaryString(number1));

		
		
	} // main

}

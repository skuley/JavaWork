package com.lec.java.variables04;

public class Variable04Main {

	public static void main(String[] args) {

		System.out.println("변수 - char, boolean, String");
		
//		******* char *******
//		char : 문자 하나를 저장하기 위한 데이터 타입 (2바이트)
		char ch1 = 'A';
//		char 리터럴은 홀따옴표('')로 묶어줌
//		문자열 String 리터럴은 싸따옴표("")로 묶어줌
		
		System.out.println("ch1은 " + ch1);
		
		char ch2 = '한';
		char ch3 = '글';
		char ch4 = '짱';
		
		System.out.println("한글짱 = " + ch2 + ch3 + ch4);
		
		
		String s1 = "나는";
		String s2 = "성용";
		String s3 = "이다";
		
		System.out.println(s1 + s2 + s3);
//		String은 char와 다르게 syso에서 문자열로 출력된다.
		
		char ch5 = 0xAE01;
		System.out.println("ch5 = " + ch5); //긁
		
		char ch6 = 1234;
		System.out.println("ch6 = " + ch6);
		
//		println()은 char를 문자로 출력함
//		그러나 다른 정수형으로 변환되면 해당 코드값을 정수로 출력
		char ch7 = '!';
		System.out.println("ch7 = " + ch7);
		char ch8 = 33;
		System.out.println("ch8 = " + ch8);
		
		System.out.println("ch8 + 1 = " + (ch8 + 1));
		System.out.println("ch8 + 1 = " + (char)(ch8 + 1));
		
		char ch9 = 'A';
		char ch10 = 'a';
		System.out.println("ch9 = " + ch9 + "-" + (int)(ch9));
		System.out.println("ch10 = " + ch10 + "-" + (int)(ch10));
		
//		1 까마귀
//		2 가마우지
//		3 직박구리
//		2 - 1 - 3 순서
		
//		1 cable
//		2 bible
//		3 able
//		3 - 2 - 1 순서
		
//		******* boolean *******
//		boolean(논리형) : 참(true) , 거짓(false)
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);
		
		System.out.println(10 < 20);
		System.out.println(10 > 20);
		
		boolean b3 = 10 < 20;
		System.out.println("b3 = " + b3);
		
		
//		******* String 타입 (문자열) *******
//		!!!!!!! primative 타입 아닙니다!!!!!!!
		String name = "Hong";
		String nick = "Thunder";
		System.out.println("이름은 = " + name + "\n별명은 = " + nick);
		
		
		
		
	} // main

} // class

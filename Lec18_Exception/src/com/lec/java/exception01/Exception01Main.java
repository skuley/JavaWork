package com.lec.java.exception01;

import java.util.Scanner;

/* 예외(Exception)
	
	컴파일 에러 : 문법상 오류
	예외(Exception) : 문법상의 오류 가 아닌 '실행중' 에 발생되는 오류상황
	  
	(기본적으로) 예외 가 발생되면, 예외 관련 메세지 출력하고 프로그램이 종료 됩니다.  
 */
public class Exception01Main {

	public static void main(String[] args) {
		System.out.println("예외(Exception)");
		
		System.out.println("[1] ArithmeticException");
		int num1 = 123;
		int num2 = 0;
		// java.lang.ArithmeticException: / by zero --> artimetic : 산술의
		// (Exception01Main.java:21) --> 클릭시 에러 코드로 간다

//		System.out.println("num1 / num2 = " + (num1 / num2));
		
		System.out.println("[2] ArrayIndexOutOfBoundsException");
		int[] numbers = new int[10];
		
		//numbers[10] = 100;
		//  java.lang.ArrayIndexOutOfBoundsException: 10
		
		System.out.println("[3] NegativeArraySizeException");

		// int size = -1;
		// int[] numbers2 = new int[size];
		
		
		System.out.println("[4] NullPointerException");
		String str = null;
		
		// null값 다음에 '.' 붙을수 없다
		//System.out.println("문자열 길이 : " + str.length());
		// aaa = bbb.ccc(ddd[10].eee);
		
		System.out.println("[5] InputMismatchException");  
		Scanner sc = new Scanner(System.in);
	
		sc.nextInt();
		
		sc.close();
		
		
		System.out.println("프로그램 종료");

	} // end main()

} // enc class Exception01Main












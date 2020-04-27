package com.lec.java.Input04;

import java.util.Scanner;

//일반적으로 프로그램에서 숫자입력하는 것이 처음에는 '문자열(String)' 형태다
//ex) 웹, 모바일앱..
//
//이를 숫자 타입으로 변환해야 산술 연산등이 가능해진다
//
//Integer.parseInt(문자열)  -->  int 로 변환
//Double.parseDouble(문자열)  --> double 로 변환

//Byte.parseByte(문자열)
//Short.parseShort(문자열)
//Long.parseLong(문자열)
//Float.parseFloat(문자열)
//Boolean.parseBoolean(문자열)

//문자열이 해당 타입으로 변환할수 없는 문자열이면 NumberFormatException 예외 발생 (에러)

public class Input04Main {

	public static void main(String[] args) {

		System.out.println("입력 : 문자열 -> 숫자 변환");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 3개 : ");
		
		String i1 = sc.next();
		int num1 = Integer.parseInt(i1);
		int num2 = Integer.parseInt(sc.next());
		int num3 = Integer.parseInt(sc.next());
		
		
		System.out.println(num1 + num2 + num3);
		
//		TODO
//		실수 3개를 문자열로 입력받아서 (next())
//		3 실수의 곱을 계산하여 출력하세요.
		
		System.out.print("실수 3개 : \n");
		
		double num4 = Double.parseDouble(sc.next());
		double num5 = Double.parseDouble(sc.next());
		double num6 = Double.parseDouble(sc.next());
		
		System.out.printf("결과 : %.2f",  (num4 * num5 * num6));
		
		sc.close();
		
		
	} // main

} // class

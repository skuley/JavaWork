package com.lec.java.casting;

/*
 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
 * 
 * 		primitive type 에서 implicit casting 방향
 * 
 * 		byte → short → int → long → float → long  
 *                 		↑
 *                    char
 * 
 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
 *      
 *      (변환하고자 하는 타입명)변수/값
 *      
 *      
 *            
 */

public class CastingMain {

	public static void main(String[] args) {

		System.out.println("형변환 (Type Casting / Type Converting)");
		
		byte num1 = 123;
		System.out.println(num1);
		
		int num2 = 123;
//		byte num3 = num2; 자동 형변환 불가!
		byte num3 = (byte)num2; // 명시적 형변환!
		System.out.println(num3);
		
//		******* 명시적 형변환 주의점 *******
		int num5 = (byte)1000;
		System.out.println("num5 = " + num5);
//		명시적 형변환을 할때 주의할점 
//		!!! 데이터 손실 !!! 
		
		double avg = (99 + 88 + 78) / 3;
		System.out.println(avg);
		
		double avg1 = (double)(99 + 88 + 78) / 3;
		System.out.println(avg1);
		
		double avg2 = (99 + 88 + 78) / 3.0;
		System.out.println(avg2);
		
		double avg3 = (99 + 88 + 78) / 3.0f;
		System.out.println(avg3);
		
	} // main

} // class

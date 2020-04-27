package com.lec.java.Input03;

import java.util.Scanner;

public class Input03Main {
	public static void main(String[] args) {
		
		System.out.println("nextLine() vs next()");
		
		Scanner sc = new Scanner(System.in);
		
//		******* nextLine() *******
		System.out.print("여러 단어의 문장을 입력 > ");
		String line = sc.nextLine(); // \n 까지 한 라인 전체 입력
		System.out.println("line : " + line);
		
//		******* next() *******
//		다음 단어(token) 을 받아서 String 으로 결과 리턴
		System.out.println("여러 단어의 문장을 입력 > ");
		String token1 = sc.next();
		System.out.println("token1 : " + token1);
		
//		next() 를 또 실행시키면
//		기존의 버퍼에 담겨 있는 내용들이 담긴다.
		String token2 = sc.next();
		System.out.println("token2 : " + token2);
		
		String token3 = sc.next();
		System.out.println("token3 : " + token3);
		
//		nextInt(), nextDouble()... <--- next() 처럼 동작 함.
//		따라서 숫자 타입도 여러개를 '한줄'로 입력 받으수 있다.
		System.out.println("숫자들 입력 : ");

		int num1 = sc.nextInt();
		System.out.println("num1 : " + num1);
		
		sc.nextInt();
		System.out.println("숫자들 입력 : ");
		
		int num2 = sc.nextInt();
		System.out.println("num2 : " + num2);
		
		int num3 = sc.nextInt();
		System.out.println("num3 : " + num3);
		
		sc.close();
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("숫자 넣으세요 : ");
		int num4 = sc1.nextInt();
		System.out.println("숫자 : " + num4);
		
		sc1.close();
		
	}// main
	
}// class

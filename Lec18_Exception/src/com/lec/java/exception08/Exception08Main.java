package com.lec.java.exception08;

import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);
	
	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException {
		System.out.println("나이 입력:");
		int age = sc.nextInt();

		if(age < 0 || age > 200) {
			AgeInputException e = new AgeInputException();
			throw e;
		
		} // inputAge()
		
		
		return age;
		
	} // end inputAge()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");
		
		System.out.println();

		int age;
		
		try {
		System.out.println("나이를 적어주세요 : ");
		age = inputAge();
		} catch(AgeInputException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("프로그램 종료...");
		
	} // end main()

} // end class Exception08Main













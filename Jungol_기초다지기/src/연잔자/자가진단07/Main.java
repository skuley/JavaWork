package 연잔자.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		2개의 정수를 입력 받아서 논리곱과 논리합의 결과를 출력하는 프로그램을 작성하시오.
//
//		(수가 0 이 아닌 경우 참으로, 0 인 경우 거짓으로 간주합니다.)
//
//		 
//
//		[JAVA]
//
//		2개의 정수를 입력 받아서 0이 아니면 참(true), 0이면 거짓(false)으로 처리하고
//
//		두 값의 논리곱과 논리합의 결과를 출력하는 프로그램을 작성하시오.
//
//		​
//
//		​hint : 정수 a를 입력받은 후 boolean c = (a != 0);을 실행하면 c에 a의 논리값이 저장된다.

		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		boolean n1Result = (n1 != 0);
		boolean n2Result = (n2 != 0);
		
		if(n1Result && n2Result) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
			
		if(!n1Result || !n2Result) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}
		
		
	} // main

}

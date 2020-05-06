package 반복제어문2.형성평가06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 두 개의 정수를 입력받아 두 정수 사이(두 정수를 포함)에 3의 배수이거나 5의 배수인 수들의 합과 평균을 출력하는 프로그램을 작성하시오.
		 * 
		 * (평균은 반올림하여 소수 첫째자리까지 출력한다.)
		 */
		
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = 0;
		
		if(n2 < n1) {
			n3 = n1;
			n1 = n2;
			n2 = n3;
		}
		
		int total = 0;
		double avg = 0;
		int count = 0;
		
		for(int i = n1; i <= n2; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				total += i;
				count++;
			}
		}
		
		avg = ((double)total / count);
		
		System.out.println("sum : " + total);
		System.out.printf("avg : %.1f", avg);
		
	} // main

} // Main

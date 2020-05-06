package 반복제어문2.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 10개의 정수를 입력받아 입력받은 수들 중 짝수의 개수와 홀수의 개수를 각각 구하여 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		int cntEven = 0;
		int cntOdd = 0;
		
		for(int i = 1; i <= 10; i++) {
			int input = sc.nextInt();
			
			if(input % 2 == 0) cntEven++;
			if(input % 2 == 1) cntOdd++;
		
		}
		
		System.out.println("even : " + cntEven);
		System.out.println("odd : " + cntOdd);

	} // main

} // Main

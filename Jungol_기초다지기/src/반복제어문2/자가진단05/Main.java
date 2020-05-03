package 반복제어문2.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int cntThree = 0;
		int cntFive = 0;
		
		for(int i = 1 ; i <= 10; i++) {
			int num = sc.nextInt();
		
			if(num % 3 == 0 && num % 5 == 0) {
				cntThree++;
				cntFive++;
			} else if(num % 3 == 0 ) {
				cntThree++;
			} else if (num % 5 == 0){
				cntFive++;
			}
			
		}
		
		System.out.println("Multiples of 3 : " + cntThree);
		System.out.println("Multiples of 5 : " + cntFive);
		
		

	} // main

} // Main

package 반복제어문3.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 자연수 n을 입력받아서 다음과 같이 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int n = 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = n; j > i; j--) {
				System.out.print('*');
			}
			System.out.println();
			for(int k = i + 1; k > 0; k--) {
				System.out.print(" ");
			}
		}
		
	} // main

} // Main

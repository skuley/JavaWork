package 반복제어문2.형성평가10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 2부터 9까지의 수 중 2개를 입력받아 입력받은 수 사이의 구구단을 출력하는 프로그램을 작성하시오. 
		 * 단 반드시 먼저 입력된 수의 구구단부터
		 * 아래의 형식에 맞게 출력하여야 한다. 구구단 사이의 공백은 3칸이다.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = 0;

		for(int i = 1; i <= 9; i++) {
			if(a < b) {
				c = a;
				a = b;
				b = c;
			}
			for(int j = a; j >= b; j--) {
				System.out.printf("%d * %d = %2d   ", j, i, (j * i));
			}
			System.out.println();
		}
		
	} // main

} // Main

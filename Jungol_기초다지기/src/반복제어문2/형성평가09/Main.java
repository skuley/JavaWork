package 반복제어문2.형성평가09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 정수를 입력받아 다음과 같이 순서쌍을 출력하는 프로그램을 작성하시오.
		 * 
		 * 
		 * 
		 * 주의
		 * 
		 * ')'와 '('사이에 공백이 1칸 있다. (1,_1) 처럼 출력한다 : '_'는 공백
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for(int i = 1; i <= input; i++) {
			for(int j = 1; j <= input; j++) {
				System.out.printf("(%d, %d) ", i, j);
			}
			System.out.println();
		}

	} // main

} // Main

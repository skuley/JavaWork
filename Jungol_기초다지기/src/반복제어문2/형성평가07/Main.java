package 반복제어문2.형성평가07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 한 개의 자연수를 입력받아 그 수의 배수를 차례로 10개 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = 0;
		
		for(int i = 1; i <= 10; i++) {
			if(n % n == 0) {
				result += n;
				System.out.print(result + " ");
			}
		}

	} // main

} // Main

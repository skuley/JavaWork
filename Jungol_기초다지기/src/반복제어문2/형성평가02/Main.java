package 반복제어문2.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 100 이하의 두 개의 정수를 입력받아 작은 수부터 큰 수까지 차례대로 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = 0;
		
		
		if(n1 < 100 && n2 < 100) {
			if(n1 < n2) {
				for(int i = n1; i <= n2;) {
					System.out.println(i++);
				}
			} else if(n2 < n1) {
				n3 = n1;
				n1 = n2;
				n2 = n3;
				for(int j = n1; j <= n2;) {
					System.out.println(j++);
				}
			} else {
				System.out.println(n1);
			}
		}
		
	} // main

} // Main

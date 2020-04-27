package 선택제어문.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int result;
		
		if(n1 > n2) {
			result = n1 - n2;
		}else {
			result = n2 - n1;
		}
		
		System.out.println(result);

	} // main

}

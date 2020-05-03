package 반복제어문2.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 10 이하의 자연수 n을 입력받아 "JUNGOL​"을 n번 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int count = sc.nextInt();
		
		if(count <= 10) {
		for(int i = 1; i <= count; i++) {
			System.out.println("JUNGOL");
		}
		}

	}

}

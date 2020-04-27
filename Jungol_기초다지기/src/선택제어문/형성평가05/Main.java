package 선택제어문.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1~12사이의 정수를 입력받아 평년의 경우 입력받은 월을 입력받아 평년의 경우 해당 월의 날수를 출력하는 프로그램을 작성하시오.
		// 평년의 경우 1월부터 12월까지 일수는 각각 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31일이다.

		Scanner sc = new Scanner(System.in);
		
		int month = sc.nextInt();
		int day = 0;
		
		switch (month) {
		case 2:
			day = 28;
			break;
		case 1: case 3: case 5: case 7: case 8:
		case 10: case 12:
			day = 31;
			break;
			
		case 4: case 6: case 9: case 11:
			day = 30;
			break;
		}
		System.out.println(day);
		sc.close();
		
	} // main

}

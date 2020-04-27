package 선택제어문.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 년도를 입력받아 윤년(leap year)인지 평년(common year)인지 판단하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		if(year % 400 == 0) {
			System.out.println("leap year");
		} else if(year % 4 == 0 || year % 100 != 0){
			System.out.println("leap year");
		} else {
			System.out.println("common year");
		}
		
	} // main

}

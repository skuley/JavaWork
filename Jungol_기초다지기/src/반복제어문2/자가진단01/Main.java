package 반복제어문2.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 문자를 입력받아서 입력받은 문자를 20번 반복하여 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		for(int i = 1; i <= 20; i++) {
			System.out.print(input);
		} // for

	} // main

} // Main

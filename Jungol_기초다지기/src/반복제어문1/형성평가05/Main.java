package 반복제어문1.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 삼각형의 밑변의 길이와 높이를 입력받아 넓이를 출력하고, 
		// "Continue? "에서 하나의 문자를 입력받아 그 문자가 'Y' 나 'y' 이면 작업을 반복하고 다른 문자이면 종료하는 프로그램을 작성하시오.
		
		// (넓이는 반올림하여 소수 첫째자리까지 출력한다.)​
		
		Scanner sc = new Scanner(System.in);
		
		String input;
		int base;
		int height;
		double area;
		
		while(true) {
			
			System.out.print("Base = ");
			base = sc.nextInt();
			System.out.print("Height = ");
			height = sc.nextInt();
			area = (double)(base * height) / 2;
			System.out.println("Triangle width = " + area + "");
			System.out.print("Continue? ");
			input = sc.next();
			if(input.equals("Y") || input.equals("y")) {
				continue;
			} else {
				break;
			}
		} // while

	} // main

} // Main

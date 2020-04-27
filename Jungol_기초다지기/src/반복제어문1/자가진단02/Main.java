package 반복제어문1.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 100 이하의 양의 정수만 입력된다. while 문을 이용하여 1부터 입력받은 정수까지의 합을 구하여 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int result = 0;
		if(num <= 100) {
		while(num >= 1) {
			result += num--;
		}
		}
		System.out.println(result);
		
	} // main

}

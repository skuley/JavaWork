package 반복제어문3.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 자연수 n을 입력받아서 다음과 같이 출력하는 프로그램을 작성하시오.

		Scanner sc = new Scanner(System.in);
		int star = sc.nextInt();

		for (int i = 1; i <= star; i++) {
			for (int j = star; j >= i; j--) {
				System.out.print('*');
			}
			System.out.println();
		}
		for (int i = 1; i <= star; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print('*');
			}
			System.out.println();
		}

	} // main

} // Main

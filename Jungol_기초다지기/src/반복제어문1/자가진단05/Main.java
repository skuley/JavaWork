package 반복제어문1.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int num = sc.nextInt();
			if (num % 3 == 0) {
				System.out.println(num / 3);
			}
			if (num == -1) {
				break;
			}
		}
	} // main

}

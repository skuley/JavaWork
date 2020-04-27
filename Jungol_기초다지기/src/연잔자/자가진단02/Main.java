package 연잔자.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int first, second;
		
		Scanner sc = new Scanner(System.in);
		
		first = sc.nextInt() + 100;
		second = sc.nextInt() % 10;
		
		System.out.printf("%d %d", first, second);
	} // main()

} // Main

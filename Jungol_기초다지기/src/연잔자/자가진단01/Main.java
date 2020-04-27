package 연잔자.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int num1, num2, num3;
		int sum, avg;
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
		sum = num1 + num2 + num3;
		avg = sum / 3;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
		
	} // main()

} // Main

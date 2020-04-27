package 연잔자.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 두 정수를 입력받아 첫 번째 수는 전치증가연산자를 사용하고 두 번째 수는 후치감소연산자를 사용하여 출력하고 바뀐 값을 다시 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		System.out.print(++n1 + " ");
		System.out.println(n2--);

		System.out.print(n1 + " ");
		System.out.println(n2);
		
	} // main

}

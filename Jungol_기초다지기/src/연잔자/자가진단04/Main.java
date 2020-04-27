package 연잔자.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 두 개의 정수를 입력받아 각각 후치 증가 연산자와 전치 감소 연산자를 사용하여 두 수의 곱을 구한 후 각각의 값을 출력하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int result = n1++ * --n2;
		
		System.out.printf("%d %d %d", n1, n2, result);
		
		
	}

}

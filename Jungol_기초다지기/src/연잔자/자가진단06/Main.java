package 연잔자.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 두 개의 정수를 입력받아서 다음과 같이 4가지 관계연산자의 결과를 출력하시오.

		// 이때 입력받은 두 정수를 이용하여 출력하시오.

		// (JAVA는 1이면 true, 0이면 false를 출력한다.)

		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		System.out.println(n1 + " > " + n2 + " --- " + (n1 > n2));
		System.out.println(n1 + " < " + n2 + " --- " + (n1 < n2));
		System.out.println(n1 + " >= " + n2 + " --- " + (n1 >+ n2));
		System.out.println(n1 + " <= " + n2 + " --- " + (n1 <= n2));
		
	} // main

}

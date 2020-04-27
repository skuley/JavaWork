package 선택제어문.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		3개의 정수를 입력받아 조건연산자를 이용하여 입력받은 수들 중 최소값을 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int n1, n2, n3;
		
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();

		if(n1 < n2 && n1 < n3){
			System.out.println(n1);
		} else if(n2 < n1 && n2 < n3) {
			System.out.println(n2);
		} else {
			System.out.println(n3);
		}
	}

}

package 연잔자.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 민수와 기영이의 키와 몸무게를 입력받아 민수가 키도 크고 몸무게도 크면 1 그렇지 않으면 0을 출력하는 프로그램을 작성하시오.
		// (JAVA는 1 이면 true, 0 이면 false를 출력한다.)
		
		Scanner sc = new Scanner(System.in);
		
		int minHeight = sc.nextInt();
		int minWeight = sc.nextInt();
		
		int gaHeight = sc.nextInt();
		int gaWeight = sc.nextInt();
		
		int minTotal = minHeight + minWeight;
		int gaTotal = gaHeight + gaWeight;
		
		System.out.println((minTotal > gaTotal) ? true : false);
		
	} // main

}

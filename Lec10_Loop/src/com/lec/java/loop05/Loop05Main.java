package com.lec.java.loop05;

public class Loop05Main {

	public static void main(String[] args) {
		System.out.println("순환문 연습 - 언제 100을 넘나?");
		// 1 + (-2) + 3 + (-4) + ...+ (n) >= 100 ?
		// 언제(n) 합이 100을 넘나?  그 합은?
		
		int total = 0;
		for(int i = 1; total < 100; i++) {
			int temp;
			if(i % 2 == 1) {
				// 홀수인 경우 숫자 그대로
				temp = i;
			} else {
				// 짝수인 경우 숫자에 음수(-)
				temp = -i;
			} // end else
			total = total + temp; // total += temp
			System.out.println("i = " + i + ", sum = " + total);
		} // for
		
		
		
		
		System.out.println();
		System.out.println("순환문 연습 - 두 주사위 눈의 합");
		// 두 주사위 눈의 합 = 6
		// (1, 5), (2, 4), (3, 3), (4, 2), (5, 1)
		// x + y = 6를 만족하는 x, y 쌍을 찾으면 됨.
		
		// TODO
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

















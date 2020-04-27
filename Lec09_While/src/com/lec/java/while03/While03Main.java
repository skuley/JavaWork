package com.lec.java.while03;

public class While03Main {

	public static void main(String[] args) {
		System.out.println("while 연습");
		
//		1 ~ 10 가지 수 중에서 홀수
		int num = 1;
		while(num <= 10) {
			if( num % 2 == 1) {
				System.out.println(num);
			}
			num++;
		}
		
		while(num <= 10) {
			System.out.println(num);
			num += 2;
		}
		

	} // end main()

} // end class While03Main










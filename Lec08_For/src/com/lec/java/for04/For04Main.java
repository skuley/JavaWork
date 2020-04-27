package com.lec.java.for04;

public class For04Main {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		
//		1 ~ 100 사이 2와 7 공배수만 출력
//		2와 7 사이 공배수 : 2의 배수 && 7의 배수
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0 && i % 7 ==0) {
				System.out.println(i);
			}
		}
		
//		1 ~ 10까지의 합
		
		int total = 0;
		for(int i = 1; i <= 10; i++) {
			total += i; //누적 합산
		}
		System.out.println(total);
			
		
	} // end main ()

} // end class For04Main











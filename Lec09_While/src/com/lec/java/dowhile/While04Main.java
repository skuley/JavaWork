package com.lec.java.dowhile;

/*
do {
	...
	...
}while(조건식) 문인 경우에는,

{...} 안에 있는 실행문들을 한번은 실행을 하고 나서
조건식을 검사하게 된다.

*/

public class While04Main {

	public static void main(String[] args) {
		System.out.println("do-while문 연습");
		
		int n = 0;
		while(n > 0) {
			System.out.println("카운트 다운 : " + n);
			n--;
		} // 한번도 실행 안돼고 끝이 난다. 왜냐면 0 이 0보다 클수는 없기 땜이다
		
		
//		******* do while은 일단 한번은 실행된다 ********
		do {
			System.out.println("카운트 다운 : " + n);
			n--;
		}while(n > 0);
		
//		구구단
		int gugu = 9;
		do {
			System.out.println("9 * " + gugu + " = " + (gugu * 9));
			gugu--;
		} while (gugu >= 1);
		
		
		
	} // end main()

} // end class While04Main










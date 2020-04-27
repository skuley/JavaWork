package com.lec.java.if01;


/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) { !!! boolean 값이 와야한다 !!!
 *  	조건식이 true 일때 실행되는 문장(들)  
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 *  
 *  
 *  
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		int num = -10;
		
		if(num < 0) {
			System.out.println("음수입니다.");
		}
		
		if(num > 0) {
			System.out.println(num + "은 양수입니다.");
		} else {
			System.out.println(num + "은 양수가 아닙니다.");
		}
		
		
//		수행 문장이 하나뿐이면 굳이{..} 블럭 안 잡아도 된다.
		if(num < 0)
			System.out.println("음수");
		else
			System.out.println("0 혹 양수");
		
		System.out.println("\n프로그램 종료");
		
		
//		주어진 숫자가 짝수/홀수 확인
		int num3 = 125;
		
		if(num3 % 2 == 0) {
			System.out.println(num3 + "는 짝수 입니다.");
		} else {
			System.out.println(num3 + "는 홀수 입니다.");
		}
		
		
//		주어진 숫자가 0 ~ 100 점까지 범위 확인
		int num4 = 100;
		
		if(num4 >= 0 && num4 <= 100 ) {
			System.out.println("0 ~ 100 사이 점수 입니다.");
		} else {
			System.out.println("0 ~ 100 점수를 초월했습니다.");
		}
		
		
		
	} // end main()

} // end class

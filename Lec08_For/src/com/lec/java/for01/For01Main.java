package com.lec.java.for01;


/*
 * ■ 순환문(loop)
 * 	- for
 * 	- while
 * 	- do ~ while

 * 
 * ■ for 순환문 구문
 * 
 * for(①초기식; ②조건식; ④증감식){
 * 		③수행문;
 * 		..
 * }
 *      ①초기식 : 최초에 단한번 수행
 *      ②조건식 : true / false 결과값
 *      		위 조건식의 결과가 false 이면 for문 종료
 *      ③수행문 : 위 조건식이 true 이면  수행
 *      ④증감식 : 수행문이 끝나면 증감식 수행
 *               증감식이 끝나면 다시 ②조건식 으로.. 
 * 
 * 순환문을 작성시 내가 만드는 순환문에 대해 다음을 확실하게 인지하고 작성해야 한다
 * 1. 몇번 순환하는 가?
 * 2. 순환중에 사용된 인덱스값의 시작값과 끝값은? 
 * 3. 순환문이 끝난뒤 인덱스값은?
 * 
 * 
    for문 작성시 TIP
	 1) n번 순환 하는 경우 (즉 횟수가 촛점인 경우)
	 for(int i = 0; i < n; i++){ .. }
	
	 2) a ~ b 까지 순환하는 경우 (즉 시작값과 끝값이 중요한 경우)
	 for(int i = a; i <= b; i++){ .. }
 */


public class For01Main {

	public static void main(String[] args) {
		System.out.println("for 반복문");
		
		for(int i = 1; i <= 100; i++) {
			System.out.println("Hello Java" + i);
		}
		
		for(int i = 1; i <= 10; i++) {
			System.out.println("i : " + i);
		}
		
		
		for(int i = 10; i > 0; i--) {
			System.out.println("i : " + i);
		}
		
		System.out.println();

		for(int i = 10; i >= 1; i--) {
			System.out.println("i : " + i);
		}
		
//		초기식과 증감식에 식을 여러개 사용 가능
		int i, j;
		for(i = 0, j = 10; i < j; i++, j -= 2) {
			System.out.println("i : " + i + "\nj : " + j + "\n");
		}
		
		
//		지역변수 : local variable
//		블럭 {..} 안에서 선언한 변수는
//		선언한 이휴 그블럭 안에서만 사용 가능
//		블럭이 끝나면 소멸됨
		
		
		for(int k = 1; k % 27 != 0; k += 4) {
			System.out.println("k = " + k);
		}
//		for 블럭안에서 선언한 변수는 바깥에서 사용 불가

		
		{
			int a = 100;
			System.out.println("a = " + a);
			{
//				int a = 200;
//				안쪽의 블럭은 바깥쪽 블럭의 지역변수 사용 가능
//				바깥블럭 지역 변수와 동일 일므의 변수 사용 불가 	
			}
		}
		
		
		System.out.println("프로그램 종료");
		
		
	} // end main()

} // end class For01Main










package com.lec.java.inherit03;

/* java.lang.Object
 * 	자바의 모든 클래스는 java.lang.Object로부터 상속 받는다.
 *  java.lang.Object 클래스는 모든 클래스의 부모클래스이다.
 *  Object 클래스에 있는 메소드를 다른 클래스에서도 사용 가능
 *  Java에서는 하나의 부모로부터 상속받는다 !!! 단일 상속 !!!!
 *  다중 상속을 허용하지 않는다
 */
public class Inherit03Main {

	public static void main(String[] args) {
		System.out.println("상속 연습");
		System.out.println("java.lang.Object");
		
		Person p1 = new Person();
		p1.name = "흥부"; // 
		p1.whoAmI();
		
		BusinessPerson bp = new BusinessPerson();
		bp.whoAmI();
		bp.name = "놀부";
		bp.company = "코리아IT아카데미";
		bp.showInfo();
		
		System.out.println();
		
		System.out.println(bp); // 내부적으로는 bp.toString() 의 결과값이 출력
		
		System.out.println(bp.toString()); // toString()은 object 소속 메소드
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class










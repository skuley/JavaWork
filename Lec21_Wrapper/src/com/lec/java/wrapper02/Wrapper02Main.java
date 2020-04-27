package com.lec.java.wrapper02;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");

		// primitive 타입을 refernce 타이에 자동적으로 대입해주는것을 auto-boxing
		Integer num1 = 10; // Integer.valueOf(10); --> 내부적으로 동작하게 하는것을 Auto-Boxing
		Integer num2 = 20;
		// boxing 되어있던 unboxing을 해야한다
		System.out.println(num1 + num2); // auto-unboxing
		System.out.println(num1.intValue() + num2.intValue()); // 이와 같이 동작
		
		Integer num3 = num1 + num2;
		
		// 내부적으로 꺼내고 다시 담는것을 보여주기 위한 동작을 보여준다.
		Integer num30 = Integer.valueOf(num1.intValue() + num2.intValue());
		
		System.out.println();
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
		
		Integer num4 = 100; //Integer.valueOf(100);
		int n4 = num4;
		System.out.println("n4 = " + n4);
		
		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");

		Long num100 = Long.valueOf(100000000000000L);
		long n5 = num100;
		System.out.println("n5 = " + n5);
		
		
		// ***** unboxing 할때는 내가 원하는 타입으로 꺼낼수 있따 *****
		System.out.println(num1.doubleValue());
		
		System.out.println();
		System.out.println("wrapper 클래스들");
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















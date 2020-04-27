package com.lec.java.method07;

import java.util.Random;

/* Math 클래스의 메소드
 */
public class Method07Main {

	public static void main(String[] args) {
		System.out.println("Math 객체의 메소드");

		// Math.random() : 0.0 <=  r < 1.0 사이의 난수 발생(double)
		double r;
		for(int i = 0; i < 10; i++) {
			r = Math.random();
			System.out.println(r);
		}
		
		System.out.println();
		// double Math.floor(num): num을 넘지 않는 가장 큰 정수(바닥)
		// double Math.ceil(num): num보다 큰 가장 작은 정수(천장)
		// long Math.round(num): num에서 소수점 사사오입 (반올림)
		System.out.println(Math.floor(2.7));
		System.out.println(Math.ceil(2.7));
		System.out.println(Math.round(2.7));
		
		System.out.println(Math.floor(-1.2));
		System.out.println(Math.ceil(-1.2));
		System.out.println(Math.round(-1.2));
		
		System.out.println(Math.floor(-2.8));
		System.out.println(Math.ceil(-2.8));
		System.out.println(Math.round(-2.8));

		
		System.out.println();
		System.out.println("1,2,3 범위중 난수 발생시키기");
		for(int i = 0; i < 5; i++) {
			double num = Math.random();
			num *= 3;
			num++;
			System.out.println((int)num);
		}
		
		System.out.println();
		System.out.println("로또: 1 ~ 45 숫자중에서 랜덤으로 6개 출력");
		for(int i = 0; i < 6; i++) {
			double num = Math.random();
			num *= 45;
			num++;
			System.out.println((int)num);
//			System.out.println((int)(Math.random() * 45 + 1) + " ");
		}
		
		
		System.out.println();
		System.out.println("Random 객체 사용하여 난수 출력");
		Random rnd = new Random();
		// 0 , 1 , 2 사이 난수 5개 발생
		for(int i = 0; i < 5; i++) {
			System.out.print(rnd.nextInt(3) + ", "); // 0 ~ 3 사이 (3은 아님) 정수를 랜덤으로 돌린다.
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	// TODO

} // end class










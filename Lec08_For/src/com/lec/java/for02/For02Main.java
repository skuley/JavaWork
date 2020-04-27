package com.lec.java.for02;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		
//		2 x 1 = 2
//		2 x 2 = 4
//		...
//		2 x 9 = 18
		
		System.out.println();
		
		for(int i = 1; i <= 9; i++) {
			int mul = 2 * i;
			System.out.println("2 x " + i + " = " + mul);
		}
		
		for(int i = 1; i <=9; i++) {
			int mul = 4 * i;
			System.out.println("4 x " + i + " = " + mul);
		}
		
		for(int i = 2; i <= 9; i++) {
			int mul = i * i;
			System.out.println(i + " * " +  i + " = " + mul);
		}
		

	} // end main()

} // end class For02Main













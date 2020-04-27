package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
//		2 x 1 = 2
//		2 x 2 = 4
//		...
//		9 x 9 = 81

		for (int dan = 2; dan <= 9; dan++) {
			System.out.println(dan + "단");
			for (int num = 1; num <= 9; num++) {
				System.out.println(dan + " x " + num + " = " + (dan * num));
			}
			System.out.println();
		}

		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		int dan = 2;
		int num = 1;
		while(dan <= 9) {
			while(num <= 9) {
				System.out.println(dan + " x " + num + " = " + (dan * num));
				num++;
			} 
			num = 1;
			dan++;
		}
			
			

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

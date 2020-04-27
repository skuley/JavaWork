package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[5];
		int total = 0;
		
		for (int i = 0; i < num.length; i++) {
			System.out.println("점수 입력 : ");
			num[i] = sc.nextInt();
			total += num[i];
		} // for
		sc.close();
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (double)total / num.length);
		
		
		// 최댓값
		int max = num[0];
		for (int i = 1; i < num.length; i++) {
			if(num[i] > max) {
				max = num[i];
			}
		} // for
		System.out.println("최댓값 : " + max);
		
		//최소값
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			if(num[i] < min) {
				min = num[i];
			}
//			min = (num[i] < min) ? num[i] : min;
 		} // for
		System.out.println("최소값 : " + min);
		
	} // end main()

} // end class Array04Main









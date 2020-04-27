package com.lec.java.array05;

import java.util.Scanner;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 * 1차원 배열 (one-dimensional array) 이라고 함
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다
*/
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		
		// 1차원 배열
		int[] arr1 = {1, 2};
		int[] arr2 = {3, 4};
		int[] arr3 = {5, 6};
		
		// 2차원 배열 : (배열원소가 1차원배열)
		// 1차원 배열 x 3개 갖고 있는 2차원 배열
		int[][] array = {
				{1, 2},  // array[0]
				{3, 4},	 // array[1]
				{5, 6}   // array[2]
		};
		
		System.out.println(array[0][0]); //배열의 첫번째 배열의 첫번째 값
		System.out.println(array[0][1]);
		System.out.println(array[1][0]);
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]);
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println(array[i][j]);
			}
		}
		
		// 흔히 2차원 배열을 '행' 과 '열' 로 표기 한다
		// 위 array 는 3행 2열인 2차원 배열이다
		
		
		System.out.println(array.length);
		
		// array 의 타입 --> int[][]
		// array[0] 의 타입 --> int[]
		// array[0][0] 의 타입 --> int
		
		System.out.println("array[0].length : " + array[0].length);
		
		// 2차원 배열 원소, for
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			} // for (j)
			System.out.println();
		} // for (i)
		
		// ***********************************************************************
		
		// TODO: 
				// 2행 4열의 2차원배열 두 개를 만들어서 
				// 아래와 같이 초기화하고 출력하기
				
				// 첫번째 배열 출력
				// 1 2 3 4
				// 5 6 7 8	
				
				// 2행 4열
		
		int[][] num = {
				{1, 2, 3, 4},
				{5, 6, 7, 8}
		};
		
		System.out.println("num " + num.length);
		
		for (int i = 1; i < num.length; i++) {
			for (int j = 0; j < num[i].length; j++) {
				System.out.print(num[i][j] + " ");
			}
			System.out.println();
		}// for
		
		System.out.println();
		
		System.out.println(array);
		System.out.println(array[0]); // 4바이트???
		System.out.println(array[1]);
		System.out.println(array[2]);
		
		// java에서는 배열의 원소의 주소가 따로따로 지정된다.
		
		
	} // end main()

} // end class Array05Main










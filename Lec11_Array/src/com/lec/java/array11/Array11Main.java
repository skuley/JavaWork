package com.lec.java.array11;

/* for와 enhanced for의 차이점
	 enhanced for문에서는 배열의 원소를 꺼내서
	 변수에 복사(저장)해서 사용하는 것입니다.
	 즉, 배열의 원소를 직접 변경하는 것은 불가능하다.
 */
public class Array11Main {

	public static void main(String[] args) {
		System.out.println("for와 enhanced for의 차이점");
		
		int[] arr1 = {10, 20, 30, 40, 50};
		
		System.out.println();
		
		System.out.println("증가전");
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
		System.out.println();
		
		System.out.println("증가후");
		// 배열의 원소를 +1씩 중가시킨다
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] += 1;
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
		// ***********************************************
		
		System.out.println();
		
		//Enhanced-for 문
		System.out.println("Enhaced-for");
		int[] arr2 = {10, 20, 30, 40, 50};
		for(int x : arr2) {
			System.out.print(x + " ");
		}
		System.out.println();
		
	} // end main()

} // end class Array11Main










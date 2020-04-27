package com.lec.java.method09;

/*  Call By Value : 값에 의한 호출
 	Call By Reference : 참조에 의한 호출
 	
 	메소드 호출시 매개변수에 넘겨주는 값의 '복사' 가 발생.
 	
 	자바에선
 	primitive type 이 매개변수 인 경우 Call By Value
 	 		: '값' 이 복사된다 
 	 		: 메소드에서 매개변수 값을 변경해도 호출한 원본 쪽은 변화 없슴
 	 		
 	reference type 이 매개변수 인 경우 Call By Reference 발생
 			: '주소' 가 복사된다.
 			: 메소드에서 매개변수 를 통해 변경하면 호출한 원본 쪽도 변화 발생
 	
 */
public class Method09Main {

	public static void main(String[] args) {
		System.out.println("Call By Value : 값에 의한 호출");
		System.out.println("Call By Reference : 참조에 의한 호출");

		// 호출한 곳에서의 값은 변하지 않는다
		int n = 10;
		incNum(n);
		System.out.println("incNum(int) 호출후 n : " + n);
		
		System.out.println();
		int[] arr = {10};
		incNum(arr);
		System.out.println("incNum(int[]) 호출후 n : " + arr[0]);
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
//	*********************************************
//	* 메소드가 호출 된때 jvm 메모리에 복사가 되어 저장된다.      *
//	* 값이 복사가 될 경우는 호출이 종료가 되었을때는 복사가 지워진다. *
//	* 하지만 주소가가 복사가 될 경우는 힙에 들어가는 값이 변하고          *
//	* 스텍에 있는 주소값이 지워지기 때문에 값은 그대로 남는다.      *
//	*********************************************
	
	public static void incNum(int value) {
		value++;
		System.out.println("incNum(int) : " + value);
	} // incNum()
	
	public static void incNum(int[] arr) {
		arr[0]++;
		System.out.println("incNum(int[]) : " + arr[0]);
	}
	
} // end class

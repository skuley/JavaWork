package com.lec.java.method01;

/* 메소드 (Method):
 		반복되는 코드, 내용, 재사용해야할 코드들을 한 뭉치로 묶어서
 		따로 메소드로 만들은 다음(정의) 이를 필요할때마다 사용(호출)한다. 
 		
 		※ 자바는 '함수(function)' 가 따로 없습니다
 		  그러나 교육하면서 편의상, 혼용하여 말하겠습니다.
 		
	 메소드 정의:
	 	메소드는 main 메소드 바깥에서!!, class 안에서 정의!!

	 메소드 정의구문:
		수식어        리턴타입              메소드이름(매개변수, ...) { ... }
	    modifier return_type  method_name(parameter, ...) { ... }
	
		수식어(modifier) : public, static, private, ... (생략 가능)
	   
		매개변수 (parameter) : 메소드 호출시 넘겨주는 값.

		리턴타입 (return type) : 메소드 종료후 호출한 쪽에 돌려주는 값
			void, int, double, String ...
			(리턴타입 void의 의미는 되돌려주는 값(return 값)이 없다는 의미)
	
	메소드 signature 란?:
		메소드 이름 + 매개변수 리스트 (매개변수 타입, 순서, 개수)
			sayAge(int)
			sayHello3(String, int)
			
	메소드 정의가 어디인지 알고 싶으면 f3
	
	메소드가 어디서 호출되고 있지? Ctrl + Alt + h
			
*/

public class Method01Main {
	
	public static void main(String[] args) {
		System.out.println("메소드(함수) Method(Function)");
		
		// 이름만 빼고 나머진 반복되기 때문에 이것을 method로 묶어서 코드를 줄여준다.
		System.out.println("안녕하세요");
		System.out.println("제 이름은 홍성용입니다");
		
		System.out.println("안녕하세요");
		System.out.println("제 이름은 이강혁입니다");
		
		System.out.println();
		System.out.println("메소드 사용(호출)");
		
		// 메소드 호출구문
		// 메소드 이름(매개변수값(들)..)
		// 메소드 호출 : method call, method invoke
		sayHello("장수영");
		sayHello("고유성");
		
		System.out.println();
		
		sayAge(20);
		sayAge(35);
		
		System.out.println();
		
		
		// ******* sayHello2 *******
		sayHello2("장수영", 20);
//		sayHello2(100, 235); !!! not applicable for the arguments !!! (int, int) : 정의 되어 있는것과 다르게 호출하려 하면 나온다
		
		System.out.println();
		
		// ******* sayHello3 *******
		sayHello3("방석민", 26);
		System.out.println("\n프로그램 종료");
		
		System.out.println(yourAge(20));
		
		
	} // end main()
	
	// ******* Method 정의 위치 *******
	// method 이름 : sayHello
	// 매개변수 (parameter) : name (모든 method에 매개변수가 필요하진 않는다. 필요 없는 경우는 생략가능)
	
	// 메소드 위에 아래와 같이 javadoc 타입 주석 달수 있다.
	/**
	 * 메소드이름 : sayHello
	 * 주어진 이름을 출력합니다
	 * @param name 이름
	 */
	public static void sayHello(String name) {
		//수식어 (modifier) return 값(void)  메소드 이름 (매개변수)
		System.out.println("안녕하세요");
		System.out.println("제 이름은 " + name + " 입니다");
	} // end sayHello
	
	// method 이름 : sayAge
	// parameter : int 타입의 age
	// return값 : void (return 값이 없다)
	
	public static void sayAge(int age) {
		System.out.println("Hi");
		System.out.println(" 제 나이는 " + age + "살 입니다");
	} // end sayAge
	
	/*public static void sayId(String name, int age) {
		System.out.println(name, age);
	}*/
	
	// 메소드 이름 : sayHello2
	// 매개변수 : 
	// 1) String name
	// 2) int age
	// return type : void
	public static void sayHello2(String name, int age) {
		System.out.println("안녕!");
		System.out.println("내 이름은 " + name + " 입니다.");
		System.out.println("내 나이는 " + age + "살 입니다.");
	} // sayHello2 end
	
	public static void sayHello3(String name, int age) {
		sayHello(name); // name을 호출
		sayAge(age); // sayHello / sayAge 로 가서 각각 처리를 해준 다음 리턴리턴해줌.
	} // sayHello3
	
	public static int yourAge(int num) {
		return num;
	} // yourAge

} // end class

/*
 * 이클립스 단축키 : 메소드 이름위에서
 * 	F3 : Open Declaration  (이 메소드 는 어디서 정의?)
 * 	CTRL + ALT + H : Open Call Hierarchy (이 메소드는 어디서 호출되나?)
 * 
 * 디버깅 :
 *   step into : 현재 디버깅 위치의 메소드 호출 내부 코드 진입
 *   step out (step return) : 현재 디버깅 진행중인 메소드 return 까지 진행후 호출한 측으로 돌아감
 *   resume : 다음 breakpoint 까지 쭈욱 진행 
 */









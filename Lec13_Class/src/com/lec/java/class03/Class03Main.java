package com.lec.java.class03;

/*
	캡슐화, 은닉, 추상화

	클래스 안에 필요한 '속성' 과 '행동' 을 멤버로 묶고
	외부에서의 '직접적인 접근을 제한'하여
	객체의 데이터 와 메소드를 은닉(hiding)하고, 
	사용자에게는 필요한 기능만 제공하여 추상화(abstraction) 하는   
	객체지향 기술을 '캡슐화(encapsulation)' 라고 한다
	
	
	클래스의 멤버변수를 접근하기 위한 기능을 제공하는 메소드를 
	getter , setter 라 한다
*/
public class Class03Main {

	public static void main(String[] args) {
		System.out.println("Getter & Setter");
		
		Number n1 = new Number(100, 'A');
		// not visible : 볼수 없다는 에러
//		n1.num = 200;
		// cannot be resolved == 열에 아홉은 오타 에러다
		
		System.out.println(n1.getNum());
		// setter로 값을 넣어줘서 
		n1.setNum(200);
		System.out.println(n1.getNum());
		
		// setter에 제어를 걸어준다
		// 이를 통해 데이터 보호를 할 수 있다.
		n1.setNum(-2);
		

		System.out.println("프로그램 종료");
	} // end main()
} // end class Class03Main















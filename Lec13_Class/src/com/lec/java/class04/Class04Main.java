package com.lec.java.class04;
/*
   클래스 안에서 this : 
	객체 내에서 자기자신(인스턴스)을 가리킴

   메소드 체이닝 (method chaining)
 	자기자신을 리턴하여, 연이어 메소드
 	호출 가능케 하는 메소드 설계
 	보통 setter 와 이와 같은 동작을 수행하는 메소드들에 적용하면 좋다
*/
public class Class04Main {

	public static void main(String[] args) {
		System.out.println("this & 메소드 체이닝");
		
		Number num = new Number(); 
		// 멤버변수가 private이기 땜누에
		System.out.println("num.getNum() : " + num.getNum());
		
		Number num2 = new Number(123);
		num.add(num2);
		System.out.println("num.getNum() : " + num.getNum());

		Number num3 = new Number(10);
		num.minus(num3);
		System.out.println("num.getNum() : " + num.getNum());
		
		
		num.minus(new Number(10));
		System.out.println("num.getNum() : " + num.getNum());
		
		System.out.println("-------------------------------");
		
		// num 을 다시 100으로 바꿈
		num.setNum(100);
		
		// 자기 자신 num을 리턴하기 때문에 이게 가능하다
		// 이걸 method chain이라고 한다.
		num.add(num2).minus(num3).minus(new Number(100));
		System.out.println("num.getNum() : " + num.getNum());
		
		System.out.println("------------------------------");
		
		Number n4 = new Number();
		n4.setNum1(10);
		n4.setNum2(20);
		n4.setNum3(30);
		n4.setNum4(40);
		n4.setNum5(50);
		n4.setNum6(60);
		
		// method chain
		n4.setNum1(10)
			.setNum2(20)
			.setNum3(30)
			.setNum4(40)
			.setNum5(50)
			.setNum6(60);
		
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class04Main











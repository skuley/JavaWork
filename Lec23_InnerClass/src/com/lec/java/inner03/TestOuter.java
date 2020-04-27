package com.lec.java.inner03;

public class TestOuter {
	private int value; // .. 1번

	// this의 문제
	// outer class 의 this의 값이 무엇인지를 고민을 해봐야한다.

	public TestOuter(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	// InnerClass
	public class TestInner {

		private int value; // .. 2번

		public TestInner() {
			// TODO Auto-generated constructor stub
		}

		public TestInner(int v) {
			this.value = v;

		}

		public void printValue() {
			int value = 10; // ..3번 지역변수 value
			System.out.println("printValue() 지역변수의 value : " + value);
			// this 는 TestInner 객체의 value 값
			System.out.println("InnerClass의 value : " + this.value); 
			// TestOuter의 인스턴스의 value를 의미한다.
			System.out.println("OuterClass의 value : " + TestOuter.this.value); 
			
		}

	}

} // end class TestOuter

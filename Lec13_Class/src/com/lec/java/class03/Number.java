package com.lec.java.class03;

public class Number {

	// member variable 
	private int num;
	private char ch;
	
	
	// constructor 
	
	// default constructor
	public Number() {	}
	
	// 매개변수 constructor
	public Number(int num, char ch) {
		// this : 자기 자신(인스턴스) 가리킴
		this.num = num; // 멤버 변수에 대입하고 싶을때는 this.을 사용한다.
		this.ch = ch;
	}
	
	
	// method
	// getter: 멤버 변수의 값을 리턴해 주는 메소드
	// setter: 멤버 변수의 값을 변경해 줄 수 있는 메소드
	
	// 일반적인 작명 관례
	// get변수이름()
	// set변수이름()
	// Camel notation 적용
	public int getNum() {
		return this.num;
	}
	
	public void setNum(int num) {
		// 유효한 값만 변경을 시도 할 수 있다.
		if(num >= 0)
		this.num = num;
	} // setter
	
	
	// ch 에 대한 getter, setter 작성
	
	public char getCh() {
		return this.ch;
	}
	
	public void setCh(char ch) {
		this.ch = ch;
	}
	
} // Number

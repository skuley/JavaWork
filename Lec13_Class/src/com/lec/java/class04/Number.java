package com.lec.java.class04;

public class Number {
	// 멤버변수 선언시 초깃값 명시 가능.
	private int num = 100; // 기본 생성자에 100으로 시작함

	
	// constructor using fields
	public Number(int num) {
		this.num = num;
	}
	
	
	// default constructor
	public Number() {
	}


	// getter && setter
	public int getNum() {
		return this.num; // return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	// 
	public Number add(Number x) { // x == num2 값
		this.num += x.num; // num값
		return this; // 자기 자신을 리턴
	}
	
	public Number minus(Number x) {
		this.num -= x.num;
		return this; // 자기 자신을 리턴
	}
	
	// set 해야 할 멤버변수가 많은 경우
	// setter 들을 메소드 체이닝하면 편리
	
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	private int num5;
	private int num6;


	public Number setNum1(int num1) {
		this.num1 = num1;
		return this;
	}


	public Number setNum2(int num2) {
		this.num2 = num2;
		return this;
	}


	public Number setNum3(int num3) {
		this.num3 = num3;
		return this;
	}


	public Number setNum4(int num4) {
		this.num4 = num4;
		return this;
	}


	public Number setNum5(int num5) {
		this.num5 = num5;
		return this;
	}


	public Number setNum6(int num6) {
		this.num6 = num6;
		return this;
	}

	
	
	
	
}

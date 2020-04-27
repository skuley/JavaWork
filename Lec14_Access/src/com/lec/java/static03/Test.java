package com.lec.java.static03;

public class Test {
	private int num;
	
	static int COUNT = 0;
	
	// default constructor
	private Test() {
		COUNT++;
		System.out.println(COUNT + "번째 인스턴스 생성");
	}
	
	private static Test instance = null;
	private static String n = null;
	
	// 인스턴스 없이도 Test 클래스를 써야하기 때문에 static으로 사용한다
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test(); // 인스턴스 생성
		}
		return instance;
	}
	
	
	// getter && setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	
	
	
}

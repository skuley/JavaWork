package com.lec.java.firstjava;

public class FirstJava {
/*
		모든 자바 프로그램은 main() 메소드로부터 '시작'한다
		프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
		문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
		*/
	public static void main(String[] args) {
	
		// 여러줄 잡고 Tab 누르면 단체 들어감
		// 반대로는 Shift + Tab
		
		System.out.println("My First Java Application");
		
		System.out.println(123);
		
		System.out.println(); // 줄바꿈
		
		System.out.println(10 + 20); // 10, 20 int 타입 (숫자)로 인식
		System.out.println("10 + 20"); // 10과 20은 String 타입(문자열)로 인식
		
		// 문자열 출력은 반.드.시. " ~ " 로 감싸야 한다.
//		주석 단축키 : Ctrl + /
		
		System.out.println(3.141592 * 10 * 10);
		System.out.println(10 * 10 / 2);
		
//		+ 연산자의 여러가지 동작
		System.out.println("안녕하세요" + " 여러분");
		System.out.println("결과 : " + 10); // 한개라도 문자열이 있더라고 산수 연산이 아닌 덧붙이기가 된다. 여기서 10은 int가 아닌 String으로 읽는다.
		System.out.println("결과 : " + 10 + 20); // ********* 여기도 마찬가지로 문자열이 하나라도 있을 경우 *************
		System.out.println("결과 : " + (10 + 20));
		
		// 사칙연산 보여주기 (+ - * /)
		System.out.println("10 + 20 = " + (10 + 20));
		System.out.println("10 - 20 = " + (10 - 20));
		System.out.println("10 * 20 = " + (10 * 20));
		System.out.println("10 / 20 = " + (10 / 20)); // 정수 / 정수 = 정수
		System.out.println("10 / 20 = " + ((double)10 / 20)); 
		
//		이스케이프 문자 (escape character)
//		" ~ " 문자열 안에서 특수한 문자 출력
//		역슬래시(\) 와의 조합문자로 구성
//		She says "Hi" --> 출력 가능?
//		System.out.println("She says " + "'Hi'");
		System.out.println("She says \"Hi\"");
		
//		기억해야할 이스케이프 문자
//		\"	: 쌍따옴표 출력
//		\n	: 줄바꿈
//		\t	: 탭문자
//		\\	: 역슬래시
		
		System.out.println("\t나는 졸리다" + "\"zzz\""); // 연산자 뒤에 오는 이스케이프 문자중 탭문자는 space와 같은 크기로 띄워진다
		System.out.println("Avengers\tEndgame");
		System.out.println("Avengers\n\\Endgame\\");
		
	}

}

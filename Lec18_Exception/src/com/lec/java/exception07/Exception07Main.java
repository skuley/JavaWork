package com.lec.java.exception07;

import java.util.InputMismatchException;
import java.util.Scanner;

/* Exception 클래스 만들어 사용하기  & throw
 	Exception 또는 RuntimeException 클래스를 상속 받아서 만듬
 */

// Custom Exception : 나만의 exception을 정의 쓸수 있다.
public class Exception07Main {

	static Scanner sc = new Scanner(System.in);

	// TODO : ScoreException 을 throws 하는 메소드 만들기
	public static int inputScore() throws ScoreException {
		int score = sc.nextInt();

		if (score < 0 || score > 100) {
			ScoreException ex = new ScoreException();
			//ScoreException ex = new ScoreException(score + "값은 유효한 점수가 아닙니다.");
			throw ex; // 임의적으로 예외 객체 throw

		}

		return score;
	} // end inputScore()

	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기, throw");
		
		System.out.println();

		// TODO : ScoreException 을 catch 해보자
		int i = 0;
			while(i < 5) {
			int kor;
			try {
				System.out.println("국어 점수 입력:");
				kor = inputScore();
				System.out.println("kor = " + kor);
				i++;
				/*System.out.println("영어 점수 입력:");
				int eng = inputScore();
				System.out.println("eng = " + eng);*/
			} catch (ScoreException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch(InputMismatchException ex) {
				System.out.println("적절하지 않는 입력 값입니다.");
				sc.nextLine();
			}
			} // while
			
			
			sc.close();

			
		System.out.println("프로그램 종료");
	} // end main()

} // end class Exception07Main

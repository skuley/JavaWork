package com.lec.java.method08;

import java.util.Random;
import java.util.Scanner;

/* 메소드 연습 : 컴퓨터 생각 맞추기 게임 
 * 1. 메뉴를 보여주고
 * 2. 사용자로부터의 입력을 받고
 * 3. 컴퓨터의 생각(난수)와 비교 판정 내기
 * 4. 사용자가 메뉴에서 '종료' 누르면 종료 시키기
 */
public class Method08Main {

	public static void main(String[] args) {
		System.out.println("컴퓨터 생각 맞추기 게임");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			showMenu(); //메뉴를 무한반복한다
			
			int userChoice = inputChoice(sc); 
			//inputChoice를 호출해서 랜덤값을 userChoice에 넣어준다
			
			if(userChoice == 0) break;
			
			int com = new Random().nextInt(3) + 1;
		
			if(com == userChoice) {
				System.out.println("맞췄습니다.");
			} else {
				System.out.println("틀렸습니다. 컴퓨터 생각은 = " + com);
			}
		}
		
		
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main

	// 메뉴 보여주기
	// 메소드 이름 : showMenu()
	public static void showMenu() {
		System.out.println("---------------");
		System.out.println("com의 생각을 맞춰주세요");
		System.out.println("[1]");
		System.out.println("[2]");
		System.out.println("[3]");
		System.out.println("[0] 종료");
		System.out.println("---------------");
		System.out.println("선택 : ");

	}

	// 메소드 이름 : inputChoice
	// 매개변수 : Scanner sc
	// 리턴타입 : int
	// 0 ~ 3 까지의 정수를 Scanner 로부터 입력받아 리턴
	// 범위 밖의 수일때는 재입력받는다

	public static int inputChoice(Scanner sc) {
		int choice;
		while (true) {
			choice = sc.nextInt();
			if (0 <= choice && choice <= 3)
				return choice;
			System.out.println("다시 입력 해주세요");
		} // while

	} // inputChoice

} // end class

package com.lec.java.Input02;

import java.util.Scanner;

// 문자열(String) 입력
// char 입력

// *** CTRL + SHIFT + O : 자동 import ***
 
public class Input02Main {

	public static void main(String[] args) {

		System.out.println("표준입력 : String, char");
		
		Scanner sc = new Scanner(System.in);
		
//		******* String 입력 *******
		/*System.out.print("이름 : ");
		String name = sc.nextLine(); // 엔터를 입력할때까지의 모든 문자들을 문자열로 리턴
		
		System.out.print("별명 : ");
		String id = sc.nextLine();
		
//		System.out.printf("이름은 %s 이고요 별명은 %s 입니다.\n", name, id);
		
//		******* char 입력 *******
//		.nextChar() 이딴거 없음!!!
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0); // 공식처럼 써야한다
		System.out.printf("이름은 %s 이고요 별명은 %s 이고요 성별은 %c 입니다.\n", name, id, gender);*/

		System.out.println("-----------------------------------------");
		
		System.out.println("나이 : ");
		int age = sc.nextInt();
		
		System.out.println("주소 : ");
//		숫자 입력받은 뒤에 문자열 입력시에는 반드시 '\n' 을 consume(버퍼에서 제거) 해야한다.
		sc.nextLine();
		String add = sc.nextLine();
		
		System.out.printf("나이 : %d \n주소 : %s\n", age, add);
		
//		키보드 버퍼에서 데이터를 받은 cpu에서는 엔터 바로전까지 데이터를 담고 엔터만 남겨둔다. 하지만 그 다음 스캐너에서 입력을 준비할때 엔터가 남아 있기 때문에 바로 출력한다.
//		아무것도 안쳤기 때문에 공백을 바로 출력하기 때문에 "주소"값을 입력하기 전에 출력 해버린다.
		
		
		sc.close();
		
	} // main

} // class

package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		// TODO
		// MemberModel 타입을 담는 ArrayList를 만들고
		// 사용자로부터 3개의 Student 데이터를 입력 받아서
		// id, password
		// 3가지 방법으로 출력해보세요.

	
		ArrayList<MemberModel> member = new ArrayList<MemberModel>();
		
		Scanner sc = new Scanner(System.in);
	/*	String id = sc.nextLine();
		String pw = sc.nextLine();
		MemberModel mm = new MemberModel(id, pw);
		
		while(true) {
			member.add(mm);

			for(int i = 0; i < member.size(); i++) {
			}
			
			if(member.size() >= 3) break;
		}
		
		mm.displayInfo();
		*/
		
		for(int i = 0; i < 3; i++) {
			System.out.println("id : ");
			String id = sc.nextLine();
			System.out.println("pw : ");
			String pw = sc.nextLine();
			
			MemberModel mm = new MemberModel(id, pw);
			member.add(mm);
			
		}
		
		Iterator<MemberModel> itr = member.iterator();
		while(itr.hasNext()) {
			itr.next().displayInfo();
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class













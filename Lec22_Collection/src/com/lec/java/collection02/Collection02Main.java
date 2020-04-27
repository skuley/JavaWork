package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		// String 타입을 담는 ArrayList를 만들고
		ArrayList<String> sList = new ArrayList<String>();
		
		// 5개 이상의 String을 저장하고
		sList.add("안녕하세요");
		sList.add("저는");
		sList.add("28살");
		sList.add("입니다");
		sList.add("ㅎㅎ");
		
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator
		
		// 데이터 조회
		for(int i = 0; i < sList.size(); i++) {
			System.out.print(sList.get(i) + " ");
		}
		
		System.out.println();
		
		// 데이터 수정
		sList.set(4, "ㅋㅋ");
		for(String e : sList) {
			System.out.print(e + " ");
		}
		
		System.out.println();
		
		// 데이터 삭제
		sList.remove(4);
		Iterator<String> itrString = sList.iterator();
		
		while(itrString.hasNext()) {
			System.out.println(itrString.next());
		}
		

		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class













package com.lec.java.collection06;

import java.util.HashSet;
import java.util.Iterator;

/* Set, HashSet<E>

	Collection<E>
	 |__ Set<E>
	      |__ HashSet<E>, TreeSet<E>
	
	 Set:
	 1. 자료의 중복 저장이 허용되지 않는다. (hashCode() 값의 중복여부!)
	 2. 저장 순서가 유지되지 않는다.(인덱스 없다.)
	 (예) {1, 2, 3} = {1, 1, 2, 2, 3} : 중복 저장이 안되기 때문에 같은 Set
	 (예) {1, 2, 3} = {1, 3, 2}: 저장 순서가 중요하지 않기 때문에 같은 Set
	
	 HashSet: 매우 빠른 검색 속도를 제공

	 	(※ HashXXX ← '검색속도 향상'을 쓰는 자료구조 입니다)
*/

public class Collection06Main {

	public static void main(String[] args) {
		System.out.println("HashSet 클래스");
		
		// Integer 타입을 저장할 수 있는 HashSet 인스턴스 생성
		HashSet<Integer> set = new HashSet<Integer>();
		
		
		// 데이터 저장: add()
		// 성공하면 true, 실패하면 false
		set.add(10);
		set.add(40);
		set.add(50);
		set.add(4);
		set.add(66);
		set.add(523);
		set.add(5234);
		for(Integer e : set) {
			System.out.println(e);
		}
		System.out.println();
		
		// HashSet의 크기: size()
		System.out.println(set.size());
		System.out.println();
		
		// Set은 중복 저장을 허용하지 않는다.
		System.out.println(set.add(4));
		set.add(66);
		System.out.println();
		
		for(Integer e : set) {
			System.out.println(e);
		}
		
		
		// 데이터 검색:
		// Set은 인덱스가 없기 때문에 get() 메소드를 제공하지 않습니다.
		// 데이터 검색을 위해서는 Iterator를 사용해야 함
		System.out.println();
		System.out.println("iterator를 사용해야만 하는 Set");
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		} // 입력 순서와 출력 순서는 전혀 관계가 없다
		System.out.println();
		
		// 데이터 삭제
		// remove(element): Set에 있는 element를 찾아서 삭제
		//   element 있다면 삭제 후 true를 리턴
		//   element 없다면 false 리턴
		System.out.println(set.remove(2));
		// iterator()는 일회용이다. 또 사용하고 싶다면 한번더 적어야한다
		itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
//		itr.next(); 뻗는다 (exception) get message : java.util.NoSuchElementException
		
		System.out.println();
		
		
		System.out.println();
		System.out.println("삭제 후:");
		
		// Set 자료형 데이터 변경을 할 수 있는 set() 메소드를 제공하지 않습니다.
		// 삭제(remove) 후 추가(add)하면 변경하는 효과
		// 500을 지우고 555를 추가
		set.remove(523);
		set.add(555);
		System.out.println("변경후 ");
		
		
		
		// enhanced-for 사용
		System.out.println();
		System.out.println("Enhanced for 사용 출력");
		for(Integer e : set) {
			System.out.println(e);
		}
		
		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용 출력");
		// TODO
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class













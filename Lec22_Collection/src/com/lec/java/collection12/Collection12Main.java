package com.lec.java.collection12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

// Hash: 검색을 빠르게 하기 위한 용도
// Tree: 데이터 정렬을 하기 위한 용도

public class Collection12Main {

	public static void main(String[] args) {
		System.out.println("TreeMap 클래스");
		
		// key 에 대한 정렬이 특화 되어 있다
		
		// TreeMap<Integer, String> 타입 인스턴스 생성
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		
		// 데이터 저장: put(key, value) 메소드 사용
		tmap.put(1, "aaa");
		tmap.put(5, "qda");
		tmap.put(4, "bsd");
		tmap.put(2, "kqw");
		tmap.put(3, "izv");
		
		// values() : value 들로 이루어진 Collection 리턴
		System.out.println("values()");
		for(String value : tmap.values()) {
			System.out.println(value);
		}
		
		// iterator를 사용해서 뽑아낸다
		
		// 데이터 검색: get(key) 메소드를 사용
		// 1. 키값들로만 이루어진 Set을 만듬
		Set<Integer> kset = tmap.keySet();
		
		// 2. keySet을 가지고 iterator를 만듬
		Iterator<Integer> itr = kset.iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			System.out.println(key + " : " + tmap.get(key));
		}

		System.out.println();
		
		
		// TreeMap에만 있는 KeySet을 만들어 내는 메소드
		NavigableSet<Integer> navi = tmap.navigableKeySet();
		itr = navi.descendingIterator();
		while(itr.hasNext()) {
			int key = itr.next();
			System.out.println(key + " : " + tmap.get(key));
		}
		
		
		// HashMap --> TreeMap 전환하기
		System.out.println("HashMap() -> TreeMap() ");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("세종대왕", 10000);
		hmap.put("신사임당", 50000);
		hmap.put("퇴계이황", 5000);
		hmap.put("이순신", 100);
		
		System.out.println(hmap);
		
		// 매개변수로 hmap
		TreeMap<String, Integer> tmap2 = new TreeMap<String, Integer>(hmap);
		System.out.println(tmap2);
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class



















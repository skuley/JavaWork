package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		ArrayList<Student> collection = new ArrayList<Student>();
		// Student 타입을 담는 ArrayList를 만드고
		// (id, name, kor, eng, math);
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println("id : ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("name : ");
			String name = sc.nextLine();
			
			System.out.println("kor, eng, math");
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			sc.nextLine();

			Student st = new Student(id, name, new Score(kor, eng, math));
			collection.add(st);
		} // for(i)
		
		for(Student e : collection) {
			System.out.println(e);
		}


		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// 3가지 방법으로 출력해보세요.
		// for, Enhanced-for, Iterator

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

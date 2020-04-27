package com.lec.java.inner06;

public class Local02Main {

	public static void main(String[] args) {
		System.out.println("Local 내부 클래스의 활용");
		
		Person p = new Person("abc");
		Readable r = p.createInstance(20);
		r.readInfo();
		
		

	} // end main()

} // end class Local02Main















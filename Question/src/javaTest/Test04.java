package javaTest;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			int num = sc.nextInt();
			System.out.println(num);
			if(num == 0) break;
		}
		
	} // main

}

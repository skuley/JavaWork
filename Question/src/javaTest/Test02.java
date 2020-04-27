package javaTest;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		String word2 = sc.nextLine();
		String word3 = sc.nextLine();
		
		System.out.printf("%s%s%s", word.charAt(0), word2.charAt(0), word3.charAt(0));
		
		
	} // main

}

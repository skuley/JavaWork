package 반복제어문1.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int country;
		while(true) {
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.print("number? ");
			country = sc.nextInt();
			System.out.println();
			
			switch (country) {
			case 1:
				System.out.println("Seoul");
				System.out.println();
				continue;
			
			case 2: 
				System.out.println("Washington");
				System.out.println();
				continue;
				
			case 3:
				System.out.println("Tokyo");
				System.out.println();
				continue;
				
			case 4:
				System.out.println("Beijing");
				System.out.println();
				continue;

			default:
				System.out.println("none");
				break;
			}
			break;
		}
		
	}

}

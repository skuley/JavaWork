package 반복제어문2.형성평가08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.
		
		3 4

		1 2 3 4
		2 4 6 8
		3 6 9 12*/
		
		
		Scanner sc = new Scanner(System.in);
		
		int column, row;
		
		column = sc.nextInt();
		row = sc.nextInt();
		
		for(int i = 1; i <= column; i++) {
			for(int j = 1; j <= row; j += i) {
				System.out.println();
			}
		}
	}

}

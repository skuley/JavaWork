package 배열2.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 호석이네 학교는 6학년이 네 반이 있는데 각 반의 대표를 세 명씩 선발하여 제기차기 시합을 하였다.
		// 반별로 세 명이 제기를 찬 개수를 입력받아 각 반별로 제기를 찬 개수의 합계를 출력하는 프로그램을 작성하시오.
		// (반드시 배열을 이용하고 입력후에 출력하는 방식으로 하세요.)

		Scanner sc = new Scanner(System.in);
		int[][] ban = new int[4][3];
		int sum = 0;

		for (int i = 1; i <= 4; i++) {
			
			System.out.println(i + "class? ");
			
			int num = sc.nextInt();
			
			for(int j = 0; j < 3; j++) {
				ban[i][j] = num;
			} // for(j)
		} // for(i)
		
		for (int i = 0; i < ban.length; i++) {
			for (int j = 0; j < 3; j++) {
				sum += ban[i][j];
			}
			System.out.println((i + 1) + "class : " + sum);
		}

	}

}

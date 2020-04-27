package 배열2.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 학생들의 점수를 입력을 받다가 0이 입력되면 그 때까지 입력받은 점수를 10점 단위로 구분하여 점수대별 학생 수를 출력하는 프로그램을
		// 작성하시오. (1명도 없는 점수는 출력하지 않는다.)학생은 최대 100명이하이다.

		int [] score = new int [11];
		
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < 100; i++) {
			int num = sc.nextInt();
			if(num == 0) break;
//			for(int j = 0; j < score.length; j++) {
				if(0 < num || num <= 100) {
				score[num / 10]++;
//				}
			}
		}
		sc.close();

		for(int k = score.length - 1; k >= 0; k--) {
			if(score[k] !=0) {
			System.out.println((k * 10) + " : " + score[k] + "person");
			}
		}
		

	} // main
} // main

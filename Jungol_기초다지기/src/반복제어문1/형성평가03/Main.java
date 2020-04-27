package 반복제어문1.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 
//		그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을 작성하시오.
//
//		(평균은 반올림하여 소수 첫째자리까지 출력한다.)
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int sum = 0;
		int count = 0;
		
		while(true) {
			num = sc.nextInt();
			if(num < 0 || num > 100) break;
			sum += num;
			count++;
		} // while
		System.out.printf("sum : %d \navg : %.1f", sum, (double)sum / count);

} // main

} // class
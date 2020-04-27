package 배열2.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 10 미만의 자연수 두 개를 입력받아서 첫 번째 항과 두 번째 항을 입력받은 수로 초기화 시킨 후 세 번째 항부터는 전전항과 전항의 합을 구하여 그 합의 1의 자리로 채워서 차례로 10개를 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[10];
		
		
		for(int a = 0; a < 2; a++) {
			int n = sc.nextInt();
			num[a] = n;
		}

		for(int i = 2; i < num.length; i++) {
			if((num[i - 1] + num[i - 2]) >= 10) {
				num[i] = (num[i - 1] + num[i - 2]) - 10;
			} else {
				num[i] = num[i - 1] + num[i - 2];
			}
		} // for
		
		for(int j = 0; j < num.length; j++) {
			System.out.print(num[j] + " ");
		}
		
	} // main

}

package 배열2.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 승지는 주사위 놀이를 하다가 주사위를 10번 던져서 각 숫자가 몇 번씩 나왔는지 알아보려고 한다. 한번 던질 때마다 나온 주사위의 숫자를
				// 입력받아서 각 숫자가 몇 번씩 나왔는지 출력하는 프로그램을 작성하시오.0

		Scanner sc = new Scanner(System.in);
		int[] dice = {1, 2, 3, 4, 5, 6};
		int[] cnt = new int[6];
		
		for(int i = 1; i <= 10; i++) {
			int num = sc.nextInt();
			if(num == 0) break;
			for(int j = 0; j < dice.length; j++) {
				if(num == dice[j]) {
					cnt[j]++;
				}
			}
		}
		
		for(int k = 0; k < cnt.length; k++) {
			System.out.println((k + 1) + " : " + cnt[k]);
		}
		
	
	} // main
	
} // Main{}

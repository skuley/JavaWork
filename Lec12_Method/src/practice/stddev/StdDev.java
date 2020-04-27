package practice.stddev;

import java.util.Scanner;

public class StdDev {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[5];
		
		for(int i = 0; i < 5; i++) {
			num[i] = (int)Math.floor(Math.random() * 100) + 1;
			System.out.print(num[i] + " ");
			
		} // for
		
//		출력 뿌리기
		System.out.printf("\n평균값 : %.2f", calcAvg(num));
		System.out.printf("\n분산값 : %.2f", calcVariance(num));
		System.out.printf("\n표쥰편차값 :  %.2f", calcStdDev(num));
		
		
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기

	} // end main
	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] num) {
		double avg = 0;
		
		for(int i = 0; i < num.length; i++) {
			avg += (double)num[i];
		} // for
		
		avg /= num.length;
		
		return avg;
	}
	
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] num) {
		double var = 0;
		double square = 0;
		double avg = calcAvg(num);
		for(int i = 0; i < num.length; i++) {
			//편차 = 변량 - 평균
			num[i] -= avg; // num[] 안에는 편차값이 새로 들어간다.
			square += num[i] * num[i];
		}
		var = square / num.length;
		
		return var;
	}
	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] num) {
		double stdDev = Math.sqrt(calcVariance(num));
		
		return stdDev;
		
		
	}

} // end class

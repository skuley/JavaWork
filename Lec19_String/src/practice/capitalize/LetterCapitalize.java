package practice.capitalize;

import java.util.Arrays;
import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {
	
	public static String lettCap(Scanner sc) {
		
		String result;
		String[] words;
		
		while(true) {
		System.out.println("[입력예]");
		result = sc.nextLine();
		if(result.trim().equalsIgnoreCase("quit")) break;
		
		// 소문자로 변환
		result = result.toLowerCase();
		// 공백 기준 단어 분리
		words = result.split("\\s");
		
		for(String word : words) {
			
			if(word.length() > 0) {
				// 앞글자 떼어내기
				String firstLetter = word.substring(0, 1).toUpperCase();
				String rest = word.substring(1); //나머지 문자열
				System.out.print(firstLetter + rest + " "); // 최종 출력
			}
		}
		// 줄바꿈
		System.out.println();
		}
		
		
		
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		lettCap(sc);
		
		sc.close();
	} // end main()
} // end class

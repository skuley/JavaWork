package com.lec.java.string04;

import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer 클래스

	token ? : '규칙'에 의해 구분된 더 이상 나눌수 없는 문자요소(문자열)
				(문법적으로 더 이상 나눌 수 없는 기본적인 언어요소)
				
	구분자 : delimeter -- 어떤 특정 문자에 의한 특정 기호에 의한 분리
*/

public class String04Main {

	public static void main(String[] args) {
		System.out.println("StringTokenizer 클래스");

		// token <- '규칙'에 의해 구분된 문자덩어리(문자열)?
		String str1 = "13:46:12";

		StringTokenizer tokenizer = new StringTokenizer(str1, ":");
		System.out.println("토큰 갯수 : " + tokenizer.countTokens());

		System.out.println(tokenizer.nextToken()); // ????? 왜 여기서는 안 찍히지 ?????

		while (tokenizer.hasMoreTokens()) { // boolean 타입 return
			System.out.println(tokenizer.nextToken());
		}
//		System.out.println(tokenizer.nextToken()); java.util.NoSuchElementException

		System.out.println();
		String str2 = "abc:def:ghi:jkl:mno"; // : 로 토큰분리

		tokenizer = new StringTokenizer(str2, ":");

		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}

		System.out.println();
		String str3 = "2015/04/08"; // / 로 토큰분리

		tokenizer = new StringTokenizer(str2, "/");

		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}

		System.out.println();
		String str4 = "2015년-4월-8일"; // - 으로 토큰분리

		tokenizer = new StringTokenizer(str4, "-");
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}

		System.out.println();
		String str5 = "2015-04-08 14:10:55";

		StringTokenizer token5 = new StringTokenizer(str5, ":-) "); // delimeter를 한곳에 다 넣어줄 수 있다
		
		while(token5.hasMoreTokens()) {
			System.out.println(token5.nextToken());
		}

		System.out.println();
		// StringTokenizer 생성자의 세번째 "매개변수를" true 로 주면
		// delimiter 도 token 으로 추출된다
		String str6 = "num += 1";

		StringTokenizer token6 = new StringTokenizer(str6, "+=", false); //세번째 매개변수를 true로 두면 delimeter를 토큰으로 출력된다
		while(token6.hasMoreTokens()) {
			System.out.println(token6.nextToken());
		}

		// 실습]
		// 다음과 같은 수식이 있을때 토큰들을 분리해네세요
		// 연산자 + - / * 괄호 ( )
		// 10 + (name * 2) / num8- (+3)
		// 힌트]
		// 일단 공백으로 분리 split()
		// 그리고 나서 각각을 StringTokenizer 함
		
		// 결과
		// 10, +, (, name, *, 2, ), /, num8, -, (, +, 3, ),

		System.out.println();
		System.out.println("수식 분석기");
		String expr = "10  +  (name * 2) / num8- (+3)";

	/*	String[] str = expr.split(" ");
		for(String x : str) {
			//System.out.println(Arrays.toString(str));
			StringTokenizer token7 = new StringTokenizer(str[0], " ");
			System.out.print(token7.nextToken() + ", ");
		}
//		while(token7.hasMoreTokens()) {
	//	}
	 */
		for(String s : expr.split("\\s")){
			StringTokenizer token7 = new StringTokenizer(s,"+-*/()", true);
			while(token7.hasMoreTokens()) {
				System.out.print(token7.nextToken() + ", ");
			}// while
		}// for
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

package practice.wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	class WordFreq implements Comparable<WordFreq> {

		String word; // 발생 단어
		int freq; // 발생 빈도수

		public WordFreq(String word, int freq) {
			super();
			this.word = word;
			this.freq = freq;
		}

		@Override
		public int compareTo(WordFreq o) {
			// TODO Auto-generated method stub
			return 0;
		}

		// TODO

	}

	public static void main(String[] args) {		
		System.out.println("실습: 단어 발생 빈도");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		// trim() : 좌우 여백 제거 / toLowerCase() : 대문자 --> 소문자 / split() : "" 정의해준 regex로 문자열 분리
		String [] words = C.ALICE30.trim().toLowerCase().split("\\s+");
		String regex = ",.\"\'`!?;:-()[] ";
		String strWords = Arrays.toString(words);
		int num = 0;
		
		StringTokenizer token = new StringTokenizer(strWords, regex);
		
		// 전부 뽑아주는게 아니라 하나식 뽑아준다 (token.hasMoreTokens()
		while(token.hasMoreTokens()) {
			int i;
			String[] words2 = new String[token.countTokens()];
			for(i = 0; i < words2.length; i++) {
				if(words2[i].length() >= 2)
					hmap.put(words2[i], num);
			} for(int j = 1; j < words2.length; j++) {
				if(words2[i].equals(words2[j])) {
					hmap.put(words2[i], num++);
				}
			}
		}
		
		for(Map.Entry<String, Integer> m : hmap.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue() + "개");
		}
		
		
		for (int i = 0; i < words.length; i++) {
	         StringTokenizer n1 = new StringTokenizer(words[i], ",.\"\'`!?;:-()"); // 제거
	         while (n1.hasMoreTokens()) {
	            words[i] = n1.nextToken();
	      }
	      }
		
		
		
	} // end main()

} // end class

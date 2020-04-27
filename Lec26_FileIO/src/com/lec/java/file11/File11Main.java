package com.lec.java.file11;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/*
문자(character) 단위 입출력 스트림 클래스
 java.io.Reader: 프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
  └─ java.io.InputStreamReader
      └─ java.io.FileReader

 java.io.Writer: 프로그램이 '문자 단위' 데이터를 쓰는(write) 통로
  └─ java.io.OutputStreamWriter
      └─ java.io.FileWriter

 FileReader / FileWriter 객체는 '텍스트파일, 즉 문자 단위' 데이터를 읽고/쓰기 할때
 사용하는 기반 스트립 입니다.   따라서 텍스트가 아닌 오디오, 비디오, 등의 파일을 다룰수 없습니다.
 주로 String 이나 char [] 내용을 입/출력 할때 사용합니다.

 텍스트 파일 (Text File) 이란
   사람이 읽을수 있는 글자들이 저장된 파일
   암호화 되지 않은 평범한 텍스트

 이진파일 (Binary File) 이란
   사람이 직접 읽을수는 없슴.

   ★ 웹 프로그래밍에서 유용하게 사용된다 ★
   ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★
*/


public class File11Main {
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		String src = "temp/FileData.txt";
		String dst = src;
		
		try (
				FileWriter fw = new FileWriter(dst);
				FileReader fr = new FileReader(dst);
				){
			
			String str = "안녕하세요."; // 한글 5글자 한글 3바이트 특수문자는 1바이트일듯...
			char[] charArr = {'J', 'A', 'V', 'A'}; // 영문 4글자 영문은 1바이트
			
			// 파일 쓰기
			fw.write(str);
			fw.write(charArr);
			fw.flush(); // 맨끝에 몇 바이트가 저장이 안 될 경우가 있다. write() 호출후에는 flush() 하여 출력버퍼의 데이터가 완전히 출력되도록 한다.
			
			
			// 파일 읽기 - 저장된 문자열 가지고 오고 "글자단위"로 문자 개수 가져오기
			char[] buff = new char[100];
			// stream 에서 버퍼와 다른점 : 타입이 다르다
			int charsRead = 0; // 읽어들인 문자의 개수
			charsRead = fr.read(buff); // 몇글자 읽어들였는지 리턴
			for(int i = 0; i < charsRead; i++) {
				System.out.print(buff[i]);
			}
			System.out.println();
			System.out.println("읽은 문자개수 : " + charsRead);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()
} // end class

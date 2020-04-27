package com.lec.java.file04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");
		
		/* 보조스트림 (filter stream)
		 Program <=== FilterInputStream <=== InputStream <=== Source
							↓ 상속					↓ 상속
		 Program <=== BufferedInputStream <=== FileInputStream <=== File

		 Program ===> FilterOutputStream ===> OutputStream ===> Source
							↓ 상속					↓ 상속
		 Program ===> BufferedOutputStream ===> FileOutputStream ===> File

		 java.io.InputStream
		  |__ java.io.FilterInputStream
		       |__ java.io.BufferedInputStream

		 java.io.OutputStream
		  |__ java.io.FilterOutputStream
		       |__ java.io.BufferedOutputStream

		 참고 ) 보조스트림 (filter stream)
		 보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
		*/

		InputStream in = null;
		BufferedInputStream bin = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;


		try	{
				in = new FileInputStream("temp/big_text.txt");
				bin = new BufferedInputStream(in); // 장착!
				
				out = new FileOutputStream("temp/copy_big_text.txt");
				bout = new BufferedOutputStream(out); // 장착!
			
			byte[] buff = new byte[1024]; 
			
			int lengthRead = 0; 
			int byteCopied = 0;  
			
			long startTime = System.currentTimeMillis();
			
			// 파일복사 
			while(true) {
				
				lengthRead = bin.read(buff);
				if(lengthRead == -1) break;
				
			
				bout.write(buff, 0, lengthRead);
				byteCopied += lengthRead;
				
			} // while
			
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			
			System.out.println("복사된 바이트 = " +  byteCopied);
			System.out.println("경과시간 = " + elapsedTime);
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			// 리소스 해제
			try {
				if(bout != null) bout.close();
				if(bin != null) bin.close();
				// bin을 close 하면, bin을 만든 in도 같이 close 됨
				// bout을 close 하면, bout을 만든 out도 같이 close 됨
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class















package com.lec.java.file06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*  Data Filter Stream
 Program <=== DataInputStream <=== FileInputStream <=== File
 Program ===> DataOutputStream ===> FileOutputStream ===> File

java.io.InputStream
|__ java.io.FilterInputStream
   |__ java.io.DataInputStream  

java.io.OutputStream
|__ java.io.FilterOutputStream
   |__ java.io.DataOutputStream
*/

public class File06Main {

	public static void main(String[] args) {
		System.out.println("Data Filter Stream");
		
		try(
				OutputStream out = new FileOutputStream("temp/data.bin"); // data.bin이 없으면 새로 만들고 기존에 있으면 지우고 새로 만든다
				DataOutputStream dout = new DataOutputStream(out); // 장착!
				
				InputStream in = new FileInputStream("temp/data.bin");
				DataInputStream din = new DataInputStream(in); // 장착
				
				){
			
			dout.writeBoolean(true); // 1byte
			dout.writeInt(100); // 4byte
			dout.writeDouble(3.14); // 8byte
			dout.writeChar('A'); // 2byte
			// 총 15바이트 "temp/data.bin" -> properties에 들어가서 확인해본다
			
			System.out.println("boolean : " + din.readBoolean());
			System.out.println("int : " + din.readInt());
			System.out.println("double : " + din.readDouble());
			System.out.println("char : " + din.readChar());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class

















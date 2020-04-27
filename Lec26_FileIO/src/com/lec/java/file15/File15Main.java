package com.lec.java.file15;

import java.io.File;

public class File15Main {

	// directory 관련된 작업
	
	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재 작업 폴더 : " + curWorkingDir);
		
		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		File curDir = new File(curWorkingDir); // 현재 작업 directory 객체
		File[] list = curDir.listFiles(); // listFiles() : 디렉토리 안에 있는 '파일' 과 '디렉토리' 를 File 배열로 리턴
		
		System.out.println(list.length); // '파일'과 '디렉토리' 의 개수
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {
				// isDirectory(): File 객체가 디렉토리이면 true 리턴
				// isFile(): File 객체가 파일이면 true 리턴
				System.out.print("DIR\t");
			} else {
				System.out.print("FILE\t");
			}
			System.out.print(list[i].getName() + "\t");
			System.out.println(list[i].length() + "byte");	// length() '파일' 객체의 크기 byte
															// '디렉토리' 인 경우는 의미 없다
		}
		
		System.out.println();
		// 디렉토리의 내용 출력, enhanced for 문 이용
		// File tempDir = new File("temp"); // *** 상대 경로 : 현재 경로 기준으로 밑에 있는 디렉토리 ***
		
		// '절대경로 (absolute path)' 를 이용한 File 객체 생성
		String tempDirPath = System.getProperty("user.dir") + File.separator + "temp";
		
		System.out.println("절대경로 : " + tempDirPath);
		File tempDir = new File(tempDirPath);
		
		File[] list2 = tempDir.listFiles();
		
		for( File e : list2) {
			if(e.isDirectory()) {
				System.out.print("DIR\t");
			} else {
				System.out.print("FILE\t");
			}
			System.out.print(e.getName() + "\t\t");
			System.out.println(e.length() + "byte");
		}
		
		
		
		System.out.println();
		// 파일 하나에 대한 정보
		String path = "dummy.txt";
		File f = new File(path); // 새로운 File 객체 생성!
		// --> 이런다고 파일이 생기지 않는다
		// File 객체를 생성했다고 물리적인 파일이 만들어지지 않는다
		
		System.out.println("파일이름 : " + f.getName()); // 상대 경로명
		System.out.println("절대 경로 : " + f.getAbsolutePath()); // 절대 경로명!!
		
		// 실제로 존재할까?
		System.out.println("있냐? " + f.exists()); // boolean 타입을 리턴
		
		
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end File11Main


















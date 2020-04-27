package com.lec.java.file17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	1. URL : 웹 상의 주소, 
 * 	2. HttpURLConnection : 웹연결
 * 		  URLConnection
 * 		   └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 * 
 * 
 * 	GET 방식의 장점 : 북마크가 된다 파라미터가 저장되어서 요청하는 웹페이지를 바로 받는다
 * 			단점 : 보안성이 없고, 데이터가 큰 것들은 담을수 없다.
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");

		String url = "https://www.naver.com/srchrank?frm=main&ag=all&gr=1&ma=-2&si=0&en=0&sp=0";
		StringBuffer sb = readFromUrl(url);
		System.out.println(sb);
//		System.out.println(sb.toString().substring(0, 200));

		System.out.println("\n프로그램 종료");
	} // end main()

	/**
	 * 
	 * @param ulrAddress : 주어진 url 주속
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체
		URL url = null; // java.net.URL
		HttpsURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null; // byte 타입
		InputStreamReader reader = null; // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null;

		char[] buf = new char[512]; // 문자용 버퍼

		// BufferedReader <-- InputStreamReader <-- InputStream <-- HttpsURLConnection

		try {
			url = new URL(urlAddress);
			conn = (HttpsURLConnection) url.openConnection();

			if (conn != null) {
				
				// 2초 이내에 연결이 수립 안되면 
				// java.net.SocketTimeException 발생
				conn.setConnectTimeout(2000);

				conn.setRequestMethod("GET"); // GET 방식 request
												// "GET", "POST"

				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시사용안함

				System.out.println("request 시작 : " + urlAddress);

				// request 발생
				conn.connect(); // 이후 response 받을때까지 delay

				// 서버가 폭주한다는 뜻은 request가 폭주한다는 뜻이랑 같음

				System.out.println("response 완료");

				// response 받은후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("Response Code : " + responseCode);
				// https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if (responseCode == HttpURLConnection.HTTP_OK) {
					// TODO
					in = conn.getInputStream(); //InputStream <-- HttpsURLConnection
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <-- InputStream
					br = new BufferedReader(reader); // BufferedReader <-- InputStreamReader
					
					int cnt;; // 읽은 글자 개수
					while((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt); // response 받은 텍스트를 StringBuffer 에 추가
					}
					
					
				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(conn != null) conn.disconnect(); // 작업 끝나고 Connection 해제 (Connection도 자원이라서 해제가 필요하다)
			
		}

		return sb;
	}

} // end class

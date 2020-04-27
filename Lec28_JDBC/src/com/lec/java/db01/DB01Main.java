package com.lec.java.db01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

/*
JDBC (Java DataBase Connectivity) 사용
 0. 라이브러리(jar) 추가:
  1) 이클립스 프로젝트 폴더에 libs 폴더를 생성
  2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar
 파일을 libs 폴더로 복사
  3) 복사한 라이브러리를 빌드패스에 추가   
		BulidPath - Configure Build Path..
		Libraries 탭에서  [Add JARs..]   ->  위 libs 폴더의 ojdbc6_g.jar 파일 추가
		Order and Export 탭에서  우선순위 Up (권장)

 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
*/

// er-diagram 만들기
// http://ermaster.sourceforge.net/update-site

public class DB01Main {

	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	// DB 서버 접속 주소 (url) 정보
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// DB 접속 사용자 계정 정보
	public static final String USER = "scott0316";
	public static final String PASSWORD = "tiger0316";

	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
		Connection conn = null; // java.sql.Connection 패키지 안에 있다
		Statement stmt = null; // java.sql.Statement
		ResultSet rs = null; // java.sql.ResultSet
		
		try {
			// 2. JDBC 드라이버 클래스를 메모리에 로드
			Class.forName(DRIVER); // <-- 동적 클래스 로딩
			System.out.println("드라이버 클래스 로딩 성공");

			// 3. DB와 connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB Connect 연결");
			
			// 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			
			// 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
			System.out.println();
			String sql_insert = "INSERT INTO test_member VALUES(100, '마장가', SYSDATE)";
			
			// sql_insert = "INSERT INTO test_member(mb_no) VALUES(101)";
			
			//int no = 200;
			//String name = "뽀로로";
			//sql_insert = "INSERT INTO test_member VALUES(" + no + ", '" + name + "', SYSDATE)";
			
			System.out.println(sql_insert);
			int count = stmt.executeUpdate(sql_insert); // DML 명령은 executeUpdate()로 실행한다.
														// 리턴값이 정수(int)
			
			System.out.println(count + "개 row(행)이 INSERT 됨");
			
			System.out.println();
			String sql_select = "SELECT mb_no mm, mb_name, mb_birthdate FROM test_member";
			System.out.println(sql_select);
			
			rs = stmt.executeQuery(sql_select); // 'SELECT' 및 기타 쿼리의 경우 executeQuery()로 실행
										   // 리턴값은 ResultSet 객체
			
			// ResultSet 에 담겨 있는 record 확인
			// 7. 실행 결과 확인
			// 7-1 컬럼 이름으로 받기
			System.out.println();
			/*
			 * while(rs.next()) { // next() 레코드 하나 추출하고 true리턴, 더 이상 뽑아 낼거 없으면 false 리턴
			 * 
			 * String no = rs.getString("mm"); // getXXX() 에 '컬럼명' 혹은 '별명' 명시 String name =
			 * rs.getString("mb_name"); String birthdate = rs.getString("mb_birthdate");
			 * String result = no + "\t |" + name + "\t |" + birthdate;
			 * System.out.println(result); } // while
			 */			
			System.out.println();
			// 7-2 컬럼 인덱스로 받기
			/*
			 * while(rs.next()) { // next() 레코드 하나 추출하고 true리턴, 더 이상 뽑아 낼거 없으면 false 리턴
			 * 
			 * String no = rs.getString(1); // getXXX() 에 에 인덱스 로 명시 (1부터 시작!!) String name
			 * = rs.getString(2); String birthdate = rs.getString(3); String result = no +
			 * "\t |" + name + "\t |" + birthdate; System.out.println(result); }
			 */
			
			// 7-3 null 처리하기
			// getXXX() 로 가져온 데이터가 NULL 값이면 null로 리턴한다.
			/*
			 * while(rs.next()) { // next() 레코드 하나 추출하고 true리턴, 더 이상 뽑아 낼거 없으면 false 리턴
			 * 
			 * String no = rs.getString(1); // getXXX() 에 에 인덱스 로 명시 (1부터 시작!!) if(no ==
			 * null) no = ""; String name = rs.getString(2); String birthdate =
			 * rs.getString(3); if(birthdate == null) birthdate = ""; String result = no +
			 * "\t |" + name + "\t |" + birthdate; System.out.println(result); } // while
			 */			
			
			// 7-4 개별적인 타입으로 get하기
			while(rs.next()) { // next() 레코드 하나 추출하고 true리턴, 더 이상 뽑아 낼거 없으면 false 리턴
				
				int no = rs.getInt(1); // getXXX() 에 에 인덱스 로 명시 (1부터 시작!!)
				// mb_no 컬럼값이 null이면 0을 리턴
				String name = rs.getString(2);
				String birthdate = "";
				Date d = rs.getDate("mb_birthdate"); // 날짜만 가져온다
				Time t = rs.getTime("mb_birthdate"); // 시간만 가져온다
				
				if(d != null) {
					birthdate = new SimpleDateFormat("yyyy년MM월dd일").format(d) + " "
								+ new SimpleDateFormat("hh:mm:ss").format(t); 
				}
				
				String result = no + "\t |" + name + "\t |" + birthdate;
				System.out.println(result);
			} // while
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 나중에 만들어진 instance부터 먼저 close() 해준다.
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	} // end main()

} // end class DB01Main

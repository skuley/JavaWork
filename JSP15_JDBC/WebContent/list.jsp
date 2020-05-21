<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> <!-- JDBC 관련 import -->
<%@ page import="java.text.SimpleDateFormat" %>

<%! 
	// JDBC 관련 기본 객체 변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()
	int cnt = 0; // DML 결과, executeUpdate()
	
	// Connection 에 필요한 값 세팅
	String driver = "oracle.jdbc.driver.OracleDriver"; // JDBC 드라이버 클래스
	String url = "jdbc:oracle:thin:@localhost:1521:XE"; // DB 접속 url jdbc:oracle:thin:@localhost:1521:XE
	String userid = "scott0316"; // DB 접속 계정 정보
	String userpw = "tiger0316";
%>

<%!
	// 쿼리문 준비 
	final String SQL_WRITE_SELECT = 
		"SELECT * FROM test_write ORDER BY wr_uid DESC";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<style type="text/css">
	table{width:100%;}
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>

<%
	try{
		Class.forName(driver);
		out.println("드라이버 성공" + "<br>");
		conn = DriverManager.getConnection(url, userid, userpw);
		out.println("conn 성공" + "<br>");
		
		// 트랜잭셕 실행
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT);
		rs = pstmt.executeQuery();
		out.println("쿼리 성공!!<br>");
		
%>

	<hr>
	<h2>리스트</h2>
	<table>
		<tr>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
<%
	while(rs.next()){
		out.println("<tr>");
		int uid = rs.getInt("wr_uid");
		String subject = rs.getString("wr_subject");
		String name = rs.getString("wr_name");
		int viewcnt = rs.getInt("wr_viewcnt");
		Date d = rs.getDate("wr_regdate");
		Time t = rs.getTime("wr_regdate");
		
		String regdate = "";
		if(d != null){
			regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " "
					+ new SimpleDateFormat("hh:mm:ss").format(t);
		}
		
		out.println("<td>" + uid + "</td>");
		out.println("<td><a href='view.jsp?uid=" + uid + "'>" + subject + "</a></td>");
		out.println("<td>" + name + "</td>");
		out.println("<td>" + viewcnt + "</td>");
		out.println("<td>" + regdate + "</td>");
		
		out.println("</tr>");
	} //end while
%>		
	</table>
	<br>
	<button onclick="location.href='write.jsp'">신규등록</button>

<% 		
	}catch(Exception e){
		e.printStackTrace();
		// 예외 처리 (모든 예외)
	}finally{
		// 리소스 (자원) 해제
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>



</body>
</html>
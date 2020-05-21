<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> <!-- JDBC 관련 import -->
<%@ page import="java.text.SimpleDateFormat" %>

<%
	int curPage = 1; // 현재 페이지 (디폴트 1페이지로 세팅!!)
	
	// 현재 몇 페이지인지 파라미터 받기
	String pageParam = request.getParameter("page");
	if(pageParam != null && !pageParam.trim().equals("")){
		try{
			// 1이상의 자연수 이어야 한다
			int p = Integer.parseInt(pageParam);
			if(p > 0) curPage = p;
		} catch(NumberFormatException e){
			e.printStackTrace();
		}
	}
%>

<%! 
	// JDBC 관련 기본 객체 변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // SELECT 결과, executeQuery()
	int cnt = 0; // DML 결과, executeUpdate()
	
	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // JDBC 드라이버 클래스
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; // DB 접속 url jdbc:oracle:thin:@localhost:1521:XE
	final String USERID = "scott0316"; // DB 접속 계정 정보
	final String USERPW = "tiger0316";
%>

<%!
	// 쿼리문 준비 
	/* final String SQL_WRITE_SELECT = 
		"SELECT * FROM test_write ORDER BY wr_uid DESC"; */
		
	// 페이징 
	// 글 목록 전체 개수 가져오기
	final String SQL_WRITE_COUNT_ALL = 
		"SELECT count(*) FROM test_write";
		
	// 특정 페이지의 글을 가져오기
	// fromRow 부터 pageRows 만큼 SELECT
	// (몇번째) 부터 (몇개) 만큼
	final String SQL_WRITE_SELECT_FROM_ROW = "SELECT * FROM " +
			"(SELECT ROWNUM AS RNUM, T.* FROM (SELECT * FROM test_write ORDER BY wr_uid DESC) T) " + 
					"WHERE RNUM >= ? AND RNUM < ?";

	// 페이징 관련 세팅 값들
	int writePages = 10; // 한 [페이징] 에 몇개의 '페이지' 를 표현할 것인가?
	int pageRows = 8; // 한 '페이지' 에 몇개의 글을 리스트업 할 것인가?
	int totalPage = 0; // 총 몇 '페이지' 분량인가?

%>

<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>");
		
		// 트랜잭셕 실행
		// 일단 갯수부터 갖고 들어와야한다
		pstmt = conn.prepareStatement(SQL_WRITE_COUNT_ALL);
		rs = pstmt.executeQuery();
		
		if(rs.next()) cnt = rs.getInt(1); // count(*) 값이 하나 밖에 없다, 전체 글을 개수
		
		rs.close();
		pstmt.close();
		
		totalPage = (int)Math.ceil(cnt / (double)pageRows); // 총 몇페이지 분량
		
		int fromRow = (curPage - 1) * pageRows + 1; // 몇번째 row 부터? 
		
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_FROM_ROW);
		pstmt.setInt(1, fromRow);
		pstmt.setInt(2, fromRow + pageRows);
		rs = pstmt.executeQuery();
		
		
		/* out.println("쿼리 성공!!<br>"); */
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록 <%= curPage %> 페이지</title>
<style type="text/css">
	table{width:100%;}
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
<!-- 페이징 -->
<link rel="stylesheet" type="text/css" href="CSS/common.css"/>
<script src="https://kit.fontawesome.com/bb29575d31.js"></script>
</head>
<body>

	<hr>
	<h2>리스트 <%= curPage %> 페이지</h2>
	<h4><%= cnt %>개</h4> <!-- 전체 글 개수 -->
	<table>
		<tr>
			<th>row</th> <!-- row 번호 -->
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
<%
	while(rs.next()){
		out.println("<tr>");
		
		int rnum = rs.getInt("rnum"); // rownum 받아오기
		
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
		
		out.println("<td>" + rnum + "</td>");
		out.println("<td>" + uid + "</td>");
		out.println("<td><a href='view.jsp?uid=" + uid + "&page=" + curPage + "'>" + subject + "</a></td>");
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
<%-- 페이징 --%>
<jsp:include page="pagination.jsp">
	<jsp:param value="<%= writePages %>" name="writePages"/>
	<jsp:param value="<%= totalPage %>" name="totalPage"/>
	<jsp:param value="<%= curPage %>" name="curPage"/>
</jsp:include>


</body>
</html>
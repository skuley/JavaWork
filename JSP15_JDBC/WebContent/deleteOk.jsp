<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> <!-- JDBC 관련 import -->

<% // parameter 받아오기

	int uid = Integer.parseInt(request.getParameter("uid"));
	// 이단계에서 parameter 검증 필요
	

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
	final String SQL_WRITE_DELETE_UID = 
		"DELETE FROM test_write WHERE wr_uid = ?";
%>

<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>");
		
		// 트랜잭셕 실행
		pstmt = conn.prepareStatement(SQL_WRITE_DELETE_UID);
		pstmt.setInt(1, uid);
		
		cnt = pstmt.executeUpdate();
		
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

<% if(cnt == 0){ %>
	<script type="text/javascript">
		alert('삭제 실패!!');
		history.back();
	</script>
<% } else { %>
	<script type="text/javascript">
		alert('삭제 성공');
		location.href = "list.jsp";
	</script>
<% } %>

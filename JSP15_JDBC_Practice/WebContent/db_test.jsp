<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	// JDBC 기본 변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int cnt = 0;
	
	// Connection 에 필요한 값 세팅하기
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";
%>

<%
	try{
		Class.forName(DRIVER);
		out.println("driver 연결 성공");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("connection 연결 성공");
		
	} catch(Exception e){
		e.printStackTrace();	
	} finally {
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
		
%>
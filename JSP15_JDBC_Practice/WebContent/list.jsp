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

<% // 쿼리문 준비
	// TODO
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try{
		Class.forName(DRIVER);
		out.println("driver 연결 성공");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("connection 연결 성공");
		
%>

	<h2>SNS TABLE</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Post</th>
			<th>Date</th>
			<th>Views</th>
		</tr>
<%	while(rs.next()){ 
	int uid = rs.getInt("sns_uid");	
	String name = rs.getString("sns_name");
	String post = rs.getString("sns_post");
	Date d = rs.getDate("sns_regdate");
	Date t = rs.getDate("sns_regdate");
	
	String regdate = "";
	if(d != null){
		regdate = new SimpleDateFormat("yyy-MM-dd").format(d) + " "
				+ new SimpleDateFormat("hh:mm:ss").format(t);
	}
	
	int cntview = rs.getInt("sns_cntview");
%>
		<tr>
			<td><%= name %></td>
			<td><%= post %></td>
			<td><%= regdate %></td>
			<td><%= cntview %></td>
		</tr>
			
	</table>
	<br>
	<button onclick="location.href='write.jsp'">신규등록</button>
<% } %>
<% 
		
	} catch(Exception e){
		e.printStackTrace();
		out.println("alert('실패');");
	} finally {
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
%>

</body>
</html>
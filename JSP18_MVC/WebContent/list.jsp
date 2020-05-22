<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!-- JDBC 관련 import -->
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.lec.beans.*" %>

<% // Controller로부터 결과 데이터 받아오기
	WriteDTO[] arr = (WriteDTO[])request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<style type="text/css">
table {
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
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
	if(arr != null){
		for(int i = 0; i < arr.length; i++){
%>
		<tr>
			<td><%= arr[i].getUid() %></td>
			<td><a href="view.do?uid=<%=arr[i].getUid()%>">
				<%= arr[i].getSubject() %>
			</a></td>
			<td><%= arr[i].getName() %></td>
			<td><%= arr[i].getViewCnt() %></td>
			<td><%= arr[i].getRegdate() %></td>
		</tr>
<%
		} // end for
	} // end if
%>
		
	</table>
	<br>
	<button onclick="location.href='write.do'">신규등록</button>
</body>
</html>
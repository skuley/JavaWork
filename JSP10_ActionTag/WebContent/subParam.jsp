<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>subParam</title>
</head>
<body>
<%!	String id, pw; %>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
%>

<h3>현재  페이지는 subParam 입니다.</h3>
아이디 : <%= id %><br>
비밀번호 : <%= pw %><br>
</body>
</html>
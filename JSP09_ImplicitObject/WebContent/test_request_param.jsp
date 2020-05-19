<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request parameter</title>
</head>
<body>
<%!
	String data1, data2;
	String name, id, pw, gender, local, memo;
	String [] hobbys;
	
%>
<%
	request.setCharacterEncoding("utf-8");

	data1 = request.getParameter("data1").trim();
	data2 = request.getParameter("data2").trim();
	name = request.getParameter("name").trim();
	
	id = request.getParameter("id").trim();
	pw = request.getParameter("pw").trim();
	
	hobbys = request.getParameterValues("hobby");
	gender = request.getParameter("gender").trim();
	local = request.getParameter("local").trim();
	memo = request.getParameter("memo").trim();
	
%>

hidden : <%= data1 %>, <%= data2 %><br>
이름 : <%= name %><br>
아이디 : <%= id %><br>
비밀번호 : <%= pw %><br>
취미 : <%= Arrays.toString(hobbys) %><br>
지역 : <%= local %><br>
메모 : <%= memo %>

</body>
</html>
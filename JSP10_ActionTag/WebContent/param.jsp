<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param</title>
</head>
<body>
<!-- Action Tag -->
<h3>현재 page는 param page 입니다.</h3>
<%
	int num = 788;
%>

<jsp:forward page="subParam.jsp">
	<jsp:param value='test123' name="id"/>
	<jsp:param value="<%= num %>" name="pw"/>
</jsp:forward>

<p>위 라인의 내용은 subParam 의 내용입니다 </p>

</body>
</html>
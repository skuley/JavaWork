<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int sum = 0;
	for(int cnt = 1; cnt <= 100; cnt++){
		sum += cnt;
	
	}
	%>
	1부터 100까지의 합은 : <%= sum %>
	
	<hr>
	
	<h3>오늘의 식단</h3>
		- 비빔밥<br>
		- 개구리밥<br>
		- 스폰지밥<br>
	<%@ include file = "test.jsp"%>
</body>
</html>
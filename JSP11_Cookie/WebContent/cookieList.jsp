<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie List</title>
</head>
<body>
<%
	// 사용자 컴퓨터 안의 쿠키 정보는 request 시에 서버로 전달된다.
	// request.getCookies() 로 쿠키 받아온다.
	Cookie[] cookies = request.getCookies();
	if(cookies != null){ // 만약 쿠키가 하나도 없다면 null 리턴
		for(int i = 0; i < cookies.length; i++){
			String cookieName = cookies[i].getName(); // 쿠키 이름
			String cookieValue = cookies[i].getValue(); // 쿠키 '값'
			out.println((i + 1) + " ] " + cookieName + " : " + cookieValue + "<br>");
		} 
	} else{
		out.println("쿠키가 없습니다");
	}
%>

<hr>

<form action="cookieCreate.jsp">
	<input type="submit" value="쿠키 생성&갱신">
</form>
<br>
<form action="cookieDelete.jsp">
	<input type="submit" value="쿠키삭제">
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<%!	int i = 0;%>
<%
	Cookie[] cookies = request.getCookies(); // Cookie[] 배열 리턴
	String cookieName = "userid"; // 로그인 성공하면 발급되는 쿠키 이름.
	
	if(cookies != null){
		for(i = 0; i < cookies.length; i++){
			if(cookieName.equals(cookies[i].getName())){ // <-- userid 라는 이름이 있다면, 즉 쿠키가 있다면...
				break;
			} // end if
		} // end for
	} // end if
%>

<%if(cookies == null || i == cookies.length){ %>
		<h2>로그인 상태가 아닙니다</h2>
		<form action="loginOk.jsp">
			id:<input type="text" name="userid"><br>
			pw:<input type="password" name="pw"><br>
			<input type="submit" value="로그인">
		</form>
<% } else{ %>
		<h2>로그인 상태입니다</h2>
		<form action="logout.jsp">
			<input type="submit" value="로그아웃">
		</form>
<% } %>
</body>
</html>
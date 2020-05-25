<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>EL 내장 객체</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String[] hobby = request.getParameterValues("hobby");
%>

	아이디: <%= id %><br>
	비밀번호: <%= pw %><br>
	취미:
<%
	for(int i = 0; i < hobby.length; i++){ %>
		<%= hobby[i] %>
	
<%	} %>
<hr>

아이디 : ${ param.id }<br>
비밀번호 : ${ param.pw }<br>
취미 : ${ paramValues.hobby[0] } ${ paramValues.hobby[1] } ${ paramValues.hobby[2] }<br>
<hr>

아이디 : ${ param["id"] }<br>
비밀번호 : ${ param["pw"] }<br>
취미 : ${ paramValues["hobby"][0] } ${ paramValues["hobby"][1] } ${ paramValues["hobby"][2] }<br>
<hr>

application : ${ applicationScope.application_name }<br>
session : ${ sessionScope.session_name }<br>
pageScope : ${ pageScope.page_name }<br>
<!-- submit 이 되었다면 request가 끝나고 새로운 request 가 발생하기 때문에 기존 request는 끝난다 -->
request : ${ requestScope.request_name }<br>
<hr>

context 초기화 param <br>
${ initParam.con_name }<br>
${ initParam.con_id }<br>
${ initParam.con_pw }<br>
<hr>

ContextPath<br>
<%= request.getContextPath() %><br>
${ pageContext.request.contextPath }<br>








</body>
</html>
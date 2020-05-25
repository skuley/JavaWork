<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 2</title>
</head>
<body>

<h2>set, remove, out</h2>
<c:set var="name" value="장윤성"/>

이름: <c:out value='Jang'/><br>
이름: <c:out value='${ name }'/><br> <!-- JSTL 변수는 EL에서 사용 가능 -->
${ name }<br>

<c:remove var="name"/>
이름: <c:out value='${ name }'/><br>
이름: ${ name }<br>
<hr>

<%
	int age = 10;	
%>

나이 : ${ age }<br> <!-- Java → EL (X) -->
<c:set var="age" value="<%= age %>"/>
나이 : ${ age }<br> <!-- Java → JSTL → EL (O) -->
<hr>

<h2>catch</h2>

<c:catch var="error">
<!-- 이 안에서 예외 발생하면 예외 객체를 error 변수에 담는다 -->
	<%= 2 / 0 %>
</c:catch>

<c:out value="${ error }"></c:out><br>

<c:catch var="ex">
name parameter 값 = <%= request.getParameter("name") %><br>
<% if(request.getParameter("name").equals("test")){ // 예외 발생 %>
	${ param.name }은 test 입니다.
<%} %>
</c:catch>

<br>

<c:if test="${ ex != null }">
	예외 발생!<br>
	${ ex }<br>
</c:if>



</body>
</html>
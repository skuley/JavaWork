<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이 페이지는 에러 핸들링을 위한 페이지 이다 --%>
<%@ page isErrorPage="true" %>
<%-- reponse code 를 정상 처리를 해줘야한다 --%>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 안내</title>
</head>
<body>
에러가 발생했씁니다...<br>
예외 타입은 : <%= exception.getClass().getName() %><br>
예외 메세지 : <%= exception.getMessage() %>
</body>
</html>
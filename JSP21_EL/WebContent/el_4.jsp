<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.WriteDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>EL request</title>
</head>
<body>

<% // EL 을 사용하면  reqeust 객체 안의  내용을 손쉽게  출력 가능
	pageContext.setAttribute("myage", "응~");
	request.setAttribute("myage", 30);
	request.setAttribute("mydto", new WriteDTO(100, "제목", "내용", "작성자", 3));
%>

${ myage }<br>
${ requestScope.myage }<br>

${ mydto}<br> <!-- toString() overriding된 값 -->
${ mydto.uid }<br>
<%= ((WriteDTO)request.getAttribute("mydto")).getUid() %><br>
${ mydto.subject }<br>
${ mydto.content }<br>

</body>
</html>
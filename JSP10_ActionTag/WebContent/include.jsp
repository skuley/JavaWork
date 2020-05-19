<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<body>

<!-- Action Tag -->
<h3>지금의 페이지는 include 페이지 입니다.</h3>
<%@ include file="sub.jsp" %>
<p>위 라인의 내용은 sub 페이지의 내용입니다</p>

<hr>

<!-- Directive -->
<h3>지금의 페이지는 include 페이지 입니다.</h3>
<jsp:include page="sub.jsp"/>
<p>위 라인의 내용은 sub 페이지의 내용입니다</p>

<hr>

<%!
	// 변수 선언
	String name = "홍길동";
	int age = 33;
%>
<%-- <%@ include file="sub2.jsp" %> --%>

<%@ include file="sub2.jsp" %>

<hr>

<jsp:include page="sub3.jsp">
	<jsp:param value='<%= URLEncoder.encode(name, "utf-8") %>' name="name"/>
	<jsp:param value='<%= age %>' name="age"/>
</jsp:include>

<hr>



</body>
</html>
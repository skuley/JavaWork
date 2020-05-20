<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionName = "userid";
	
	session.removeAttribute(sessionName);
%>
<script type="text/javascript">
alert("로그아웃 성공!");
location.href = "login.jsp";
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String sessionName = "num1";
	
	// 세션삭제
	session.removeAttribute(sessionName);
	session.removeAttribute("datetime");
%>

<script type="text/javascript">
alert("<%= sessionName%>, <%="datetime"%> 세션 삭제");
location.href="sessionList.jsp";
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.lec.beans.*" %>
 --%>    
<%
	// DAO 사용한 트랜잭션
	int cnt = (Integer)request.getAttribute("updateOk");
	int uid = (Integer)request.getAttribute("upUid");
%>

<% if(cnt == 0){ %>
	<script type="text/javascript">
		alert('수정 실패!!');
		history.back();
	</script>
<% } else { %>
	<script type="text/javascript">
		alert('수정 성공');
		location.href = "view.do?uid=<%= uid %>";
	</script>
<% } %>

































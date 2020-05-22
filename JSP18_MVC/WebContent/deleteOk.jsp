<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/>

<% // parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// 이단계에서 parameter 검증 필요
%>

<%
	int cnt = dao.deleteByUid(uid);
%>

<% if(cnt == 0){ %>
	<script type="text/javascript">
		alert('삭제 실패!!');
		history.back();
	</script> 
<% } else { %>
	<script type="text/javascript">
		alert('삭제 성공');
		location.href = "list.jsp";
	</script>
<% } %>

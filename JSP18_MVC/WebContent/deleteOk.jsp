<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	int cnt = (Integer)request.getAttribute("deleteOk");
%>

<% if(cnt == 0){ %>
	<script type="text/javascript">
		alert('삭제 실패!!');
		history.back();
	</script> 
<% } else { %>
	<script type="text/javascript">
		alert('삭제 성공');
		location.href = "list.do";
	</script>
<% } %>

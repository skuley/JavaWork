<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>

<% // DAO 사용한 트랜잭션
	WriteDTO arr[] = (WriteDTO[])request.getAttribute("update");
%>
<%
	if (arr == null || arr.length == 0) {
%>

<script>
	alert("해당 정보가 삭제되거나 없습니다.");
	history.back();
</script>

<%
	return; // 더이상 jSP 프로세싱 하지 않고 종료
	}

%>
<%
	int uid = arr[0].getUid();
	String name = arr[0].getName();
	String subject = arr[0].getSubject();
	String content = arr[0].getContent();
	String regdate = arr[0].getRegdate();
	int viewCnt = arr[0].getViewCnt();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 <%= subject %></title>
</head>
<script>
function chkSubmit(){
	frm = document.forms['frm'];
	var subject = frm['subject'].value.trim();
	
	if(subject == ""){
		alert("제목은 반드시 작성해야 합니다");
		frm['subject'].focus();
		return false;
	}
	return true;
}
</script>
<body>
<h2>수정</h2>
<form name="frm" action="updateOk.do" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name="uid" value="<%= uid %>"/>
작성자 : <%= name %><br> <%-- 작성자 이름 변경 불가 --%>
제목 : 
<input type="text" name="subject" value="<%= subject %>"/><br>
내용: <br>
<textarea name="content"><%=content%></textarea>
<br>
<input type="submit" value="수정"/>
</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.do'">목록보기</button>

</body>
</html>






























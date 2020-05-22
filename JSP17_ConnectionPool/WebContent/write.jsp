<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function chkSubmit() {
		frm = document.forms["frm"];
		var name = frm["name"].value.trim();
		var subject = frm["subject"].value.trim();
		
		if(name == ""){
			alert("작성자가 비어 있습니다");
			frm["name"].focus();
			return false;
		}
		if(subject == ""){
			alert("제목이 비어 있습니다");
			frm["subject"].focus();
			return false;
		}
		return true;
	}
</script>
<body>
	<h2>글작성</h2>
	<%-- 글 내용이 많을수 있기 때문에 POST 방식 사용 --%>
	<form name="frm" action="writeOk.jsp" method="post"
		onsubmit="return chkSubmit()">
		작성자: <input type="text" name="name" /><br> 제목: <input type="text"
			name="subject" /><br> 내용:<br>
		<textarea name="content"></textarea>
		<br>
		<br> <input type="submit" value="등록" />
	</form>
	<br>
	<button type="button" onclick="location.href='list.jsp'">목록으로</button>
</body>
</html>
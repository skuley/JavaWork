<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*"%>


<%
	WriteDTO[] arr = (WriteDTO[])request.getAttribute("view");
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

<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>읽기 <%=subject%></title>
<!-- title에 글 제목 넣기 -->
</head>
<script>
function chkDelete(uid) {
	// 삭제 여부, 다시 확인 하고 진행하기
	var r = confirm('삭제하시겠습니까?');
	if(r){
		location.href = "deleteOk.do?uid=" + uid;
	}
}
</script>
<body>

	<h2>
		읽기
		<%=subject%></h2>
	<br> UID :
	<%=uid%>
	<br> 작성자 :
	<%=name%><br> 제목 :
	<%=subject%><br> 등록일 :
	<%=regdate%><br> 조회수 :
	<%=viewCnt%><br> 내용 :
	<br>
	<hr>
	<div>
		<%=content%>
	</div>
	<hr>
	<br>
	<button onclick="location.href='update.do?uid=<%=uid%>'">수정하기</button>
	<button onclick="location.href='list.do'">목록보기</button>
	<button onclick="chkDelete(<%=uid%>)">삭제하기</button>
	<button onclick="location.href='write.do'">신규등록</button>


</body>
</html>














































<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/CSS/common.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="${ pageContext.request.contextPath }/JS/board.js" type="text/javascript"></script>


<title>SPA 게시판</title>
</head>
<body>

	<h2>게시판 - SPA</h2>
	<%-- 글 목록 --%>
	<div id="list">
		
		<div>
		
			<div id="pageinfo"></div>
			<div id="pageRows"></div>
		
		</div>
		
		<div class="clear"></div>
		
		<table>
			<thead>
				<th>#</th>
				<th>UID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</thead>
			
			<tbody>
				<%-- 동적으로 들어와야할 데이터들을 담는 곳 --%>
			</tbody>
		</table>
		
	</div>
	
	<br>
	
	<%-- 페이징 --%>
	<div class="center">
		<ul class="pagination" id="pagination">
			
		</ul>
	</div>
	


</body>
</html>
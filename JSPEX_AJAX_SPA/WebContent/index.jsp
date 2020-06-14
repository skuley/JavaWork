<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath }/CSS/common.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="${ pageContext.request.contextPath }/JS/board.js"
	type="text/javascript"></script>


<title>SPA 게시판</title>
</head>
<body>

	<h2>게시판 - SPA</h2>
	<%-- 글 목록 --%>
	<div id="list">

		<div class="d01">
			<div id="pageinfo" class="left"></div>
			<div id="pageRows" class="right"></div>
		</div>

		<div class="clear"></div>
		<form id="frmList" name="frmList">
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
		</form>

		<%--버튼 --%>
		<div class="d01">
			<div class="left">
				<button type="button" id="btnDel" class="btn danger">글삭제</button>
			</div>
			<div class="right">
				<button type="button" id="btnWrite" class="btn success">글작성</button>
			</div>
		</div>

	</div>

	<br>

	<%-- 페이징 --%>
	<div class="center">
		<ul class="pagination" id="pagination">

		</ul>
	</div>

	<%--글작성 --%>
	<div id="dlg_write" class="modal">

		<form class="modal-content animate" id="frmWrite" name="frmWrite"
			method="post">

			<div class="container">
				<h3>새글 작성</h3>

				<span class="close" title="Close Modal">&times;</span> <label
					for="subject"><b>글제목</b></label> <input type="text"
					placeholder="글제목(필수)" name="subject" required> <label
					for="name"><b>작성자</b></label> <input type="text"
					placeholder="작성자(필수)" name="name" required> <label
					for="content"><b>내용</b></label>
				<textarea placeholder="글내용" name="content"></textarea>

				<button type="submit" class="btn success">작성</button>
			</div>
		</form>
	</div>








</body>
</html>
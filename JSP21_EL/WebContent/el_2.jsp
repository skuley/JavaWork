<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="com.lec.beans.WriteDTO" scope="page"/>
<jsp:setProperty property="uid" name="dto" value="123"/>
<jsp:setProperty property="subject" name="dto" value="제목입니다"/>
<jsp:setProperty property="name" name="dto" value="작성자입니다"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL - Action Tag</title>
</head>
<body>

	uid : <%= dto.getUid() %><br>
	제목 : <%= dto.getSubject() %><br>
	작성자 : <%= dto.getName() %><br>
	
	<hr>
	
	uid : <jsp:getProperty property="uid" name="dto"/><br>
	제목 : <jsp:getProperty property="subject" name="dto"/><br>
	작성자 : <jsp:getProperty property="name" name="dto"/><br>
	
	<hr>
	
	uid(EL) : ${ dto.uid }<br>
	제목(EL) : ${ dto.subject }<br>
	작성자(EL) : ${ dto.name }<br>
	댓글(EL) : ${ deee.comment }<br>

</body>
</html>
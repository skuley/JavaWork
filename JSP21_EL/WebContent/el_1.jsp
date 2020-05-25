<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>

<h3>Expression Language</h3>
${10 }<br>
${99.99 }<br>
${"ABC" }<br>
${true }<br>
<hr>

<h3>EL 의 연산자</h3>
${ 1 + 2  }<br>
${ 1 - 2 }<br>
${ 1 * 2 }<br>
${ 1 / 2 }<br>
${ 1 > 2 }<br>
${ 1 < 2 }<br>
${ 1 == 2 }<br>
${ (1 > 2) ? true : false }<br>
${ (1 > 2) || (1 < 2) }<br>
<hr>

<% int num = 10; %>

num: ${ num }<br> <!-- EL 은 Java 언어가 아니다 / 또한 에러가 안난다!! -->
num: <%= num %><br>


</body>
</html>
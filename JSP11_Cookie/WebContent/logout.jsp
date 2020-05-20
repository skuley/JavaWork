<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String cookieName = "userid";
String cookieValue = "";

Cookie cookie = new Cookie(cookieName, cookieValue);
cookie.setMaxAge(0); // 기존에 있다면 삭제해 버리기
response.addCookie(cookie);
%>

<script type="text/javascript">
alert("로그아웃 성공!");
location.href = "login.jsp";
</script>
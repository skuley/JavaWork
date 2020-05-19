<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*"%>
<%!
	String name, age;
%>

<%
	name = URLDecoder.decode(request.getParameter("name"), "utf-8");
	age = request.getParameter("age");
%>

이름 : <%= name %><br>
나이 : <%= age %><br>
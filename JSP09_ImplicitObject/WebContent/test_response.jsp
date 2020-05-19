<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! int age; %>
<%
 	String str = request.getParameter("age");
 	age = Integer.parseInt(str);
 	// 산술 연산이 가능하게 해주려면 받아온 나이값을 int형 으로 바꿔줘야한다 (parseInt)
 	
 	if(age >= 19){
 		response.sendRedirect("adult.jsp?age=" + age);
 	}else{
 		response.sendRedirect("underage.jsp?age=" + age);
 	} 	
%>

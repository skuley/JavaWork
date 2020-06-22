<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String servlet_request_uri = (String)request.getAttribute("javax.servlet.forward.request_uri");
	String conPath = request.getContextPath();
	
	/* System.out.println(servlet_request_uri);
	System.out.println(conPath); */
	
	String servlet_reqpath = servlet_request_uri.substring(conPath.length());
	String uri = request.getRequestURI();
	String reqPath = uri.substring(conPath.length());
	String url = request.getRequestURL().toString();
	
	// jsp 파일명
	String jspFile = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
	String jspName = uri.substring(uri.lastIndexOf("/") + 1, uri.length() - 4);
	request.setAttribute("jspName", jspName);
	
	System.out.println(servlet_reqpath);
	System.out.println(uri);
	System.out.println(reqPath);
	System.out.println(url);
	System.out.println(jspFile);
	System.out.println(jspName);
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= jspName %></title>
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/CSS/sts_common.css">
</head>
<body>
<hr>
<div class="sts">
<b>Servlet</b>

request URI : <span><%= servlet_request_uri %></span><br>
context path : <span><%= conPath %></span><br>
request path : <span><%= servlet_reqpath %></span><br>
VIEW file : <span><%= jspFile %></span><br>
<hr>
<b>VIEW(JSP)</b><br>
url : <span><%= url %></span><br>
VIEW Path : <span><%= reqPath %></span><br>
uri : <span><%= uri %></span><br>
</div>
</body>
</html>
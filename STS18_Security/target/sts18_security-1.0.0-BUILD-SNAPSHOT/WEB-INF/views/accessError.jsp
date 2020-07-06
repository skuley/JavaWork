<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-07-06
  Time: 오후 3:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Access Denied Page</title>
</head>
<body>

    <h1>Access Denied Page</h1>
    <h2><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></h2>
    <h2><c:out value="${msg}"/></h2>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="request"/>
<jsp:setProperty property="count" name="cnt"/>
<%-- cnt.setCount(Integer.parseInt(request.getParameter("count"))) --%>

<h3>request1<br>cnt의  getCount 호출</h3>

<jsp:getProperty property="count" name="cnt"/>
<%-- cnt.getCount() --%>

<!-- <a href="scope2_request2.jsp">request2로...</a> -->
<jsp:forward page="scope2_request2.jsp"/>

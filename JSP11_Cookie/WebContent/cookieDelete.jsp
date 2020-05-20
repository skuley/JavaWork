<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String cookieName = "num1";
	
	if(cookies != null){
		for(int i = 0; i < cookies.length; i++){
			if(cookieName.equals(cookies[i].getName())){
				// 클라이언트 보고 삭제하라고 해준다
				cookies[i].setMaxAge(0); // expiry 를 0으로 하면 
				response.addCookie(cookies[i]); // response 직후 곧바로 삭제됨.
			}
		}
	}
%>

<script type="text/javascript">

alert("<%= cookieName %> 쿠키 삭제");
location.href= "cookieList.jsp";

</script>
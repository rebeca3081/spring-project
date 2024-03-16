<%@page import="java.util.Date"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>now.jsp</title>
</head>
<body>
<h2>시간 알림 서비스</h2>
현재 날짜와 시간은
	<%= request.getAttribute("today") %>
	<br>
	<b><font color= "red">${requestScope.today }</font></b>
입니다.
	<br>
	클라이언트 IP <%= request.getRemoteAddr() %>
	<hr>
	EL ${pageContext.request.remoteAddr }
	<br><br>
	클라이언트 브라우저 정보 <%= request.getHeader("User-Agent") %>
	<hr>
	EL ${header["User-Agent"] }
	<br><br>
	<%= request.getParameter("name") %>
	<hr> EL ${param.name }
	<br> <%= request.getCookies()[2].getValue() %>
	<hr> EL ${cookie.cart.value }
	
	<div>
		<h2>내 태그</h2>
		<my:myselect></my:myselect>
	</div>
</body>
</html>
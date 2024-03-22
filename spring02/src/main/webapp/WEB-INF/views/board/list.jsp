<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.html</title>
<script src=`${pageContext.request.contextPath}/scripts/jquery-3.2.1.min.js`></script>
</head>
<body>
	<h2>게시글 목록</h2>
	<a href="./board/insert">게시글 등록</a>
	<table border="1">
		<tr>
			<th>BOARD_NO</th>
			<th>TITLE</th>
			<th>CONTENT</th>
			<th>WRITER</th>
			<th>WRITE_DATE</th>
			<th>CLICK_CNT</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
		<tr>
			<td>${board.boardNo}</td>
			<td>${board.title}</td>
			<td>${board.content}</td>
			<td>${board.writer}</td>
			<td>${board.writeDate}</td>
			<td>${board.clickCnt}</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>
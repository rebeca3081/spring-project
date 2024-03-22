<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert.html</title>
</head>
<body>
	<h3>게시글(등록, 수정)</h3>
	
	<a href="./board/list">게시글 목록</a>
	
	<form method="post" name="frm" action="./boardInsert"
			enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>TITLE</th>
				<td><input name="title"></td>
				<th>WRITER</th>
				<td><input name="writer"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td colspan="3">
					<textarea rows="20" cols="100" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>FILE</th>
				<td colspan="3">
					<input type="file" name="file">
				</td>
			</tr>
			<tr>
				<th>WRITE_DATE</th>
				<td><input name="writeDate"></td>
				<td colspan="2" style="text-align: center;">
					<button type="submit">등록</button>
					<button type="submit">수정</button>
				</td>
			</tr>
		</table>
	</form>
</body>

</html>
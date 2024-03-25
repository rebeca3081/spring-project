<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<title>도서 조회</title>

<script>
/*
function addComma(price) {
	return price.toLocaleString();
}
*/
</script>

</head>


<body>
	<header>
		<h1>도서대여관리</h1>
	</header>
	<nav>
		<ul>
			<li><a href="../book/insert">도서 등록</a></li>
			<li><a href="../book/list">도서 목록 조회/수정</a></li>
			<li><a href="../book/rentlist">대여 현황 조회</a></li>
			<li><a href="/">홈으로</a></li>
		</ul>
	</nav>
	<section>
		<h3>도서 조회/수정</h3>
		<table border="1">
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>표지</th>
					<th>출판일자</th>
					<th>금액</th>
					<th>출판사</th>
					<th>도서소개</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${bookList}"> 
					<tr>
						<td>${book.bookNo}</td>
						<td>${book.bookName}</td>
						<td>
							<img src="../resources/images/${book.bookCoverimg}" style="width:100px;">
						</td>
						<td>${book.bookDate}</td>
						<td>${book.bookPrice}</td>
						<td>${book.bookPublisher}</td>
						<td>${book.bookInfo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	<footer>
			<span>HRDKOREA~~</span>
	</footer>
	
	
</body>
</html>
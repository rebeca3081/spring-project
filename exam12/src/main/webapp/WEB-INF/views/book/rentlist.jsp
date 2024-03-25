<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html><html><head><title>  </title></head>
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
		<h3>도서별 대여 매출 현황</h3>
		<table border="1">
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>대여총계</th>
					<th>대여횟수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rent" items="${rentList}"> 
					<tr>
						<td>${rent.bookNo}</td>
						<td>${rent.bookName}</td>
						<td>${rent.sum}</td>
						<td>${rent.cnt}</td>
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